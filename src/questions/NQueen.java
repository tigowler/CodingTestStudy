package questions;

import java.util.Scanner;

//#9663
public class NQueen {
    static StringBuilder sb = new StringBuilder();
    static int N, ans;
    static int[] col;

    static void input(){
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        col = new int[N+1];
    }

    static boolean attackable(int r1, int c1, int r2, int c2){
        if (c1==c2) return true;
        if (r1-c1==r2-c2) return true;
        if (r1+c1==r2+c2) return true;
        return false;
    }

    static void rec_func(int row){
        if (row == N+1){
            ans++;
        }
        else {
            for (int c = 1; c<=N; c++){
                boolean possible = true;
                //valid check (row, c)
                for (int i=1; i<=row-1; i++){
                    //(i, col[i])
                    if (attackable(row, c, i, col[i])) {
                        possible = false;
                        break;
                    }
                }

                if (possible){
                    col[row] = c;
                    rec_func(row+1);
                    col[row] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {
        input();
        rec_func(1);
        sb.append(ans);
        System.out.println(sb.toString());
    }
}
