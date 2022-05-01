package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Q7795 {
    static int T, N, M;
    static int[] A, B;
    static Scanner in = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static void input(){
        T = in.nextInt();
        for (int i=0; i<T; i++){
            N = in.nextInt();
            M = in.nextInt();
            pro(N, M);
        }
    }

    static void pro(int N, int M){
        int ans = 0;
        A = new int[N];
        B = new int[M];
        for (int i=0; i<N; i++){
            A[i] = in.nextInt();
        }
        for (int i=0; i<M; i++){
            B[i] = in.nextInt();
        }

        Arrays.sort(B);

        for (int i=0; i<N; i++){
            ans += search(A[i]);
        }

        sb.append(ans).append('\n');
    }

    static int search(int X){
        int l = 0, r = M-1;
        int resIndex=-1;
        while(l<=r){
            int mid = (l+r)/2;
            if (B[mid]<X){
                resIndex = mid;
                l = mid+1;
            }
            else if(B[mid]>=X){
                r = mid-1;
            }
        }
        return resIndex+1;
    }

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }
}
