package pl.gutmat.creditcard;

class CreditCard {

    private boolean blockade = false;
    private BigDecimal limit;
    private BigDecimal balance;
    private String cardNumber;

    public CreditCard(){
        this.cardNumber = "random_number";
    }

    public CreditCard(String cardNumber){
        this.cardNumber = cardNumber;
    }

    public String getNumber(){
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

    public double getLimit() {
        return limit;
    }

    public void block() {
        this.blockade = true;
    }


}