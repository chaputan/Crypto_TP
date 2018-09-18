import java.math.BigInteger;
import java.util.Scanner;

class Main2 {

    public static void main(String[] args) {

        BigInteger prime = new BigInteger("2");
        Scanner sc = new Scanner(System.in);
        int nb = sc.nextInt();

        while (prime.intValue() < nb/2) {
            if(nb%prime.intValue() == 0) {
                System.out.println("Non, il n'est pas premier");
                return;
            }
            prime = prime.nextProbablePrime();
        }
        System.out.println("Il est premier");
    }
}
