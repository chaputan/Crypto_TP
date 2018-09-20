import java.math.BigInteger;

class Main4 {

    public static void main(String[] args) {

        int nbIterations = 10000;
        int cpt = 0;

        for(int i = 2; i < nbIterations; i++) {
            boolean b1 = primaliteNaif(i);
            boolean b2 = primaliteFermat(i);
            if(b1 != b2) {
                cpt++;
                System.out.println("Erreur entre les deux fonctions pour i = "+i);
                System.out.println("Naif : "+b1+" Fermat : "+b2);
            }
        }

        System.out.println(cpt);
    }

    public static boolean primaliteNaif(int nb) {

        BigInteger prime = new BigInteger("2");

        while (prime.intValue() <= nb/2) {
            if(nb%prime.intValue() == 0) {
                return false;
            }
            prime = prime.nextProbablePrime();
        }
        return true;
    }

    public static boolean primaliteFermat(int nb) {
        BigInteger n = new BigInteger(String.valueOf(nb));
        BigInteger a = new BigInteger("2");

        BigInteger res = a.modPow(n.subtract(BigInteger.ONE), n);

        return res.equals(BigInteger.ONE);
    }
}
