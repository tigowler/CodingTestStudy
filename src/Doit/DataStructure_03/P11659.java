package Doit.DataStructure_03;

import java.util.Scanner;

public class P11659 { //구간 합 구하기
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int C = in.nextInt();
        int[] S = new int[N+1];
        for (int i=1; i<=N; i++){
            S[i] = S[i-1]+in.nextInt();
        }

        for (int i=0; i<C; i++){
            int l = in.nextInt(), r=in.nextInt();
            System.out.println(S[r]-S[l-1]);
        }
    }
}
