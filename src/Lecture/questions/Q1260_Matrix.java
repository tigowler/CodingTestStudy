package Lecture.questions;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260_Matrix {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;
    static int[][] adj;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();
        adj = new int[N+1][N+1];
        for (int i=1; i<=M; i++){
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x][y]=1;
            adj[y][x]=1;
        }

    }

    // x 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(' ');
        for (int y=1; y<=N; y++){
            if (adj[x][y]==0) continue;
            if (visit[y]) continue;
            dfs(y);
        }
    }

    // start 에서 시작해서 갈 수 있는 정점들을 모두 탐색하기
    static void bfs(int x) {
        Queue<Integer> que = new LinkedList<>();

        que.add(x);
        visit[x] = true;

        while(!que.isEmpty()){
            x = que.poll();
            sb.append(x).append(' ');
            for (int y=1; y<=N; y++){
                if (adj[x][y]==0) continue;
                if (visit[y]) continue;

                que.add(y);
                visit[y] = true;
            }
        }
    }

    static void pro() {
        visit = new boolean[N+1];
        dfs(V);
        sb.append('\n');
        for (int i=1; i<=N; i++) visit[i] = false;
        bfs(V);

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
