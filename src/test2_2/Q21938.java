package test2_2;

import java.io.*;
import java.util.StringTokenizer;
//연결 요소의 개수는 주로 dfs로 푼다.

public class Q21938 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M, T, count=0;
    static int[][] pixels, r, g, b;
    static boolean[][] visit;
    static int[][] dir = {{1,0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input(){
        N = in.nextInt();
        M = in.nextInt();
        pixels = new int[N][M];
        visit = new boolean[N][M];
        r = new int[N][M];
        g = new int[N][M];
        b = new int[N][M];
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                r[i][j] = in.nextInt();
                g[i][j] = in.nextInt();
                b[i][j] = in.nextInt();
            }
        }
        T = in.nextInt();
    }

    static void dfs(int x, int y){
        visit[x][y] = true;
        for (int k=0; k<4; k++){
            int nx = x+dir[k][0];
            int ny = y+dir[k][1];
            if (nx<0 || ny<0 || nx>=N || ny>=M) continue;
            if (pixels[nx][ny] == 0) continue;
            if (visit[nx][ny]) continue;
            dfs(nx, ny);
        }
    }

    static void pro(){
        //픽셀 값 변환하여 저장
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if ((r[i][j]+g[i][j]+b[i][j])/3 >= T) pixels[i][j] = 255;
                else pixels[i][j] = 0;
            }
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (!visit[i][j] && pixels[i][j] == 255){
                    count++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(count);
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
