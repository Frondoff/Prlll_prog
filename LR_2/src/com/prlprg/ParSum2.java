package src.com.prlprg;

public class ParSum2 {

    private ParSumThread2[] parSumThreads;

    public ParSum2(int threads) {
        this.parSumThreads = new ParSumThread2[threads];
    }

    public long getParSum(long[] arr) {
        int numOfThreads;

        if (arr.length % 2 == 0) {
            numOfThreads = arr.length / 2;
        } else {
            numOfThreads = arr.length / 2 + 1;
        }

        for (int i = 0; i < numOfThreads; i++) {
            parSumThreads[i] = new ParSumThread2(arr, i, arr.length - i - 1);
            parSumThreads[i].start();
        }

        try {
            for (ParSumThread2 thread : parSumThreads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.getCause();
        }

        long[] arr2 = new long[numOfThreads];

        for (int i = 0; i < numOfThreads; i++) {
            arr2[i] = parSumThreads[i].getPartSum();
        }

        if (arr2.length > 1) {
            return getParSum(arr2);
        } else {
            return arr2[0];
        }
    }
}
