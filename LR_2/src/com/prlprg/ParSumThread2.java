package src.com.prlprg;

public class ParSumThread2 extends Thread {

    private long[] arr;
    private int firstElemInd;
    private int lastElemInd;
    private long partSum;

    public ParSumThread2(long[] arr, int firstElemInd, int lastElemInd) {
        this.arr = arr;
        this.firstElemInd = firstElemInd;
        this.lastElemInd = lastElemInd;
    }

    public long getPartSum() {
        return this.partSum;
    }

    @Override
    public void run() {
        if (firstElemInd == lastElemInd) {
            partSum = arr[firstElemInd];
        } else {
            partSum = arr[firstElemInd] + arr[lastElemInd];
        }
    }
}
