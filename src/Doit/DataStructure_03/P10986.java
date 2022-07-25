package Doit.DataStructure_03;

import java.util.Scanner;

public class P10986 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        long[] S = new long[N];
        long[] C = new long[M];
        long res;
        S[0] = in.nextInt();
        for (int i=1; i<N; i++){
            S[i] = S[i-1] + in.nextInt();
        }

        for (int i=0; i<N; i++){
            int remainder = (int)(S[i]%M);
            C[remainder]++;
        }

        res = C[0];
        for (int i=0; i<M; i++){
            res += C[i]*(C[i]-1)/2;
        }
        System.out.println(res);
    }
}
