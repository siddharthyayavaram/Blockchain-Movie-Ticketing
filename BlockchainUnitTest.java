// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;

// public class BlockchainUnitTest {

//     public static List<Block> blockchain = new ArrayList<Block>();
//     public static int prefix = 4;
//     public static String prefixString = new String(new char[prefix]).replace('\0', '0');

//     public static void main(String[] args) {

//         // Create 5 shows
//         Shows show1 = new Shows(100, "The Shawshank Redemption", 150, new Date(1234567890123L));
//         Shows show2 = new Shows(75, "The Godfather", 200, new Date(2345678901234L));
//         Shows show3 = new Shows(80, "The Dark Knight", 175, new Date(3456789012345L));
//         Shows show4 = new Shows(120, "Forrest Gump", 100, new Date(4567890123456L));

//         User user1 = new User("John Doe", "password123", 1000);
//         User user2 = new User("Jane Smith", "mypassword", 5000);
//         User user3 = new User("Bob Johnson", "mysecretpass", 750);
//         User user4 = new User("Alice Lee", "pass1234", 2000);


//         // // transaction 4: user4 buys 4 tickets for show4
//         // Transaction transaction4 = new Transaction(user4.getuserid(), show4, 4);


//         // // transaction 1: user1 buys 2 tickets for show1
//         if(user1.makeTransaction(show1,2)){
//             Block Block1 = new Block("0", new Date().getTime(),user1.getLastTransaction());
//             Block1.mineBlock(prefix);
//             blockchain.add(Block1);
//         }

//         showchain();

//         // // transaction 2: user2 buys 3 tickets for show3
//         if(user2.makeTransaction(show2,3)){
//             Block Block2 = new Block(blockchain.get(blockchain.size() - 1).getHash(), new Date().getTime(),user2.getLastTransaction());
//             Block2.mineBlock(prefix);
//             blockchain.add(Block2);
//         }

//         showchain();

//         // // transaction 3: user3 buys 1 ticket for show2
//         if(user3.makeTransaction(show3,1)){
//             Block Block3 = new Block(blockchain.get(blockchain.size() - 1).getHash(), new Date().getTime(),user3.getLastTransaction());
//             Block3.mineBlock(prefix);
//             blockchain.add(Block3);
//         }

//         showchain();

//         if(user4.makeTransaction(show4,4)){
//             Block Block4 = new Block(blockchain.get(blockchain.size() - 1).getHash(), new Date().getTime(),user4.getLastTransaction());
//             Block4.mineBlock(prefix);

//             boolean isValid = Block4.getHash().substring(0, prefix).equals(prefixString);

//             System.out.println("Is newBlock valid?\n" + isValid);

//             blockchain.add(Block4);
//         }

//         showchain();

//         //user1.showTransactions();

//         boolean isBlockchainValid = isBlockchainValid();
//         System.out.println("Is blockchain valid after adding new block? \n" + isBlockchainValid);
//         blockchain.clear();
//     }

//     public static boolean isBlockchainValid() {
//         boolean flag = true;
//         for (int i = 0; i < blockchain.size(); i++) {
//             String previousHash = i == 0 ? "0"
//                     : blockchain.get(i - 1)
//                     .getHash();
//             flag = blockchain.get(i).getHash().equals(blockchain.get(i).calculateBlockHash())
//                     && previousHash.equals(blockchain.get(i).getPreviousHash())
//                     && blockchain.get(i).getHash().substring(0, prefix).equals(prefixString);
//             if (!flag)
//                 break;
//         }
//         return flag;
//     }

//     public static void showchain() {
//         for (Block b : blockchain) {
//             System.out.println(b);
//         }
//     }
// }