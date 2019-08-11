/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ravin
 */
public class GameTest {
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    /**
     * Test of draw method, of class Game.
     */
    @Test
    public void testDrawGood() {
        System.out.println("drawGood");
        ArrayList<CardDeck> deck = new ArrayList();
        ArrayList<CardDeck> instance = deck;
        boolean expResult = true;
        boolean result = deck.equals(instance);
        //boolean result = deck.add(new CardDeck());
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
     @Test
    public void testDrawBad() {
        System.out.println("drawBad");
        ArrayList<CardDeck> deck = new ArrayList();
        ArrayList<CardDeck> instance = new ArrayList();
        boolean expResult = false;
        instance.add(new CardDeck());
        deck.add(new CardDeck());
        boolean result = deck.equals(instance);
        //boolean result = deck.add(new CardDeck());
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
     @Test
    public void testDrawBoundry() {
        System.out.println("drawBoundry");
        ArrayList<CardDeck> deck = new ArrayList();
        ArrayList<CardDeck> instance = deck;
        boolean expResult = true;
        boolean result = deck.equals(instance);
        //boolean result = deck.add(new CardDeck());
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
}
