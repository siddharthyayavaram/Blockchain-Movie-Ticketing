import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Blockchain blockchain = new Blockchain(4);

        // Create 4 shows
        Shows show1 = new Shows(100, "The Shawshank Redemption", 150, new Date(1234567890123L));
        Shows show2 = new Shows(75, "The Godfather", 200, new Date(2345678901234L));
        Shows show3 = new Shows(80, "The Dark Knight", 175, new Date(3456789012345L));
        Shows show4 = new Shows(120, "Forrest Gump", 100, new Date(4567890123456L));

        User user1 = new User("John Doe", "password123", 1000);
        User user2 = new User("Jane Smith", "mypassword", 5000);
        User user3 = new User("Bob Johnson", "mysecretpass", 750);
        User user4 = new User("Alice Lee", "pass1234", 2000);


        // // transaction 1: user1 buys 2 tickets for show1
        if(user1.makeTransaction(show1,2)){
            Block Block1 = new Block("0", new Date().getTime(),user1.getLastTransaction());
            Block1.mineBlock(blockchain.getprefix());
            blockchain.addblock(Block1);

            boolean isBlockchainValid1 = blockchain.isBlockchainValid();
            System.out.println("Is blockchain valid after adding Block1 ? \n" + isBlockchainValid1 + "\n");
        }


        // // transaction 2: user2 buys 3 tickets for show3
        if(user2.makeTransaction(show2,3)){
            Block Block2 = new Block(blockchain.chain.get(blockchain.getsize() - 1).getHash(), new Date().getTime(),user2.getLastTransaction());
            Block2.mineBlock(blockchain.getprefix());
            blockchain.addblock(Block2);

            boolean isBlockchainValid2 = blockchain.isBlockchainValid();
            System.out.println("Is blockchain valid after adding Block2 ? \n" + isBlockchainValid2 + "\n");
        }


        // // transaction 3: user3 buys 1 ticket for show2
        if(user3.makeTransaction(show3,1)){
            Block Block3 = new Block(blockchain.chain.get(blockchain.getsize() - 1).getHash(), new Date().getTime(),user3.getLastTransaction());
            Block3.mineBlock(blockchain.getprefix());
            blockchain.addblock(Block3);

            boolean isBlockchainValid3 = blockchain.isBlockchainValid();
            System.out.println("Is blockchain valid after adding Block3 ? \n" + isBlockchainValid3 + "\n");
        }

        // // transaction 4: user4 buys 4 tickets for show4
        if(user4.makeTransaction(show4,4)){
            Block Block4 = new Block(blockchain.chain.get(blockchain.getsize() - 1).getHash(), new Date().getTime(),user4.getLastTransaction());
            Block4.mineBlock(blockchain.getprefix());

            // boolean isValid = Block4.getHash().substring(0, blockchain.getprefix()).equals(blockchain.getprefixstring());

            // System.out.println("Is newBlock valid?\n" + isValid);
            // System.out.println("\n");
            
            blockchain.addblock(Block4);

            boolean isBlockchainValid4 = blockchain.isBlockchainValid();
            System.out.println("Is blockchain valid after adding Block4 ? \n" + isBlockchainValid4 + "\n");
        }

        blockchain.showchain();
        user1.showTransactions();    // same function as ViewUser() method
        user2.showTransactions();
        user3.showTransactions();
        user4.showTransactions();

        //blockchain.chain.get(blockchain.getsize()-2).setHash("0");
        // this line changes the hash making the chain invalid

        boolean isBlockchainValid4 = blockchain.isBlockchainValid();
        System.out.println("Is blockchain finally valid? \n" + isBlockchainValid4);
        blockchain.chain.clear();
    }
}

