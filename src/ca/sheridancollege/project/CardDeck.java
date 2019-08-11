package ca.sheridancollege.project;
import java.util.Random;

public class CardDeck {
    
        public String color;
        public int number;
        private String card;
        
        
        public CardDeck(int number, String color){
           color = color;
           number = number;
           
        }
	
        public CardDeck() {
            
            // random generation of cards
            // assume 108 cards in CardDeck
            Random ran = new Random();
            number = ran.nextInt(28);
        
            if (number > 14) {
                number -= 14;
            }
            
            
            // generate random colours (either red,blue, green, or yellow) for cards
            ran = new Random();
                switch (ran.nextInt(4)) {
                    case 0: color = "red";
                        break;
                    case 1: color = "blue";
                        break;
                    case 2: color = "green";
                        break;
                    case 3: color = "yellow";
                        break;
                }
                
            // wildcards will have no color 
            if (number >= 13) {
                color = "nocolor";
            }
            
               
        }
        
        public String deal() {
        
              // displays cards to player
            card = "[";
            if (color != "nocolor"){
                card += this.color + " ";
            }
            
            switch (this.number) {
                
                case 7: card += "skip";
                    break;
                case 8: card += "reverse";
                    break;
                case 9: card +="wild";
                    break;
                case 10: card +="wild draw 4";
                    break;
                case 11: card +="draw 2";
                    break;
                default: card += String.valueOf(this.number);
                    break;
            }
            card +="]";
            
            return card;
        }
    
         // draw card 
        public boolean placeCard (CardDeck card, String c) {
            if (this.color == c){
                return true;
            }
            else if (this.number == card.number){
                return true;
            }
            else if (this.color == "nocolor"){
                return true;
            }
            return false;
        }     
}

