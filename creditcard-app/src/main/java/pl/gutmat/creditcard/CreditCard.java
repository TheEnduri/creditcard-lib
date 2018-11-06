package pl.gutmat.creditcard;

class CreditCard{
    private int limit;
    private boolean isBlocked = false;

    public boolean getIsBlocked(){
        return isBlocked;
    }

    public void setLimit(int limit){
        this.limit = limit;
    }

    public int getLimit(){
        return this.limit;
    }

    public void withdraw(int amount){

        int saldo = limit - amount;

        if(amount > limit){
            blockCreditCard();
        }
    }

    public boolean blockCreditCard(){
        return this.isBlocked = true;
    }

}