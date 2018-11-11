package pl.gutmat.creditcard;

import java.util.Map;
import java.util.HashMap;


class CreditCardPool {
    
    private Map<String, CreditCard> cards = new HashMap<String, CreditCard>();
    
    public void add(CreditCard card {
        cards.put(card.getNumber(), card);
        )
        
        public CreditCard find(String cardNuumber) {
            return cards.get(cardNumber);
        }
}