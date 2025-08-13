import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Block {

    private static Logger logger = Logger.getLogger(Block.class.getName());

    private String hash;
    private String previousHash;
    private Transaction transactions;
    private long timeStamp;
    private int nonce;

    public Block(String previousHash, long timeStamp,Transaction transactions) {
        this.previousHash = previousHash;
        this.transactions = transactions;
        this.timeStamp = timeStamp;
        this.hash = calculateBlockHash();
    }

    public String mineBlock(int prefix) {
        String prefixString = new String(new char[prefix]).replace('\0', '0');
        // starting time
        long start = System.currentTimeMillis();
        while (!hash.substring(0, prefix)
            .equals(prefixString)) {
            nonce++;
            hash = calculateBlockHash();
        }
        long end = System.currentTimeMillis();
        System.out.println("mining the block takes " + (end - start) + "ms\n");
        //System.out.println(hash);
        return hash;
    }

    public String calculateBlockHash() {
        String dataToHash = previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + transactions.toString();
        MessageDigest digest = null;
        byte[] bytes = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(dataToHash.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }
        StringBuffer buffer = new StringBuffer();
        for (byte b : bytes) {
            buffer.append(String.format("%02x", b));
        }
        return buffer.toString();
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return this.previousHash;
    }

    public Transaction getTransactions() {
        return this.transactions;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    // toString method
    @Override
    public String toString() {
        return "Block{" +
                "hash='" + hash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", transactions=" + transactions +
                ", timeStamp=" + timeStamp +
                ", nonce=" + nonce +
                '}';
    }

}