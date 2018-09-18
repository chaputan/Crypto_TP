import java.math.BigInteger;
import java.util.Scanner;

class Main3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nb = sc.nextInt();

        BigInteger n = new BigInteger(String.valueOf(nb));
        BigInteger a = new BigInteger("2");

        BigInteger res = a.modPow(n.subtract(BigInteger.ONE), n);

        if (res.equals(BigInteger.ONE)) {
            System.out.println("Il est premier");
        } else {
            System.out.println("Il n'est pas premier");
        }

    }
}
