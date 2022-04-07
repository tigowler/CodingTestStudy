package BruteForce.problems;

import java.io.*;
import java.util.StringTokenizer;

public class Q1018 {
    static FastReader in  = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static char[][] arr;
    static int N, M, min = Integer.MAX_VALUE;

    static void input(){
        N = in.nextInt();
        M = in.nextInt();

        arr = new char[N+1][M+1];
        for (int i=0; i<N; i++){
            String str = in.next();

            for (int j=0; j<M; j++){
                arr[i][j] = str.charAt(j);
            }
        }
    }

    static void find(int x, int y){
        int end_x = x+8, end_y=y+8, count=0;
        char ch = arr[x][y];

        for (int i=x; i<end_x; i++){
            for (int j=y; j<end_y; j++){
                if (arr[i][j]!=ch){
                    count++;
                }
                ch = (ch=='W') ? 'B': 'W';
            }
            ch = (ch=='W') ? 'B': 'W';
        }

        count = Math.min(count, 64-count);
        min = Math.min(min, count);
    }

    static void pro(){
        int N_row = N-7, M_col = M - 7;

        for (int i=0; i<N_row; i++){
            for (int j=0; j<M_col; j++){
                find(i, j);
            }
        }

        System.out.println(min);
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
