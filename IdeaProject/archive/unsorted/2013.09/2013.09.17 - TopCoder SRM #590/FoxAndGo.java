package coding;

import java.util.TreeSet;

public class FoxAndGo {
    static boolean inr(int x,int y){

       return x<nn&&y<nn&&x>-1&&y>-1;
    }
    static int nn;
    public int maxKill(String[] b) {
       int n=b.length;
        nn=n;


        int ret=0,any=0;
        int co=0;
        for (int kk = 0; kk < n ; kk++) {
            for (int ll = 0; ll <n ; ll++) {
                      if(b[kk].charAt(ll)=='.'){
                          any=0;
                          boolean[][] vis= new boolean[n][n];
                          TreeSet<Integer> frnt= new TreeSet<Integer>();
                          TreeSet<Integer> nfrnt= new TreeSet<Integer>();
                          co=0;
                          String [] board= new String[n];
                          for (int i = 0; i < n; i++) {
                            if(i!=kk)board[i]=b[i];
                              else board[i]=b[i].substring(0,ll)+'x'+b[i].substring(ll+1,n);
                          }
//                          if(kk==3&&ll==2){
//                              for (int i = 0; i < n; i++) {
//                                  System.out.println(board[i]);
//                              }
//                          }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {


                if(board[i].charAt(j)=='o'&&!vis[i][j]){
                            // cc vis
                            frnt.add(100*i+j);
                            vis[i][j]=true;
                            co=0;
                            int sz=1;
                            while(frnt.size()>0){
                                for (int cur : frnt) {
                                       int ii=cur/100,jj=cur%100;
                                    int x,y;
                                   x=ii;y=jj-1;
                                    if(inr(x,y)&&!vis[x][y]){
                                        if(board[x].charAt(y)=='o'){
                                            vis[x][y]=true;
                                            sz++;
                                            nfrnt.add(x*100+y);

                                        }
                                        if(board[x].charAt(y)=='.'){
                                         //   vis[x][y]=true;
                                            co++;
                                        }

                                    }
                                    x=ii+1;y=jj;
                                    if(inr(x,y)&&!vis[x][y]){
                                        if(board[x].charAt(y)=='o'){
                                            vis[x][y]=true;
                                            sz++;
                                            nfrnt.add(x*100+y);

                                        }
                                        if(board[x].charAt(y)=='.'){
                                           // vis[x][y]=true;
                                            co++;
                                        }

                                    }
                                    x=ii-1;y=jj;
                                    if(inr(x,y)&&!vis[x][y]){
                                        if(board[x].charAt(y)=='o'){
                                            vis[x][y]=true;
                                            sz++;
                                            nfrnt.add(x*100+y);

                                        }
                                        if(board[x].charAt(y)=='.'){
                                          //  vis[x][y]=true;
                                            co++;
                                        }

                                    }
                                    x=ii;y=jj+1;
                                    if(inr(x,y)&&!vis[x][y]){
                                        if(board[x].charAt(y)=='o'){
                                            vis[x][y]=true;
                                            sz++;

                                            nfrnt.add(x*100+y);

                                        }
                                        if(board[x].charAt(y)=='.'){
                                           // vis[x][y]=true;
                                            co++;
                                        }

                                    }
                                }
                                frnt= (TreeSet<Integer>) nfrnt.clone();
                                nfrnt.clear();


                            }
                       //     System.out.println(co+" "+sz);
                            if(co==0)any+=sz;
                                  }

                        }
            }
        }    if(any>ret)ret=any;

            }
        }
        return ret;

    }
}
