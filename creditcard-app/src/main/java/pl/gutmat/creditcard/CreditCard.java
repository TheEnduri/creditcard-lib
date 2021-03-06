package pl.gutmat.creditcard;

import java.math.BigDecimal;

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
		return this.blockade;
	}

	public void withdraw(BigDecimal money) {
		if (isWithdrawOverTheLimit(money))
			throw new NotEnoughMoneyException();

		if (isNotEnoughMoney(money))
			throw new NotEnoughMoneyException();

		if (isBlocked())
			throw new TransactionOnBlockedCardException();

		balance = balance.subtract(money);
	}

	private boolean isNotEnoughMoney(BigDecimal money) {
		return money.compareTo(balance) > 0;
	}

	private boolean isWithdrawOverTheLimit(BigDecimal money) {
		return money.compareTo(limit) > 0;
	}

	public void repay(BigDecimal money) {
		if (money.compareTo(BigDecimal.ZERO) < 0) {
			throw new CantRepayNegativeAmountException();
		}
		balance = balance.add(money);
	}

	public BigDecimal getBalance() {
		return balance;
	}
}