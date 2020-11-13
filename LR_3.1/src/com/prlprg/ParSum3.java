package src.com.prlprg;

import java.util.concurrent.CyclicBarrier;

public class ParSum3 {

    private int numOfThreads;

    public ParSum3(int threads) {
        this.numOfThreads = threads;
    }

    public void getSum(int[] arr) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(numOfThreads, new PrintResult());

        int numbOfThreadElements = (int) Math.ceil(arr.length * 1.0 / numOfThreads);
        for (int i = 0; i < numOfThreads; i++) {
            new ParSumThread3(cyclicBarrier, arr, i * numbOfThreadElements, (i + 1) * numbOfThreadElements);
        }
    }
}
