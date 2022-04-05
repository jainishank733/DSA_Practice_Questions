package session_33;

public class SieveOfEratosthenes {

    public static void main(String[] args) {

        int n = 1000000000;

        boolean[] notPrimes = new boolean[n + 1];

        notPrimes[0] = true;
        notPrimes[1] = true;

        for(int curr = 2; curr * curr <= n; curr++) {
            if(!notPrimes[curr]) {
                //curr ke saare multiple cut, yaani false or not prime krdo, except curr

                for(int i = curr * 2; i <= n; i = i + curr) {
                    notPrimes[i] = true;
                }
            }
        }

        for(int i = (1000000000 - 100000); i <= n; i++) {
            if(!notPrimes[i]) {
                System.out.println(i);
            }
        }
    }

}