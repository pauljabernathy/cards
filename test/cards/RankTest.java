/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cards;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paul
 */
public class RankTest {

    public RankTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of values method, of class Rank.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Rank[] expResult = null;
        Rank[] result = Rank.values();
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    /**
     * Test of valueOf method, of class Rank.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "JACK";
        Rank expResult = Rank.JACK;
        Rank result = Rank.valueOf(name);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getRank method, of class Rank.
     */
    @Test
    public void testGetRank() {
        System.out.println("getRank");
        int rank = 0;
        Rank expResult = Rank.TWO;
        Rank result = Rank.getRank(rank);
        System.out.println("result = " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Rank
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Rank rank = Rank.EIGHT;
        String result = rank.toString();
        System.out.println("result = " + rank);
        String expResult = "EIGHT";
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testGetIntValue() {
        System.out.println("testGetIntValue");

        Rank[] values = Rank.values();
        for(int i = 0; i < values.length; i++) {
            System.out.println(values[i] + " " + Rank.getIntValue(values[i]));
        }
    }

}