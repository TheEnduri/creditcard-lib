package pl.gutmat.creditcard;

class CreditCard {
    
    private boolean blockade = false;
    private double limit;
    private double balance;
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
    
    
    public void assignLimit(double money) {
        this.limit = money;
    }

    public double getLimit() {
        return limit;
    }

    public void block() {
        this.blockade = true;
    }

    public boolean isBlocked() {
        return this.blockade;
    }
    
    public void withdraw(double amount){
        balance = limit - amount;
        
        if(amount > limit){
            block();
        }
        
    }
    
    public void repayDebt(double amount){
        balance = balance + amount;
    }
    
    
    
    
    
    
    
    
    
        
}