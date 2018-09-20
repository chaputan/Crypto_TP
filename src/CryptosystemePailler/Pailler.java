package CryptosystemePailler;

import java.math.BigInteger;
import java.util.Random;

public class Pailler {


    public static BigInteger[] KeyGen() {
        BigInteger p = BigInteger.probablePrime(512, new Random());
        BigInteger q = BigInteger.probablePrime(512, new Random());

        BigInteger n = p.multiply(q);
        BigInteger phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        return new BigInteger[]{n, phiN};
    }

    public static BigInteger encryption(BigInteger messageToEncrypt, BigInteger n) {
        BigInteger r = BigInteger.probablePrime(512, new Random());
        if ((r.compareTo(BigInteger.ZERO) == -1) || (r.compareTo(n) == 1)) {
            r = BigInteger.probablePrime(512, new Random());
        }
        System.out.println("r avant d = "+ r.toString());

        return (BigInteger.ONE.add(n).modPow(messageToEncrypt,n).multiply(r.modPow(n, n))).mod(n.pow(2));
    }

    public static BigInteger decryption(BigInteger encryptedMessage, BigInteger n, BigInteger phiN) {

        BigInteger r = encryptedMessage.modPow(n.modPow(BigInteger.ONE.negate(),phiN), n);
        System.out.println("r après d = "+ r.toString());

        return (encryptedMessage.multiply(r.modPow(n.negate(), n.pow(2))).mod(n.pow(2)).subtract(BigInteger.ONE).divide(n));
    }

    public static void main(String args[]){
        BigInteger[] keys = KeyGen();

        BigInteger messageToEncrypt = BigInteger.probablePrime(512, new Random());
        if ((messageToEncrypt.compareTo(BigInteger.ZERO) == -1) || (messageToEncrypt.compareTo(keys[0]) == 1) || (messageToEncrypt.compareTo(BigInteger.ZERO) == 0)) {
            messageToEncrypt = BigInteger.probablePrime(512, new Random());
        }
        System.out.println("messageToEncrypt ="+ messageToEncrypt.toString());

        BigInteger c = encryption(messageToEncrypt,keys[0]);
        System.out.println("c = " + c.toString());

        BigInteger d = decryption(c,keys[0],keys[1]);
        System.out.println("d = " + d.toString());

    }

}
