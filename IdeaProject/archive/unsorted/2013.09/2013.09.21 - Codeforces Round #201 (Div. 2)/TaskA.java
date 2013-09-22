package coding;

import ru.ifmo.niyaz.io.FastScanner;
import ru.ifmo.niyaz.io.FastPrinter;

import java.util.Arrays;

public class TaskA {
    public void solve(int testNumber, FastScanner in, FastPrinter out) {
    int n=in.nextInt();
        int[]  A=in.readIntArray(n);
        Arrays.sort(A);
        int t=A[n-1];
        A[n-1]=A[0];
        A[0]=t;
        for (int i = 0; i < n; i++) {
            out.print(A[i] + " ");
        }
        out.println();
    }
}
