package pl.gutmat.creditcard;

import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class CreditCardApiTest {

	private static final double initialCredit = 200;
	private static final String cardNumber = "1234567890";
	private CreditCardPool pool;
	private CreditCardApi api;

	@Test
	public void handleWithDraw() {

		thereIsCreditCardPool();

		thereIsCreditCardApi();

		thereIsCardWithNumber(cardNumber);

		api.withdraw(cardNumber, 20);

		saldoOfCreditCardWithIdEquals(cardNumber, 180);

	}

	private void thereIsCardWithNumber(String cardNumber) {
		CreditCard card = new CreditCard(cardNumber);
		card.assignLimit(BigDecimal.valueOf(initialCredit));
		pool.add(card);
	}

	private void thereIsCreditCardApi() {
		this.api = new CreditCardApi();

	}

	private void thereIsCreditCardPool() {
		this.creditcardPool = new CreditCardPool();
	}

	private void saldoOfCreditCardWithIdEquals(String cardNumber, double expectedBalance) {
		CreditCard card = pool.find(cardNumber);

		Assert.assertTrue(card.getBalance() == expectedBalance);
	}

}