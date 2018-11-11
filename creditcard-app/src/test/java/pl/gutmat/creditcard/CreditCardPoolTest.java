package pl.gutmat.creditcard;

import org.junit.Test;
import org.junit.Assert;

public class CreditCardPoolTest {

	private static final String number = "1234";

	@Test
	public void allowAddAndFindCard() {

		CreditCardPool pool = new CreditCardPool();

		CreditCard card = new CreditCard(number);

		pool.add(card);

		CreditCard loaded = pool.find(number);

		Assert.assertTrue(loaded.getNumber().equals(number));

	}

}