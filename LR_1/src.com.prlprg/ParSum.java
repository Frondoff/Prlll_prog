package src.com.prlprg;

public class ParSum {

    private ParSumThread[] parSumThreads;
    private int numOfThreads;

    public ParSum(int threads) {
        this.numOfThreads = threads;
        this.parSumThreads = new ParSumThread[threads];
    }

    public long getParSum(int[] arr) {
        long result = 0;
        int numbOfThreadElements = (int) Math.ceil(arr.length * 1.0 / numOfThreads);

        for (int i = 0; i < numOfThreads; i++) {
            parSumThreads[i] = new ParSumThread(arr, i * numbOfThreadElements, (i + 1) * numbOfThreadElements);
            parSumThreads[i].start();
        }

        try {
            for (ParSumThread thread : parSumThreads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.getCause();
        }

        for (ParSumThread thread : parSumThreads) {
            result += thread.getPartSum();
        }

        return result;
    }
}
