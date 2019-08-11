/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific
 * child of this class and instantiate the methods given.
 * @author dancye, 2018
 */
public abstract class Game 
{
    public static void main (String [] args) {
        
        play();
        
    }
    
    public static void play(){
 
        ArrayList<CardDeck> playerDeck = new ArrayList();
        ArrayList<CardDeck> computerDeck = new ArrayList();
        Scanner input;
        
    
        int choice;
        String cColor;
        int win;
        CardDeck cardOnTop;
        
        game:
        while (true) {
            
            playerDeck.clear();
            computerDeck.clear();
            win = 0;
            
            cardOnTop = new CardDeck();
            
            // color of card on top
            cColor = cardOnTop.color;
            
            System.out.println("\n Let's play UNO!");
            // draw (from the Computer class) 7 cards for the player and 7 cards for the computer
            draw(7, playerDeck);
            draw(7, computerDeck);
            
            // when it's the players turn
            for (boolean playersTurn = true; win == 0; playersTurn ^= true) {
                choice = 0;
                
                // show them the card on top of the pile, i.e. the last card chosen by the computer
                System.out.println("\nThe card on top is " + cardOnTop.deal());
                
                // let player choose their card from the playerDeck
                if (playersTurn) {
                    System.out.println("Your turn, choose a card");
                    
                    // show player their deck
                    for (int i = 0; i<playerDeck.size(); i++) {
                        System.out.println(String.valueOf(i + 1) + ". " + ((CardDeck) playerDeck.get(i)).deal()+ "\n");
                    }
                    
                    System.out.println(String.valueOf(playerDeck.size() + 1) + ". " + "Draw card\n\n" + 
                            String.valueOf(playerDeck.size() + 2) + ". Quit"); 
                    
                    // keep prompting the player for input until they do
                    do {
                        System.out.println("\nPlease chose a number ");
                        input = new Scanner(System.in);
                    }while (!input.hasNextInt());
                    
                    choice = input.nextInt() - 1;
                    
                    if (choice == playerDeck.size()) {
                        draw(1, playerDeck);
                    }
                    else if (choice == playerDeck.size() + 1) {
                        break game;
                    }
                    // player's turn
                    else if (((CardDeck)playerDeck.get(choice)).placeCard(cardOnTop, cColor)) {
                        cardOnTop = (CardDeck)playerDeck.get(choice);
                        playerDeck.remove(choice);
                        cColor = cardOnTop.color;
                        
                        if (cardOnTop.number >= 10){
                            playersTurn = false;
                            
                            switch (cardOnTop.number) {
                                case 11: 
                                    System.out.println("drawing 2 cards");
                                    draw(2, computerDeck);
                                    break;
                                case 9: case 10: 
                                    
                                    do {
                                    System.out.println("\nEnter card color");
                                    input = new Scanner(System.in);
                                    } while (!input.hasNext("red|green|blue|yellow"));
                                    
                                    if (input.hasNext("red")){
                                        cColor = "red";
                                    }
                                    else if (input.hasNext("green")){
                                        cColor = "green";
                                    }
                                    else if (input.hasNext("blue")){
                                        cColor = "blue";
                                    }
                                    else if (input.hasNext("yellow")) {
                                        cColor = "yellow";
                                    }
                                    System.out.println("You chose " + cColor);
                                    
                                    if (cardOnTop.number == 14) {
                                    System.out.println("drawing 4 cards"); 
                                    draw(4, computerDeck);
                                        break;
                                }
                            }
                        }
                        else {
                            System.out.println("Sorry your choice is invalid, you loose your turn.");                        
                        }
                    }
                    else {
                        // computers turn
                        System.out.println("Computer has " + String.valueOf(computerDeck.size()) + " cards left. " + 
                                                ((computerDeck.size() == 1) ? " UNO!" : ""));
                        for (choice = 0; choice < computerDeck.size(); choice++) {
                            if (((CardDeck)computerDeck.get(choice)).placeCard(cardOnTop, cColor))
                                break;
                        }
                        if (choice == computerDeck.size()) {
                            System.out.println("Drawing cards");
                            draw(1, computerDeck);
                        }
                        else {
                            cardOnTop = (CardDeck)computerDeck.get(choice);
                            computerDeck.remove(choice);
                            cColor = cardOnTop.color;
                            System.out.println("Computer's choice is " + cardOnTop.deal());
                            
                            if (cardOnTop.number >=10) {
                                playersTurn = true;
                                
                                switch (cardOnTop.number) {
                                    case 11:
                                        System.out.println("drawing 2 cards");
                                        draw(2, playerDeck);
                                        break;
                                    case 9: case 10:
                                        do {
                                            cColor = new CardDeck().color;
                                        }while(cColor == "nocolor");
                                        
                                        System.out.println("New color is " + cColor);
                                        
                                        if (cardOnTop.number == 14) {
                                            System.out.println("drawing 4 cards");
                                            draw(4, playerDeck);
                                        }
                                        break;
                                }
                            }
                        }
                        
                        if (playerDeck.isEmpty()) {
                            win = 1;                         
                        }
                        else if (computerDeck.isEmpty()){
                            win = -1;
                        }
                    }         
                }
                // display winning player
                if (win == 1) {
                    System.out.println("You Won!");
                }
                else {
                    System.out.println("You lost!");
                }      
        }
        
        System.out.println("Thank you for playing!");
    }
        
    }
    public static void draw (int cards, ArrayList<CardDeck> deck) {
        for (int i = 0; i<cards; i++) {
            deck.add(new CardDeck());
        }
    }
    @Override
    public abstract String toString();
    
    
}
    
