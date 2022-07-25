package Lecture.test2;

import java.io.*;
import java.util.StringTokenizer;

public class Q21275 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static long X = Long.MAX_VALUE;
    static String repA, repB;

    static void input(){
        repA = in.next();
        repB = in.next();
    }

    static int conv(char x){
        if ('0' <= x && x <= '9') return x - '0';
        return x - 'a' + 10;
    }

    static long possible(String str, int base){
        long res = 0;
        for (char c : str.toCharArray()){
            if (conv(c) >= base) return -1;
            if (res>(X-conv(c)) / base) return -1;
            res = res*base+conv(c);
        }
        return res;
    }

    static void pro(){
        long ansVal = -1, ansA = 0, ansB = 0;
        for (int A = 2; A <= 36; A++){
            long valA = possible(repA, A);
            if (valA == -1) continue;

            for (int B = 2; B<=36; B++){
                if (A==B) continue;
                long valB = possible(repB, B);
                if (valB == -1) continue;

                if (valA != valB) continue;

                if (ansVal == -1){
                    ansVal = valA;
                    ansA = A;
                    ansB = B;
                } else {
                    System.out.println("Mutiple");
                    return;
                }
            }
        }
        if (ansVal == -1) sb.append("Impossible");
        else sb.append(ansVal).append(' ').append(ansA).append(' ').append(ansB);
        System.out.println(sb);
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
