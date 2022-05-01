package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

//int result = s1.compareTo(s2);
// 1) result<0 -> s1이 s2보다 아스키코드 순으로 앞설 때
// 2) result==0 -> s1과 s2가 동일
// 3) result>0 -> s1이 s2보다 아스키코드 순으로 뒤쪽에 위치할 때

public class Q1764 {
    static Scanner in = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N, M, count=0;
    static String[] A, B;

    static void input(){
        N = Integer.parseInt(in.next());
        M = Integer.parseInt(in.next());
        A = new String[N+1];
        B = new String[M+1];

        for (int i=1; i<=N; i++){
            A[i] = in.next();
        }
        for (int i=1; i<=M; i++){
            B[i] = in.next();
        }

    }

    static void search(String[] A, int L, int R, String X){
        while(L<=R){
            int mid = (L+R)/2;
            int compareResult = A[mid].compareTo(X);
            if (compareResult==0){
                count++;
                sb.append(A[mid]).append('\n');
                return;
            }
            else if(compareResult<0){
                L = mid+1;
            }
            else {
                R = mid-1;
            }
        }
    }

    static void pro(){
        Arrays.sort(A, 1, N+1);
        Arrays.sort(B, 1, M+1);

        for (int i=1; i<=M; i++){
            search(A, 1, A.length-1, B[i]);
        }
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(count);
        System.out.println(sb);
    }
}
