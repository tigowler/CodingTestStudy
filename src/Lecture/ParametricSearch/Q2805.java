package Lecture.ParametricSearch;

import java.util.Scanner;

public class Q2805 {
    static Scanner in = new Scanner(System.in);
    static int N, M;
    static int[] A;

    static void input() {
        N = in.nextInt();
        M = in.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = in.nextInt();
        }
    }

    static boolean determination(int H) {
        // H 높이로 나무들을 잘랐을 때, M 만큼을 얻을 수 있으면 true, 없으면 false를 return하는 함수
        long sum = 0;
        for (int i=1; i<=N; i++){
            if (A[i] > H){
                sum+=A[i] - H;
            }
        }
        return sum >= M;
    }

    static void pro() {
        long L = 0, R = 2000000000, ans = 0;
        // [L ... R] 범위 안에 정답이 존재한다!
        // 이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!
        while(L<=R){
            long mid = (L+R)/2;
            if (determination((int)mid)){
                ans = mid;
                L = mid+1;
            }
            else {
                R = mid-1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}