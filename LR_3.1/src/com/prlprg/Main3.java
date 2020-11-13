package src.com.prlprg;

public class Main3 {

    private static final int N = 100000;

    private static int[] createArr() {
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static void main(String[] args) {
        new ParSum3(4).getSum(createArr());
    }
}
