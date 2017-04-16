package euler;

import java.util.ArrayList;
import util.Result;

/**
 * Created by rdiwakar on 4/16/2017.
 */
public class Euler {
    public static Result getNthPrime(int n) {
        long startTime= System.nanoTime();
        int primesFound= 1;
        long currentPrime= 2;
        Result[] results= new Result[n];
        results[0]= new Result(currentPrime, System.nanoTime()-startTime);

        do {
            boolean nextPrimeFound= false;
            do {
                int i=0;
                currentPrime++;
                while(i<primesFound) {
                    if (currentPrime % results[i++].getResult() == 0) break;
                }
                if (i==primesFound) {
                    nextPrimeFound= true;
                    results[primesFound]= new Result(currentPrime, System.nanoTime()-startTime);
                    primesFound++;
                }
            } while (!nextPrimeFound);

        } while (primesFound < n);

        for (int i=0; i<n; i++) {
            //System.out.printf("%7d:%15d:%,15d\n",i, results[i].getResult(), results[i].getTimeToCompute());
        }
        return results[n-1];
    }

    public static void main(String[] args) {
        int n=10001;
        Result result= Euler.getNthPrime(n);
        System.out.printf("%dth prime : %d, time:%,d\n",n, result.getResult(), result.getTimeToCompute());
    }

}
