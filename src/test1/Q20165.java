package test1;

import java.io.*;
import java.util.StringTokenizer;

public class Q20165 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int n, m, R, ans;
    static int[][] a, backup;

    static void input(){
        n = in.nextInt();
        m = in.nextInt();
        R = in.nextInt();
        a = new int[n + 1][m + 1];
        backup = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                a[i][j] = in.nextInt();
                backup[i][j] = a[i][j];
            }
    }

    static void attack(int x, int y, char dir){
        if (a[x][y]==0) return;
        int dx = 0, dy=0;
        if (dir == 'E') dy = 1;
        else if (dir == 'W') dy = -1;
        else if (dir == 'S') dx = 1;
        else dx = -1;

        int cnt = a[x][y];
        while(x >= 1 && x<=n && y>=1 && y<=m && cnt>=1){
            if (a[x][y] != 0) ans++;

            cnt = Math.max(cnt - 1, a[x][y] -1);

            a[x][y] = 0;
            x+=dx;
            y+=dy;
        }
    }


    static void pro(){
        for (int rep = 1; rep<=R; rep++){
            int X, Y;
            String dir;

            X = in.nextInt();
            Y = in.nextInt();
            dir = in.next();
            attack(X, Y, dir.charAt(0));

            //defence
            X = in.nextInt();
            Y = in.nextInt();
            a[X][Y] = backup[X][Y];
        }

        System.out.println(ans);
        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                if (a[i][j] == 0) System.out.print("F ");
                else System.out.print("S ");
            }
            System.out.println();
        }
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
