package src.com.prlprg;

public class Main {

    private static final int N = 500000;

    private static int[] createArr() {
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static void main(String[] args) {
        ParSum parSum = new ParSum(4);
        System.out.println("Sum is >> " + parSum.getParSum(createArr()));
    }
}
