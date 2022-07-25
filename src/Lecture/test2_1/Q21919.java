package Lecture.test2_1;

import java.io.*;
import java.util.StringTokenizer;

public class Q21919 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) {
        n = in.nextInt();
        long ans = 1;
        for (int i=0; i<n; i++){
            long a;
            a = in.nextInt();
            if (isPrimeNumber(a)){
                ans = lcm(ans, a);
            }
        }
        if (ans==1) System.out.println(-1);
        else System.out.println(ans);
    }

    private static long lcm(long x, long y) {
        return x / gcd(x, y) * y;
    }

    private static boolean isPrimeNumber(long a) {
        for (long i=2; i<=Math.sqrt(a); i++){
            if (a%i==0){
                return false;
            }
        }
        return true;
    }

    public static long gcd(long x, long y){
        while(y!=0){
            long tmp = x%y;
            x=y;
            y=tmp;
        }
        return x;
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
