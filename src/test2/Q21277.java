package test2;

import java.io.*;
import java.util.StringTokenizer;

public class Q21277 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n1, m1, n2, m2, ans = Integer.MAX_VALUE;
    static char[][] a1, a2;

    static void rot(char[][] a, int n, int m){
        char[][] tmp = new char[n][m];
        for (int i=0; i<n; i++)
            for (int j=0; j<m; j++)
                tmp[i][j] = a[i][j];

        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                a[i][j] = tmp[n-1-j][i];
    }

    static boolean check(char[][] a1, int n1, int m1, char[][] a2, int n2, int m2, int x, int y){
        for (int i=0; i<n1; i++){
            for (int j=0; j<m1; j++){
                if (a1[i][j] == '0') continue;
                int idx1 = i+x;
                int idx2 = j+y;
                if (0<=idx1 && idx1<n2 && 0<=idx2 && idx2<m2 && a2[idx1][idx2] == '1') return false;
            }
        }
        return true;
    }

    static void input(){
        n1 = in.nextInt(); m1 = in.nextInt();
        a1 = new char[100][100];
        a2 = new char[100][100];

        for (int i=0; i<n1; i++){
            String t = in.next();
            for (int j = 0; j<m1; j++) a1[i][j] = t.charAt(j);
        }

        n2 = in.nextInt(); m2 = in.nextInt();
        for (int i=0; i<n2; i++){
            String t = in.next();
            for (int j=0; j<m2; j++) a2[i][j] = t.charAt(j);
        }
    }


    static void pro(){
        for (int rot = 0; rot<4; rot++){
            for (int x = -100; x<=100; x++){
                for (int y = -100; y<=100; y++){
                    int v1, v2;
                    int l = Math.min(1, 1+x);
                    int r = Math.max(n2, n1+x);
                    v1 = r - l + 1;

                    l = Math.min(1, 1+y);
                    r = Math.max(m2, m1+y);
                    v2 = r - l + 1;

                    if (v1*v2 >= ans) continue;
                    if (check(a1, n1, m1, a2, n2, m2, x, y)){
                        ans = v1 * v2;
                    }
                }
            }
            rot(a1, n1, m1);
            int tmp = n1;
            n1 = m1;
            m1 = tmp;
        }
        System.out.println(ans);
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
