import java.math.BigInteger;
import java.util.Random;

public class Main6 {

    public static void main(String[] args) {
        //A partir de quelle taille d’entree, votre test naif devient plus lent que le test de Fermat
        BigInteger p = BigInteger.probablePrime(512,new Random());
        BigInteger q = BigInteger.probablePrime(512,new Random());
        System.out.println("p = "+ p.toString() +"\nq = "+q.toString());
    }




}
