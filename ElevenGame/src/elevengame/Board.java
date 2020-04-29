package elevengame;

import java.util.Arrays;

/**
 * Represents the table with cards to play and a deck
 * @author janvit
 */
public class Board implements BoardInterface{
    private Card[] cards;
    private Deck deck;
    
    public Board(){
        deck = new Deck(DataStore.loadSymbols(),DataStore.loadValues(),DataStore.loadNPoints());
        cards = new Card[DataStore.getNCards()];
        for (int i = 0; i < DataStore.getNCards(); i++) {
            
            cards[i] = deck.deal();
            
        }
    }
    
    @Override
    public String gameName() {
        return "Hra jedenactka";
    }
    
    @Override
    public int nCards() {
        return cards.length;
    }

    @Override
    public int getDeckSize() {
        return deck.getDeckSize();
    }
    
    @Override
    public String getCardDescriptionAt(int index){
        if(cards[index] == null){
            return " ";
        }
        return cards[index].getSymbol() + "-" + cards[index].getValue();
    }

    @Override
    public boolean anotherPlayIsPossible() {
        for (int i = 0; i < cards.length-1; i++) {
            for (int j = i+1; j < cards.length; j++) {
                if((cards[i].getnPoints() + cards[j].getnPoints()) == 11){
                    return true;
                }
            }
        }
        String[] triple = DataStore.getTriple();
        Arrays.sort(triple);
        String[] cardSymbols = new String[3];
        for (int i = 0; i < cards.length-2; i++) {
            cardSymbols[0] = cards[i].getValue();
            for (int j = i+1; j < cards.length-1; j++) {
                cardSymbols[1] = cards[i].getValue();
                for (int k = j+1; k < cards.length; k++) {
                    cardSymbols[2] = cards[i].getValue();
                    String[] sortedSymbols = cardSymbols;
                    Arrays.sort(sortedSymbols);
                    if(Arrays.equals(sortedSymbols, triple)){
                        return true;
                    }
                }
                
            }
            
        }
        return false;
    }

    @Override
    public boolean playAndReplace(int[] iSelectedCards) {
        if(iSelectedCards.length == 2){
        int count = 0;
        for (int i = 0; i < iSelectedCards.length; i++) {
            count += cards[iSelectedCards[i]].getnPoints();
        }
        if(count!=11){
            return false;
        }
        for (int i = 0; i < iSelectedCards.length; i++) {
            cards[iSelectedCards[i]] = deck.deal();
        }
        return true;
        }else{
            if(iSelectedCards.length == 3){
                String[] cardSymbols = new String[iSelectedCards.length];
                String[] triple = DataStore.getTriple();
                for (int i = 0; i < cardSymbols.length; i++) {
                    cardSymbols[i] = cards[iSelectedCards[i]].getValue();
                }
                Arrays.sort(cardSymbols);
                Arrays.sort(triple);
                if(Arrays.equals(cardSymbols, triple)){
                    for (int i = 0; i < iSelectedCards.length; i++) {
                        cards[iSelectedCards[i]] = deck.deal();
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isWon() {
        return (deck.getDeckSize()<=0 && nCards()<=0);
    }
}
