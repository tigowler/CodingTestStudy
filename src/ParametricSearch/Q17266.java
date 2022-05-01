package ParametricSearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q17266 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] A;

    static void input(){
        N = in.nextInt();
        M = in.nextInt();
        A = new int[M+1];
        for (int i=1; i<=M; i++){
            A[i] = in.nextInt();
        }
    }

    static boolean determination(int X){
        int last = 0;
        for (int i=1; i<=M; i++){
            if (A[i]-X<=last){
                last = A[i]+X;
            } else {
                return false;
            }
        }
        return last>=N;
    }

    static void pro(){
        int L=1, R = N, ans=0;
        Arrays.sort(A, 1, M+1);
        while(L<=R){
            int mid = (L+R)/2;
            if (determination(mid)){
                R = mid-1;
                ans = mid;
            }
            else {
                L = mid+1;
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
