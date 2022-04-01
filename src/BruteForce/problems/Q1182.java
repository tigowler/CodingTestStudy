package BruteForce.problems;

import java.util.Arrays;
import java.util.Scanner;

public class Q1182 {
    static int N, S, ans;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();

    static void input(){
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        S= in.nextInt();
        nums = new int[N+1];
        for (int i=1; i<=N; i++) nums[i] = in.nextInt();
    }

    static void rec_func(int k, int value){
        if (k==N+1){
            if (value == S) ans++;
        }
        else {
            rec_func(k+1, value+nums[k]);
            rec_func(k+1, value);
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1, 0);
        //ans가 정말 "진 부분집합"만 다루는지 확인하기
        if (S==0) ans--;
        sb.append(ans);
        System.out.println(sb);
    }
}
