package Lecture.SortApplication;

import java.util.Arrays;
import java.util.Scanner;

public class Q1015 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] P;
    static Elem[] B;

    static class Elem implements Comparable<Elem>{

        public int num, idx;

        @Override
        public int compareTo(Elem other) {
            //Java에서 Object를 Sort할 때는 Stable 방식으로 정렬되기 때문에 index 순(사전순)으로 비교할 필요 X
            //if (this.num == other.num) return this.num - other.num;
            //return this.idx - other.idx;
            return this.num-other.num;

        }
    }

    static void input(){
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        B = new Elem[N];
        P = new int[N];
        for (int i=0; i<N; i++){
            B[i] = new Elem();
            B[i].num = in.nextInt();
            B[i].idx = i;
        }
    }

    static void pro(){
        Arrays.sort(B);
        for (int i=0; i<N; i++){
            P[B[i].idx] = i;
        }
        for (int num : P){
            sb.append(num).append(' ');
        }
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
    }
}
