package pl.gutmat.creditcard;

import org.junit.Assert;
import org.junit.Test;

public class CreditCardTest {

    @Test
    public void allowAssignLimitToCard() {
        CreditCard card = new CreditCard();

        card.assignLimit(2000);

        Assert.assertTrue(card.getLimit() == 2000);
    }

    @Test
    public void cantWithdrawWhenCantAfford() {

    }

    @Test
    public void canBlockCard() {

        CreditCard card = new CreditCard();

        card.block();

        Assert.assertTrue(card.isBlocked());
    }


    @Test(expected = WithdrawWhenOverTheLimit.class)
    public void cantWithdrawWhenWhenOverTheLimit() throws Exception{

        CreditCard card = new CreditCard();
        card.assignLimit(200);
        card.withdraw(300);
    }
    @Test
    public void canRepayDebt(){
        //arrange
        CreditCard card = new CreditCard();
        //act
        card.assignLimit(200);
        card.withdraw(300);
        card.repayDebt(200);
        //assert
        Assert.assertFalse(card.isBlocked);
    }
        @Test
    public void withdrawMoneyWhenCardBlocked(){
        //arrange
        CreditCard card = new CreditCard();
        //act
        card.assignLimit(200);
        card.withdraw(300);
        //assert
        Assert.assertTrue(card.getIsBlocked());
    }
    @Test
    public void withdrawMoneyWhenCardNotBlocked(){
        //arrange
        CreditCard card = new CreditCard();
        //act
        card.assignLimit(200);
        card.withdraw(100);
        //assert
        Assert.assertFalse(card.getIsBlocked());
    }
}