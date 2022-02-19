package questions;

import java.util.Arrays;
import java.util.Scanner;

public class Q1920 {
    static Scanner in = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] A, B;

    static void input(){
        N = in.nextInt();
        A = new int[N+1];
        for (int i=1; i<=N; i++){
            A[i] = in.nextInt();
        }
        M = in.nextInt();
        B = new int[M+1];
        for (int i=1; i<=M; i++){
            B[i] = in.nextInt();
        }
    }

    static void search(int[] A, int L, int R, int X){
        boolean find = false;
        while(L<=R){
            int mid = (L+R)/2;
            if (A[mid]==X){
                find = true;
                break;
            }
            else if (A[mid]<X){
                L = mid+1;
            }
            else{
                R = mid-1;
            }
        }

        if (find) System.out.println(1);
        else System.out.println(0);
    }

    static void pro(){
        Arrays.sort(A, 1, N+1);
        for (int i=1; i<=M; i++){
            search(A, 1, A.length-1, B[i]);
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
