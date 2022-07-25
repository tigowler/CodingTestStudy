package Lecture.SortApplication;

import java.util.Arrays;
import java.util.Scanner;

public class Q10825 {
    static int N;
    static Elem[] a;
    static StringBuilder sb = new StringBuilder();

    static class Elem implements Comparable<Elem>{

        public String name;
        public int korean, english, math;

        @Override
        public int compareTo(Elem other) {
            //국어 점수 내림차순
            if(korean != other.korean) return other.korean - korean;
            // 영어 점수 오름차순
            if (english != other.english) return english - other.english;
            //수학 점수 내림차순
            if (math != other.math) return other.math - math;
            // 이름 순 정렬
            return name.compareTo(other.name);
        }
    }

    static void input(){
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        a = new Elem[N];
        for (int i=0; i<N; i++){
            a[i] = new Elem();
            a[i].name = in.next();
            a[i].korean = in.nextInt();
            a[i].english = in.nextInt();
            a[i].math = in.nextInt();
        }
    }

    static void pro(){
        Arrays.sort(a);
        for (int i=0; i<a.length; i++){
            sb.append(a[i].name).append('\n');
        }
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
    }
}
