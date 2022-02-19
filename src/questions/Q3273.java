package questions;

import java.util.Arrays;
import java.util.Scanner;

public class Q3273 {
    static Scanner in = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N, X, count=0;
    static int[] A;

    static void input(){
        N = in.nextInt();
        A = new int[N+1];
        for (int i=1; i<=N; i++){
            A[i] = in.nextInt();
        }
        X = in.nextInt();
    }

    static void search(int[] A, int L, int R, int X){
        while(L<=R){
            int mid = (L+R)/2;
            if (A[mid]==X){
                count++;
                return;
            }
            else if(A[mid]<X){
                L = mid+1;
            }
            else{
                R = mid-1;
            }
        }
    }

    static void pro(){
        Arrays.sort(A, 1, N+1);
        for (int i=1; i<=N; i++){
            search(A, 1, A.length-1, X-A[i]);
        }
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(count/2);
    }
}
