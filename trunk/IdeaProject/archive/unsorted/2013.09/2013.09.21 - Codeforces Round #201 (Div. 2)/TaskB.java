package coding;

import ru.ifmo.niyaz.io.FastScanner;
import ru.ifmo.niyaz.io.FastPrinter;

public class TaskB {
    public void solve(int testNumber, FastScanner in, FastPrinter out) {
        int n = in.nextInt();
        int[] A = in.readIntArray(n);
        int fp = 0;

        for (int i = 0; i < n; i++) {
            if (A[i] == i) {fp++;

            }
        }
        int chk = 0;
        for (int i = 0; i < n; i++) {

            if (A[i] != i && A[A[i]] == i) {
                chk = 1;
                break;
            }
        }
        //   System.out.println(fp);
        if (chk == 1) fp += 2;
        else if(fp!=n)fp++;
        out.println(fp);

    }
}
