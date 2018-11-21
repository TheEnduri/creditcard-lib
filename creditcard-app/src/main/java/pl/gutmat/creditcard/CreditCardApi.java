package pl.gutmat.creditcard;
import java.math.BigDecimal;

class CreditCardApi {
    private CreditCardPool cards;
    
    public CreditCardApi(CreditCardPool cards) {
        this.cards = cards;
    }
    
    public void withdraw ( String cardNumber, double money) {
        
        CreditCard card = cards.find(cardNumber);
        card.withdraw(BigDecimal.valueOf(money));
    }
}