package test2_1;

import java.io.*;
import java.util.StringTokenizer;

public class Q21920 {

    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, X;
    static int[] A;

    static void input(){
        N = in.nextInt();
        A = new int[N+1];
        for (int i=1; i<=N; i++){
            A[i] = in.nextInt();
        }
        X = in.nextInt();
    }

    static void pro(){
        long sum = 0;
        int count=0;
        for (int i=1; i<=N; i++){
            if (gcd(X, A[i])==1){
                sum+=A[i];
                count+=1;
            }
        }

        System.out.printf("%.6f", (double) sum/count);
    }

    public static long gcd(long x, long y){
        while(y!=0){
            long tmp = x%y;
            x=y;
            y=tmp;
        }
        return x;
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
