/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author ravin
 */
public class CardDeckTest {
    
    public CardDeckTest() {
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
     * Test of deal method, of class CardDeck.
     */
    @org.junit.Test
    public void testDeal() {
        System.out.println("deal");
        CardDeck instance = new CardDeck();
        String expResult = instance.deal();
        String result = instance.deal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of placeCard method, of class CardDeck.
     */
    
    // for the placeCard god test, the cards placed need to be the same, thus, instance = card
    @org.junit.Test
    public void testPlaceCardGood() {
        System.out.println("placeCardGood");
        CardDeck card = new CardDeck();
        String c = Integer.toString(card.number);
        CardDeck instance = card;
        boolean expResult = true;
        boolean result = instance.placeCard(card, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    // for the placeCard god test, the cards placed need to be the different, thus, instance = new CardDeck();
    @org.junit.Test
    public void testPlaceCardBad() {
        System.out.println("placeCardBad");
        CardDeck card = new CardDeck();
        String c = Integer.toString(card.number);
        CardDeck instance = new CardDeck();
        boolean expResult = false;
        boolean result = instance.placeCard(card, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    // for the placeCard god test, the cards placed need to be the same, thus, instance = card
    @org.junit.Test
    public void testPlaceCardBoundry() {
        System.out.println("placeCardBoundry");
        CardDeck card = new CardDeck();
        String c = Integer.toString(card.number);
        CardDeck instance = card;
        boolean expResult = true;
        boolean result = instance.placeCard(card, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
