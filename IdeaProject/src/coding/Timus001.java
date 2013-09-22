package coding;





import ru.ifmo.niyaz.io.FastScanner;
import ru.ifmo.niyaz.io.FastPrinter;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

public class Timus001 {
    public void solve(int testNumber, FastScanner in, FastPrinter out) {
        int L=in.nextInt();
        int  n=in.nextInt();
        int[] A;
        int[] t1= new int[n];
        int[] t2= new int[n];
        A=in.readIntArray(n);
        t1[0]=7;
        int mid;
        for (int i = 1; i < n; i++) {
                   t1[i]=t1[i-1]+A[i-1]+A[i];

        }
         mid=    (L+A[0]-1)/A[0];
        t2[0]=  (mid)*A[0];
         if(t2[0]<t1[0])
         {
             out.println("YES");
             return;

         }

        for (int i = 1; i < n; i++) {
         int stt=t2[i-1]+A[i-1];
        mid=(stt+A[i]-1-t1[i])/A[i];
            t2[i]=mid*A[i]+t1[i];
            if(t2[i]<t1[i])
            {
                out.println("YES");
                return;

            }



        }
        out.println("NO");
    }

}

