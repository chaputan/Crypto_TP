import java.math.BigInteger;
import java.util.Random;

public class Main8 {
    public static void main(String[] args) {
        //G´en´erer al´eatoirement un nombre e de 16 bits qui soit premier avec ϕn
        //Calculer n=pq et ϕn = (p−1)(q−1)
        BigInteger p = BigInteger.probablePrime(512,new Random());
        BigInteger q = BigInteger.probablePrime(512,new Random());
        BigInteger n = p.multiply(q);
        BigInteger phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        System.out.println("n = "+ n.toString() +"\nphiN = "+phiN.toString());

        BigInteger e = BigInteger.probablePrime(16,new Random());

        while (!phiN.gcd(e).equals(BigInteger.ONE)){
            e = BigInteger.probablePrime(16,new Random());
        }
        System.out.println(phiN.gcd(e).toString());

        System.out.println("e ="+ e.toString());

        BigInteger d = e.modInverse(phiN);
        System.out.println("d ="+ d.toString());

        if(d.multiply(e).mod(phiN).equals(BigInteger.ONE)){
            System.out.println("La relation est vérifiée");
        }

        System.out.println(d.mod(phiN).multiply(e.mod(phiN)).toString());

    }
}
