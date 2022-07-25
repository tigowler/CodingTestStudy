package Lecture.ParametricSearch;

import java.io.*;
import java.util.StringTokenizer;

public class Q1300 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int k;

    static void input(){
        N = in.nextInt();
        k = in.nextInt();
    }

    static void pro(){
        int left = 1, right = k;
        while(left<right){
            int count=0;
            int mid = (left+right)/2;
            for (int i=1; i<=N; i++){
                count+=Math.min(mid/i, N);
            }
            if (k<=count){
                right = mid;
            }
            else {
                left = mid+1;
            }
        }
        System.out.println(right);
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
