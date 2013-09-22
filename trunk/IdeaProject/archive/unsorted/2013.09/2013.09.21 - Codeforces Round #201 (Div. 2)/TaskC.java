package coding;

import ru.ifmo.niyaz.io.FastScanner;
import ru.ifmo.niyaz.io.FastPrinter;

import java.util.Arrays;
import java.util.TreeSet;

public class TaskC {
    public void solve(int testNumber, FastScanner in, FastPrinter out) {
    int n=in.nextInt();
    int[] A= in.readIntArray(n);
     long g=0;
        for (int i = 0; i < n; i++) {
           g=  gcd(A[i],g);
        }
        int max=0;
        TreeSet<Integer> ts= new TreeSet<Integer>();
        for (int i = 0; i < n; i++) {
               A[i]/=(int)g;
            max=Math.max(max,A[i]);
            ts.add(A[i]);
        }

        int ans=max;
        for (Integer t : ts) {
          if(t<=max)ans--;
        }
      //  System.out.println(ans);
        if(ans%2==1)
            out.println("Alice");
        else
            out.println("Bob");

    }
    public static long gcd(long a, long b) {
      long c = 0;

    if(a<0)  a=-a;
      if(b<0)  b=-b;
      while (b>0) {
         c = a % b;
         a = b;
         b = c;
      }
      return a;
    }
}
