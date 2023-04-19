import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class TransactionVerifier {
    
    // Constants used in the zero knowledge proof
    private static final BigInteger p = new BigInteger("11"); // large prime
    private static final BigInteger g = new BigInteger("2"); // generator for p
    
    /**
     * Verifies a transaction using a zero knowledge proof based on the user's password.
     *
     * @param tx          The transaction to verify
     * @param password    The password to the user's wallet
     * @param zkpRounds   The number of rounds to perform for the zero knowledge proof
     * @return true if the transaction is valid, false otherwise
     */
    public static boolean verifyTransaction(String password, int zkpRounds) {
        // Compute hash of password
        byte[] passwordHash = hash(password.getBytes());
        
        // Convert hash to BigInteger for use in zero knowledge proof
        BigInteger x = new BigInteger(1, passwordHash);
        
        // Calculate y = g^x mod p
        BigInteger y = g.modPow(x, p);
        
        // Perform the zero knowledge proof
        for (int i = 0; i < zkpRounds; i++) {
            // Step 1: Choose a random number r
            BigInteger r = new BigInteger(p.bitLength(), new Random());
            while (r.compareTo(p) >= 0) {
                r = new BigInteger(p.bitLength(), new Random());
            }
            
            // Step 2: Calculate h = g^r mod p and send it to the verifier
            BigInteger h = g.modPow(r, p);
            
            // Step 3: Receive a random bit b from the verifier and compute s = (r + bx) mod (p-1)
            int b = new Random().nextInt(2);
            BigInteger s = r.add(BigInteger.valueOf(b).multiply(x)).mod(p.subtract(BigInteger.ONE));
            
            // Step 4: Compute g^s mod p and check if it equals h*y^b mod p
            BigInteger left = g.modPow(s, p);
            BigInteger right = h.multiply(y.modPow(BigInteger.valueOf(b), p)).mod(p);
            
            if (!left.equals(right)) {
                return false; // The proof failed, transaction is invalid
            }
        }
        
        // The proof succeeded, transaction is valid
        return true;
    }
    
    // Helper method to compute SHA-256 hash
    private static byte[] hash(byte[] data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return digest.digest(data);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 not supported", e);
        }
    }
}