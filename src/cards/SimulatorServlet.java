/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.PrintWriter;
import java.io.IOException;
import org.apache.log4j.*;
import java.util.List;
import toolbox.stats.*;

/**
 *
 * @author paul
 */
public class SimulatorServlet extends HttpServlet {
    
    private static final int DEFAULT_NUM_RUNS = 10000;
    private static Appender appender;
    private boolean addedAppender = false;
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        
        out.println("<html><head><title>Texas Hold 'em Simulator</title><script src=\"ga.js\"></script></head><body>");
        out.println("<p>This page shows a <a href=\"http://en.wikipedia.org/wiki/Monte_Carlo_algorithm\"  target=\"blank\">monte carlo simulation</a> of <a href=\"http://en.wikipedia.org/wiki/Texas_hold_%27em\"  target=\"blank\">Texas Hold 'em</a> deals</p>");
        out.println("<form action=\"\">");
        out.println("enter number of deals:  <input type=text name=numruns>");
        out.println("<input type=submit value=run");
        int numRuns = DEFAULT_NUM_RUNS;
        if(request.getParameter("numruns") != null) {
            try {
                numRuns = Integer.parseInt(request.getParameter("numruns"));
            } catch(NumberFormatException e) {
                //use default
                numRuns = DEFAULT_NUM_RUNS;
                out.println("<br>num runs parameter of " + request.getParameter("numruns") + " was not valid, using default of " + DEFAULT_NUM_RUNS + " instead");
            }
        }
        Simulator sim = new Simulator();
        if(addedAppender == false) {
            sim.addAppender(new WriterAppender(new PatternLayout("<br>%m%n"), out));
            //appender = new WriterAppender(new PatternLayout("<br>%m%n"), out);
            //sim.addAppender(appender);
            addedAppender = true;
        }
        sim.setLogLevel(Level.INFO);
        List<Histogram> hists = sim.doSimulation(numRuns);
        out.println("<p>This first histogram is for the best hand types for each deal.  If you get a full and a pair of eights in the same deal, it only counts the full house.  The total at the bottom should be the same as the number of deals.  The <a href=\"http://en.wikipedia.org/wiki/List_of_poker_hands\" target=\"_\">theoretical probabilties</a> are shown next to it for comparison.");
        out.println("<table width=100%><tr><td valign=top>" + hists.get(0).asXHTMLTable() + "</td><td valign=top>" + sim.getTheoreticalProbabilities().asXHTMLTable() + "</td></tr></table>");
        out.println("<p>This next histogram is for all hand types.  If you get a full house and a pair of eights in the same deal, it counts both.  The total at the bottom will usually be 1.39 to 1.4 times the number of deals.</p>");
        out.println("<p>" + hists.get(1).asXHTMLTable() + "</p>");
        out.println("<p>This histogram shows the number of each suit dealt.  They should all be about 1/4, or .25, and the total should be exactly seven times the number of deals.</p>");
        out.println("<p>" + hists.get(2).asXHTMLTable() + "</p>");
        out.println("<p>This histogram shows the number of each \"rank\" dealt.  They should all be about 1/13, or 0.0769, and the total should be exactly seven times the number of deals.</p>");
        out.println("<p>" + hists.get(3).asXHTMLTable() + "</p>");
        
        out.println("<p>known issues:</p>");
        out.println("<ul>");
        out.println("<li>Inccorect logic in detecting straight flushes and royal flushes, so those hands are under reported.</li>");
        out.println("</ul>");
        RequestDispatcher dispatcher = request.getRequestDispatcher("footer.jsp");
        dispatcher.include(request, response);
        out.println("</body></html>");
    }
}
