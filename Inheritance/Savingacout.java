class Savingacout extends BankAccount {
    private int saving;
    public Savingacout(int amount){
        this.balance = 2;
        this.saving = amount;
    }
    public double total(){
        return saving*getBalance();
    }

    
}
