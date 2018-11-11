package pl.gutmat.creditcard;

import org.junit.Assert;
import org.junit.Test;


public class CreditCardApiTest {
    
    private final static double initialCredit = 200;
    private final static String cardNumber = "1234567890";
    
    @Test
    public void handleWithDraw (){
        
        thereIsCreditCardPool();
        
        thereIsCreditCardApi();
        
        thereIsCardWithNumber(cardNumber);
        
        api.withdraw(cardNumber, 20);
        
        saldoOfCreditCardWithIdEquals(cardNumber, 180);
        
    }
    
    private void thereIsCardWithPool(){
        this.creditcardPool = new CreditCardPool();
    }
    
    private void thereIsCreditCardApi(){
        this.api = new CreditCardApi();

    }
    
    private void thereIsCardWithNumber ( String cardNumber ){
        CreditCard card = new CreditCard (cardNumber);
        card.assignLimit(initialCredit);
         creditCardPool.add(card);
    }
    
    private void saldoOfCreditCardWithIdEquals ( String cardNumber, double expectedBalance) {
        CreditCard card = creditCardPool.find(cardNumber);
        Assert.assertTrue(card.getBalance () == expectedBalance);
    }
    
    
    
    
    
}