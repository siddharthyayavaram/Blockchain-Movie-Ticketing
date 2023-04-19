import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private final String name;
    private final Wallet wallet;
    private final int userid;
    private List<Transaction> transactions;
    private int initbalance;
    private static final AtomicInteger count = new AtomicInteger(0);

    public User(String name,String password,int initbalance) {
        this.name = name;
        this.userid = count.incrementAndGet();
        this.wallet = new Wallet(password,initbalance);
        this.transactions = new ArrayList<>();
        this.initbalance = initbalance;
    }

    public boolean makeTransaction(Shows show, int numtickets){
        if (numtickets <= 0 || numtickets>show.getSeats()) {
            return false;
        }
        if(show.getPrice()*numtickets> this.wallet.getBalance()){
            return false;
        }
    
        Transaction tx = new Transaction(this.userid, show, numtickets);

        boolean isValid = TransactionVerifier.verifyTransaction(this.wallet.getPassword(),10);
    
        if (isValid) {
            this.wallet.updateBalance(show.getPrice()*numtickets);
            show.updateseats(numtickets);
            this.transactions.add(tx);
            return true;
        }
        else {
            return false;
        }
    }
    
    public void showTransactions() {
        if (this.transactions.size() != 0) {
            System.out.println("Transactions for the user are ");
        }

        for (Transaction tx : this.transactions) {
            System.out.println(tx);
            System.out.println("\n");
        }
    }

    public Transaction getLastTransaction() {
        if (this.transactions.size() == 0) {
            return null;
        } else {
            return this.transactions.get(this.transactions.size() - 1);
        }
    }
    
    public String getName() {
        return name;
    }

    public int getinitbalance() {
        return initbalance;
    }

    public int getuserid() {
        return userid;
    }

    public Wallet getWallet() {
        return wallet;
    }
}