package coding;

public class TheTree {
    public int maximumDiameter(int[] cnt) {
        int n=cnt.length;
        int ret=0;
        int max=0;
        int car=0,p=0;
        for (int i = n-1; i >=0 ; i--) {
           if(cnt[i]>1){ret++; car++;}
            else {
             if(2*(ret)+p>max){
                 max=2*ret+p;

             }
               ret=0;
               car++;
               p=car;

           }
        }
        if(2*(ret)+p>max){
            max=2*ret+p;

        }
        ret=0;
        car++;
        p=car;
        return max;
    }
}
