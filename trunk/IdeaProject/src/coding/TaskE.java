package coding;

import ru.ifmo.niyaz.io.FastScanner;
import ru.ifmo.niyaz.io.FastPrinter;

import java.util.TreeSet;

public class TaskE {
    public void solve(int testNumber, FastScanner in, FastPrinter out) {
   int n=in.nextInt();
        TreeSet<Integer> ts= new TreeSet<Integer>();
        for (int i = 0; i <n ; i++) {
         ts.add(in.nextInt());
        }
      int a=in.nextInt(),b=in.nextInt();
        int[] x= new int[ts.size()];
        int i=0;
        for (Integer t : ts) {
             x[i]=t;i++;
        }
        int k=a-b+2;
        int[] max= new int[k];
    //    int[] ans= new int[k];
        int[] nxt= new int[k];
        for (int j = 0; j < x.length; j++) {
            int cur = x[j];
            int st=b/cur,en=a/cur;
            for (int l = st; l <=en ; l++) {
               int tt=l*cur;
                if(tt>=b)max[tt-b]=cur;
            }
        }
        for (int j = 0; j < k; j++) {
          nxt[j]=j+Math.max(2,max[j])-1;
            if(j>0)nxt[j]=Math.max(nxt[j-1],nxt[j]);
        }
        int st=0,cur=0;
        while(cur<a-b){
            cur=nxt[cur];
            st++;

         //   System.out.println(cur);
        }

        out.println(st);
    }
}
