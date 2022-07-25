package Lecture.test1;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q20181 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static class Interval{
        int left;
        long satisfy;
    }
    static int N, K;
    static ArrayList<Interval>[] intervals;
    static long[] A, Dy; //a: x번 먹이의 만족도, dy: x번 먹이까지 먹어서 얻을 수 있는 최대 탈피 에너지

    static void input(){
        N = in.nextInt();
        K = in.nextInt();
        A = new long[N + 1];
        Dy = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = in.nextLong();
        }
        intervals = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++){
            intervals[i] = new ArrayList<>();
        }
    }

    static void pro(){
        long sum = 0;

        for (int L=1, R=0; L<=N; L++){
            while (sum < K && R+1<=N) sum+=A[++R];
            if (sum>=K){
                Interval i = new Interval();
                i.left = L;
                i.satisfy = sum-K;
                intervals[R].add(i);
            }
            sum-=A[L];
        }

        for (int R = 1; R<=N; R++){
            Dy[R] = Dy[R-1];
            for (Interval i : intervals[R]){
                Dy[R] = Math.max(Dy[R], Dy[i.left-1] + i.satisfy);
            }
        }
        System.out.println(Dy[N]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
