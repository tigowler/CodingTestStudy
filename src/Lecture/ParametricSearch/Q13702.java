package Lecture.ParametricSearch;

import java.io.*;
import java.util.StringTokenizer;

public class Q13702 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, K;
    static int[] A;

    static void input(){
        N = in.nextInt();
        K = in.nextInt();
        A = new int[N+1];
        for (int i=1; i<=N; i++){
            A[i] = in.nextInt();
        }
    }

    static boolean determination(int X){
        int count = 0;
        for (int i=1; i<=N; i++){
            if (A[i]/X>=1){
                count+=A[i]/X;
            }
        }

        return count>=K;
    }

    static void pro(){
        long L = 1, R = Integer.MAX_VALUE, ans=0;
        while(L<=R){
            long mid = (L+R)/2;
            if (determination((int)mid)){
                L = mid+1;
                ans = mid;
            }
            else {
                R = mid-1;
            }
        }

        sb.append(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
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
