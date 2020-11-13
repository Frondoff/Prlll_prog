package src.com.prlprg;

public class Main2 {
    private static final int N = 100;

    private static long[] createArr() {
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static void main(String[] args) {
        ParSum2 parSum2;
        if (N % 2 == 0) {
            parSum2 = new ParSum2(N / 2);
        } else {
            parSum2 = new ParSum2(N / 2 + 1);
        }
        System.out.println("Sum is 4999950000>> " + parSum2.getParSum(createArr()));
    }
}
