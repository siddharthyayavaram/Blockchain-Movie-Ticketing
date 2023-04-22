import java.math.BigInteger;
import java.security.SecureRandom;

public class KeyGenerator {
    private static final int PRIME_BIT_LENGTH = 1024; // length of prime in bits
    private static final BigInteger TWO = BigInteger.valueOf(2); // constant for generator
    
    /**
     * Generates a large prime number and a generator for use in cryptographic applications.
     *
     * @return an array of two BigInteger objects containing the prime number and the generator
     */
    public static BigInteger[] generateKeys() {
        SecureRandom random = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(PRIME_BIT_LENGTH, random); // generate a large prime
        BigInteger g = TWO; // set generator to 2
        while (g.compareTo(p) >= 0 || g.modPow(p.subtract(BigInteger.ONE).divide(TWO), p).equals(BigInteger.ONE)) {
            // ensure that g is a generator for p
            g = g.add(BigInteger.ONE);
        }
        return new BigInteger[]{p, g};
    }
}
