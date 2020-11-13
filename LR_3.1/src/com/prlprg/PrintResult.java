package src.com.prlprg;

public class PrintResult implements Runnable {

    public static long sum;

    @Override
    public void run() {
        System.out.println("Sum is >> " + sum);
    }
}
