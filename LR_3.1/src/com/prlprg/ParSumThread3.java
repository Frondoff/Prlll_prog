package src.com.prlprg;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ParSumThread3 implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private int[] arr;
    private int firstElemInd;
    private int lastElemInd;
    private long partSum;

    public ParSumThread3(CyclicBarrier cyclicBarrier, int[] arr, int firstElemInd, int lastElemInd) {
        this.cyclicBarrier = cyclicBarrier;
        this.arr = arr;
        this.firstElemInd = firstElemInd;
        this.lastElemInd = lastElemInd;
        new Thread(this).start();
    }

    private void calcSum() {
        partSum = 0;
        for (int i = firstElemInd; i < lastElemInd; i++) {
            partSum += arr[i];
        }
    }

    @Override
    public void run() {
        calcSum();
        PrintResult.sum += partSum;
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.getCause();
        } catch (InterruptedException e) {
            e.getCause();
        }
    }
}
