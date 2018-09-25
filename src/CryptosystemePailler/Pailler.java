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

        return (BigInteger.ONE.add(n).modPow(messageToEncrypt,n.pow(2)).multiply(r.modPow(n, n.pow(2)))).mod(n.pow(2));
    }

    public static BigInteger decryption(BigInteger encryptedMessage, BigInteger n, BigInteger phiN) {

        BigInteger r = encryptedMessage.modPow(n.modPow(BigInteger.ONE.negate(),phiN), n);
        System.out.println("r après d = "+ r.toString());

        return (encryptedMessage.multiply(r.modPow(n.negate(), n.pow(2))).mod(n.pow(2)).subtract(BigInteger.ONE).divide(n));
    }

    public static void main(String args[]){
        BigInteger[] keys = KeyGen();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        BigInteger messageToEncrypt = BigInteger.probablePrime(512, new Random());
        if ((messageToEncrypt.compareTo(BigInteger.ZERO) == -1) || (messageToEncrypt.compareTo(keys[0]) == 1) || (messageToEncrypt.compareTo(BigInteger.ZERO) == 0)) {
            messageToEncrypt = BigInteger.probablePrime(512, new Random());
        }
        System.out.println("messageToEncrypt ="+ messageToEncrypt.toString());

        BigInteger c = encryption(messageToEncrypt,keys[0]);
        System.out.println("c = " + c.toString());

        BigInteger d = decryption(c,keys[0],keys[1]);
        System.out.println("d = " + d.toString());
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        BigInteger m1 = BigInteger.probablePrime(512, new Random());
        while ((m1.compareTo(BigInteger.ZERO) == -1) || (m1.compareTo(keys[0]) == 1) || (m1.compareTo(BigInteger.ZERO) == 0)) {
            m1 = BigInteger.probablePrime(512, new Random());
        }
        BigInteger m2 = BigInteger.probablePrime(512, new Random());
        while ((m2.compareTo(BigInteger.ZERO) == -1) || (m2.compareTo(keys[0]) == 1) || (m2.compareTo(BigInteger.ZERO) == 0)) {
            m2 = BigInteger.probablePrime(512, new Random());
        }

        System.out.println("m1+m2=" + m1.add(m2).toString());

        BigInteger r1 = BigInteger.probablePrime(512, new Random());
        while ((r1.compareTo(BigInteger.ZERO) == -1) || (r1.compareTo(keys[0]) == 1)) {
            r1 = BigInteger.probablePrime(512, new Random());
        }

        BigInteger r2 = BigInteger.probablePrime(512, new Random());
        while ((r2.compareTo(BigInteger.ZERO) == -1) || (r2.compareTo(keys[0]) == 1)) {
            r2 = BigInteger.probablePrime(512, new Random());
        }

        BigInteger c1 = encryption(m1,keys[0]);
        BigInteger c2 = encryption(m2,keys[0]);

        System.out.println("m1+m2=" + c1.multiply(c2).toString());


        BigInteger c1c2 = BigInteger.ONE.add(keys[0]).modPow(m1.add(m2),keys[0].pow(2)).multiply(r1.multiply(r2).modPow(keys[0],keys[0].pow(2))).mod(keys[0].pow(2));

        System.out.println("m1+m2=" + decryption(c1c2,keys[0],keys[1]).toString());


    }

}
