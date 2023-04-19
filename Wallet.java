public class Wallet {
    private String password;
    private int balance;
    
    public Wallet(String password,int balance) {
        this.password = password;
        this.balance = balance;
    }
    
    public String getPassword() {
        return password;
    }

    public int getBalance(){
        return balance;
    }

    public void updateBalance(int i){
        balance-=i;
    }
}