package Lecture.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Q10816 {
    static Scanner in = new Scanner(System.in);
    static StringBuilder sb  = new StringBuilder();
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

    static int search_start(int[] A, int L, int R, int X){
        int resultIndex = R+1;
        while(L<=R){
            int mid = (L+R)/2;
            if (A[mid]==X){
                resultIndex = mid;
                R = mid-1;
            }
            else if(A[mid]<X){
                L = mid+1;
            }
            else {
                R = mid-1;
            }
        }

        return resultIndex;
    }

    static int search_end(int[] A, int L, int R, int X){
        int resultIndex = R+1;
        while(L<=R){
            int mid = (L+R)/2;
            if (A[mid]==X){
                resultIndex = mid;
                L = mid+1;
            }
            else if (A[mid]<X){
                L = mid+1;
            }
            else {
                R = mid-1;
            }
        }

        return resultIndex;
    }

    static void pro(){
        int start, end;
        Arrays.sort(A, 1, N+1);
        for (int i=1; i<=M; i++){
            start = search_start(A, 1, A.length-1, B[i]);
            end = search_end(A, 1, A.length-1, B[i]);

            if (start == A.length && end == A.length){
                sb.append(0).append(' ');
            }
            else {
                sb.append(end-start+1).append(' ');
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
    }
}
