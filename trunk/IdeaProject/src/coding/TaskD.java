package coding;

import ru.ifmo.niyaz.io.FastScanner;
import ru.ifmo.niyaz.io.FastPrinter;

public class TaskD {
    public void solve(int testNumber, FastScanner in, FastPrinter out) {
        String s1 = in.readLine();
        String s2 = in.readLine();
        String vv = in.readLine();
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = vv.length();
        int[][][] dp= new int[n1+1][n2+1][n3+1];
        triple[][][] path= new triple[n1+1][n2+1][n3+1];
        if(s1.charAt(0)==s2.charAt(0)){
            if(s1.charAt(0)==vv.charAt(0))
            {dp[1][1][1]=1;
                path [1][1][1]=new triple(0,0,0);
            }
            else
                dp[1][1][0]=1;
            path [1][1][0]=new triple(0,0,0);

        }
        path [0][0][0]=new triple(0,0,0);

        for (int i = 1; i <= n1 ; i++) {
            //   System.out.println();
            for (int j = 1; j <= n2; j++) {
                if(i+j==2)continue;
                if(dp[i-1][j][0]>dp[i][j-1][0]) {
                    path [i][j][0]=new triple(i-1,j,0);
                }      // AJKEQSLOBSROFGZ
                else{
                    path [i][j][0]=new triple(i,j-1,0);
                }
                dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i][j-1][0]) ;

                for (int k = 1; k < n3 ; k++) {
                    dp[i][j][k]=Math.max(dp[i-1][j][k],dp[i][j-1][k]) ;
                    if(dp[i-1][j][k]>dp[i][j-1][k]) {
                        path [i][j][k]=new triple(i-1,j,k);
                    }
                    else{
                        path [i][j][k]=new triple(i,j-1,k);
                    }
                    if(s1.charAt(i-1)==s2.charAt(j-1)&&s1.charAt(i-1)==vv.charAt(k-1))
                    {
                        if(dp[i][j][k]<dp[i-1][j-1][k-1]+1) {
                            path [i][j][k]=new triple(i-1,j-1,k-1);
                        }
                        dp[i][j][k]=Math.max( dp[i][j][k],dp[i-1][j-1][k-1]+1) ;
                    }
                }
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    int max=0,km=0;
                    triple pp=new triple(0,0,0);
                for (int k = 0; k < n3; k++) {
                    if(s1.charAt(i-1)!=vv.charAt(k))
                    {
                        if(dp[i][j][0]<dp[i-1][j-1][k]+1) {
                            path [i][j][0]=new triple(i-1,j-1,k);
                            System.out.println(s1.charAt(i-1)+" sfjd "+vv.charAt(k)+" "+k+" "+i);
                        }
                        dp[i][j][0]=Math.max( dp[i][j][0],dp[i-1][j-1][k]+1) ;

                    }
                    else {

                    }
                }
                //   System.out.print(dp[i][j][0]+" ");
            }   }
        }
        int max=0,kk=-1;
        for (int i = 0; i < n3 ; i++) {
            if(max<dp[n1][n2][i]){max=dp[n1][n2][i];   kk=i;}
        }
        //   System.out.println(max);
        if(max==0) {out.println(0);
            return;}
        int curi=n1,curj=n2,curk=kk;
        StringBuilder ans= new StringBuilder();
        while(curi+curj+curk>0){

            int pi=curi,pj=curj,pk=curk;
              System.out.println(pi+" "+pj+" "+pk+" "+ans+" "+dp[pi][pj][pk]);
            if(pi==0||pj==0||dp[pi][pj][pk]==0)break;
            curi=path[pi][pj][pk].i;
            curj=path[pi][pj][pk].j;
            curk=path[pi][pj][pk].k;
            if(pi-curi+pj-curj==2){
                ans.append(s1.charAt(curi));
            }
        }
        ans.reverse();
        out.println(ans);

    }
    class triple {
        int i,j,k;

        triple(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }
}
