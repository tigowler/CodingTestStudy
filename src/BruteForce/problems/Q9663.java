package BruteForce.problems;

import java.util.Scanner;

public class Q9663 {
    static StringBuilder sb = new StringBuilder();
    static int N, ans;
    static int[] col;

    static void input(){
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        col = new int[N+1];
    }

    //서로 공격할 수 있는 위치인지 확인
    static boolean attackable(int r1, int c1, int r2, int c2){
        //같은 column에 위치하는 지 확인
        // row는 하나씩 놓는다고 가정하기 때문에 확인X
        if (c1==c2) return true;
        if (r1-c1==r2-c2) return true;
        if (r1+c1==r2+c2) return true;
        return false;
    }

    //rec_func가 한 단계씩 진행될 때 마다 다음 row의 어느 column에 queen을 놓을 지 정함
    static void rec_func(int row){
        if (row == N+1){
            ans++;
        }
        else {
            for (int c = 1; c<=N; c++){ //column을 하나씩 돌면서
                boolean possible = true;
                //valid check (row, c)
                for (int i=1; i<=row-1; i++){ //첫번째부터 이전까지 놓은 queen 개수까지
                    //현재 놓을 수 있는지 확인하고픈 위치(row, c)
                    //반복문을 사용하며 이 때까지 놓은 queen의 위치(i, col[i])와 비교하며 확인
                    if (attackable(row, c, i, col[i])) {
                        possible = false;
                        break;
                    }
                }

                //attackable 하지 않으면 해당 row의 column에 queen을 놓고 다음 row로 진행
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
