package pl.gutmat.creditcard;

import java.math.BigDecimal

class CreditCard {

	private boolean blockade = false;
	private BigDecimal limit;
	private BigDecimal balance = BigDecimal.ZERO;
	private String cardNumber;

    public CreditCard(){
        this.cardNumber = "random_number";
    }

    public CreditCard(String cardNumber){
        this.cardNumber = cardNumber;
    }

    }

	public String getNumber() {
		return cardNumber;
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
    public void block() {
        this.blocked = true;
    }

    public boolean isBlocked() {
        return this.blocked;
    }
    private boolean isNotEnoughMoney(BigDecimal money) {
        return money.compareTo(balance) > 0;
    }

    private boolean isWithdrawOverTheLimit(BigDecimal money) {
        return money.compareTo(limit) > 0;
    }
    public void assignLimit(double money) {
        this.limit = money;
    }
	}

	private boolean isLimitBelowOrEquals0(BigDecimal money) {
		return money.compareTo(BigDecimal.ZERO) <= 0;
	}

    public double getLimit() {
        return limit;
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