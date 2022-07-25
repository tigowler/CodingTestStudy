package Lecture.BruteForce;

import java.util.Scanner;

public class NoDupWithSeq {
    static int[] selected, used;
    static int N, M;
    public static StringBuilder sb = new StringBuilder();

    static void input(){
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        selected = new int[M+1];
    }

    static void rec_func(int k){
        if (k==M+1){
            for (int i=1; i<=M; i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }
        else{
            for (int cand=1; cand<=N; cand++){
                if (used[cand]==1) continue;
                selected[k] = cand; used[cand] = 1;

                rec_func(k+1);

                selected[k] = 0; used[cand] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);

        System.out.println(sb);
    }
}
