package coding;

import java.math.BigInteger;
import java.util.Arrays;

public class YetAnotherTwoTeamsProblem {
    public long count(int[] skill) {
        Arrays.sort(skill);
        long sum=0;
        int n=skill.length;

        for (int i = 0; i <n; i++) {
             sum+=skill[i];
        }
        long lb=sum/2+1;
        long ret=0;
        int pre=-1,k=0;
        for (int i = 0; i < n; i++) {
          if(skill[i]==pre){
              k++;
          }
            else if(i>0){
          long ub=pre+(sum-1)/2;
          long[][] DP = new long[2][(int)ub+62000];// used , sum
              int max=0;
              for (int j = 1; j <=k && j*pre<=ub ; j++) {
                  DP[i%2][j*pre] = ncr(k,j).longValue();
                  max=j*pre;
              }
              for (int j = i; j < n; j++) {
                 max+=skill[j];
                  for (int l = 0; l <=Math.min(max,ub+1) ; l++) {
                      DP[(j+1)%2][l]=0;
                  }
                  for (int l = 0; l <=Math.min(max,ub+1) ; l++) {

                     DP[(j+1)%2][l]+=DP[(j)%2][l];
                      DP[(j+1)%2][l+skill[j]]+=DP[(j)%2][l];

                  }

              }
              for (long ss = lb; ss <=ub ; ss++) {
                  ret+=DP[n%2][(int)ss];
              }

         //     System.out.println(i+ "  "+ret);


              k=1;pre=skill[i];
          }
            else{
              k=1;pre=skill[i];
          }


        }

        long ub=pre+(sum-1)/2;
        long[][] DP = new long[2][(int)ub+62000];// used , sum
        int max=0;
        for (int j = 1; j <=k && j*pre<=ub ; j++) {
            DP[(n)%2][j*pre] = ncr(k,j).longValue();
            max=j*pre;
        }
     //   System.out.println(lb+" "+ub+" "+k+" "+pre+" "+DP[n%2][3]);

        for (long ss = lb; ss <=ub ; ss++) {
            ret+=DP[n%2][(int)ss];
        }

        return ret;
    }
    public static BigInteger fact(long n){
        long i=n,j;
        BigInteger result;
        result = BigInteger.valueOf(1);
        for (j=i;j>=1;j--)
            result = result.multiply(BigInteger.valueOf(j));
        return result;
    }

    public static BigInteger ncr(long n,long r){
        long i=n,j;
        BigInteger result;
        result = BigInteger.valueOf(1);
        for (j=n;j>=n-r+1;j--)
            result = result.multiply(BigInteger.valueOf(j));

        return result.divide(fact(r));
    }

}
