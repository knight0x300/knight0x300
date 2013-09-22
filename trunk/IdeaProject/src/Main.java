import java.io.InputStreamReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.TreeSet;
import java.io.Reader;
import java.io.Writer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Nipuna Samarasekara
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastScanner in = new FastScanner(inputStream);
		FastPrinter out = new FastPrinter(outputStream);
		TaskE solver = new TaskE();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskE {
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

class FastScanner extends BufferedReader {

    public FastScanner(InputStream is) {
        super(new InputStreamReader(is));
    }

    public int read() {
        try {
            int ret = super.read();
//            if (isEOF && ret < 0) {
//                throw new InputMismatchException();
//            }
//            isEOF = ret == -1;
            return ret;
        } catch (IOException e) {
            throw new InputMismatchException();
        }
    }

    static boolean isWhiteSpace(int c) {
        return c >= 0 && c <= 32;
    }

    public int nextInt() {
        int c = read();
        while (isWhiteSpace(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int ret = 0;
        while (c >= 0 && !isWhiteSpace(c)) {
            if (c < '0' || c > '9') {
                throw new NumberFormatException("digit expected " + (char) c
                        + " found");
            }
            ret = ret * 10 + c - '0';
            c = read();
        }
        return ret * sgn;
    }

    public String readLine() {
        try {
            return super.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    }

class FastPrinter extends PrintWriter {

    public FastPrinter(OutputStream out) {
        super(out);
    }

    public FastPrinter(Writer out) {
        super(out);
    }


}

