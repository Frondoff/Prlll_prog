package src.com.prlprg;

public class ParSumThread extends Thread {

    private int[] arr;
    private int firstElemInd;
    private int lastElemInd;
    private long partSum;

    public ParSumThread(int[] arr, int firstElemInd, int lastElemInd) {
        this.arr = arr;
        this.firstElemInd = firstElemInd;
        this.lastElemInd = lastElemInd;
    }

    public long getPartSum() {
        return this.partSum;
    }

    @Override
    public void run() {
        partSum = 0;
        for (int i = firstElemInd; i < lastElemInd; i++) {
            partSum += arr[i];
        }
    }
}
