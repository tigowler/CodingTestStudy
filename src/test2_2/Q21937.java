package test2_2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q21937 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M, X, count=0;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    static void input(){
        N = in.nextInt();
        M = in.nextInt();
        adj = new ArrayList[N+1];
        for (int i=1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }

        for (int i=1; i<=M; i++){
            int x = in.nextInt(), y = in.nextInt();
            adj[y].add(x);
        }
        X = in.nextInt();
    }

    static void dfs(int x){
        visit[x] = true;
        for (int y: adj[x]){
            if (visit[y]) continue;
            count++;
            dfs(y);
        }
    }

    static void pro(){
        visit = new boolean[N+1];
        dfs(X);
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
