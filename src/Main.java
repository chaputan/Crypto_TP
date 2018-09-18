import java.math.BigInteger;

class Main {

    public static void main(String[] args) {

        BigInteger ens = new BigInteger("377");
        int compteur = 0;

        for(int i = 0; i < 377; i++) {
            try{
                BigInteger m = new BigInteger(String.valueOf(i));
                m.modInverse(new BigInteger("377"));
                compteur++;
            } catch (ArithmeticException ae) {

            }
        }

        System.out.println(compteur);
    }
}
