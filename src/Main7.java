import java.math.BigInteger;
import java.util.Random;

public class Main7 {
    public static void main(String[] args) {
        //Calculer n=pq et ϕn = (p−1)(q−1)
        BigInteger p = BigInteger.probablePrime(512,new Random());
        BigInteger q = BigInteger.probablePrime(512,new Random());
        BigInteger n = p.multiply(q);
        BigInteger phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        System.out.println("n = "+ n.toString() +"\nphiN = "+phiN.toString());

    }


}
