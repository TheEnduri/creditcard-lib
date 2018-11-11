package pl.gutmat.creditcard;

import java.math.BigDecimal

class CreditCard {

	private boolean blockade = false;
	private BigDecimal limit;
	private BigDecimal balance = BigDecimal.ZERO;
	private String cardNumber;

	public CreditCard() {
		this.cardNumber = "random_number";
	}

	public CreditCard(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getNumber() {
		return cardNumber;
	}

	public void assignLimit(BigDecimal money) {

		if (isLimitAlreadyAsigned()) {
			throw new LimitAlreadyAssignedException();
		}

		if (isLimitBelowOrEquals0(money)) {
			throw new InsufficientCreditLimitException();
		}

		this.limit = money;
		this.balance = money;

	}

	private boolean isLimitBelowOrEquals0(BigDecimal money) {
		return money.compareTo(BigDecimal.ZERO) <= 0;
	}

	private boolean isLimitAlreadyAsigned() {
		return limit != null;
	}

	public BigDecimal getLimit() {
		return limit;
	}

	public void block() {
		this.blockade = true;
	}

	public boolean isBlocked() {
		return this.blocked;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}

}