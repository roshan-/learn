package euler;

import java.math.BigDecimal;
import java.util.ArrayList;
import util.Result;

/**
 * Created by rdiwakar on 4/16/2017.
 */
public class Euler {

    private Euler() {}; // Static functions
    public static Result getNthPrime(int n) {
        long startTime= System.nanoTime();
        int primesFound= 2;
        long currentPrime= 3;
        Result[] results= new Result[n];
        results[0]= new Result(2, System.nanoTime()-startTime);
        results[1]= new Result(currentPrime, System.nanoTime()-startTime);

        do {
            boolean nextPrimeFound= false;

            do {
                int i=0;
                currentPrime++;
                boolean foundDivisor= false;
                long checkUpto = (long)Math.floor(Math.sqrt(currentPrime));
                while(results[i].getResult() <= checkUpto) {
                    if (currentPrime % results[i++].getResult() == 0) {
                        foundDivisor= true;
                        break;
                    }
                }
                if (!foundDivisor) {
                    nextPrimeFound= true;
                    results[primesFound]= new Result(currentPrime, System.nanoTime()-startTime);
                    primesFound++;
                }
            } while (!nextPrimeFound);

        } while (primesFound < n);

        for (int i=0; i<n; i++) {
        //    System.out.printf("%7d:%15d:%,15d\n",i, results[i].getResult(), results[i].getTimeToCompute());
        }
        return results[n-1];
    }

    public static long getLargeSum() {
        BigDecimal l= new BigDecimal("37107287533902102798797998220837590246510135740250");
        System.out.println(l.toString());
        return 0L;
    }

    public static void solveNthPrime() {
        int n=10001;
        Result result= Euler.getNthPrime(n);
        System.out.printf("%dth prime : %d, time:%,d%n",n, result.getResult(), result.getTimeToCompute());
    }

    public static void main(String[] args) {
        solveNthPrime();                          // 007
        //getLargeSum();                              // 013
    }

}
