package coding;



import ru.ifmo.niyaz.io.FastScanner;
import ru.ifmo.niyaz.io.FastPrinter;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

public class Timus001 {
    public void solve(int testNumber, FastScanner in, FastPrinter out) {
        int n=in.nextInt();
        int m=in.nextInt();
    TreeSet<Integer> ts1= new TreeSet<Integer>();
    TreeSet<Integer> ts2= new TreeSet<Integer>();
      ques[] A= new ques[2*n];
        for (int i = 0; i < A.length; i++) {
           A[i]= new ques(i+1);

        }
        for (int i = 0; i < m; i++) {
           int a=in.nextInt(),b=in.nextInt();
            A[a-1].assoc.add(b);
            A[b-1].assoc.add(a);
        }
        int cross=0;
        for (int i = 1; i <=n ; i++) {
               ts1.add(i);
        } for (int i = n+1; i <=2*n ; i++) {
               ts2.add(i);
        }
        for (int i = 1; i <=n ; i++) {
                   cross+=A[i-1].getcross(ts1);
        } for (int i = n+1; i <=2*n ; i++) {
            cross+=A[i-1].getcross(ts2);
        }
        while(cross>0){
            // 1
        //    System.out.println(cross);
            int fn=-1;
            for (Integer cur : ts1) {
                int crs=A[cur-1].getcross(ts1);
                if(A[cur-1].assoc.size()<2*crs){
                   fn=cur;
                    break;

                }
            }
            if(fn==-1){
                System.out.println("IMPOSSIBLE");
                       return;
            }
             ts1.remove(fn);
             ts2.add(fn);
            cross-=2*(2*A[fn-1].getcross(ts1)-A[fn-1].assoc.size()) ;
        //    System.out.println(cross+" "+fn);
           fn=-1;
            for (Integer cur : ts2) {
                int crs=A[cur-1].getcross(ts2);
                if(A[cur-1].assoc.size()<2*crs){
                    fn=cur;
                    break;

                }
            }
            if(fn==-1){
                System.out.println("IMPOSSIBLE");
                return;
            }
            ts2.remove(fn);
            ts1.add(fn);
            cross-=2*(2*A[fn-1].getcross(ts2)-A[fn-1].assoc.size()) ;
          //  System.out.println(cross+" "+fn);
        }
       // System.out.println(ts1);
        for (Integer integer : ts1) {
            out.print(integer + " ");
        }
        out.println();
      //  System.out.println(ts2);
        for (Integer integer : ts2) {
            out.print(integer + " ");
        }
        out.println();

    }
 class ques{
     int name;
     ArrayList<Integer> assoc= new ArrayList<Integer>();

     ques(int name) {
         this.name = name;
     }
     int getcross(TreeSet<Integer> ts){
         int ret=0;
         for (Integer con : this.assoc) {
             if(ts.contains(con))ret++;
         }
       return ret;
     }
 }
}


