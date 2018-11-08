package pl.gutmat.creditcard;

class CreditCard {

    private boolean blockade = false;
<<<<<<< HEAD
    private double limit;
    private double balance;
    
    public void assignLimit(double money) {
        this.limit = money;
=======

    public void assignLimit(double money) {

>>>>>>> eb72358460701d8e56c9fee1f0c5046ce97dc125
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
<<<<<<< HEAD
    
    public void withdraw(double amount){
        balance = limit - amount;
        
        if(amount > limit){
            block();
        }
        
        
        
    }
=======

>>>>>>> eb72358460701d8e56c9fee1f0c5046ce97dc125
}