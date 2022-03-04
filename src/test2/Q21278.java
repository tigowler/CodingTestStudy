package test2;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q21278 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[][] D;
    static ArrayList<Integer>[] con;

    static void input(){
        n = in.nextInt(); m = in.nextInt();
        D = new int[n+1][n+1];
        con = new ArrayList[n+1];
        for (int i=1; i<=n; i++){
            con[i] = new ArrayList<>();
        }

        for (int i=1; i<=m; i++){
            int x = in.nextInt(), y = in.nextInt();
            con[x].add(y);
            con[y].add(x);
        }
    }

    static void bfs(int S){
        for (int i=1; i<=n; i++) D[S][i] = -1;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(S);
        D[S][S] = 0;
        while(!Q.isEmpty()){
            int x = Q.poll();
            for (int y : con[x]){
                if (D[S][y]==-1){
                    D[S][y] = D[S][x]+1;
                    Q.add(y);
                }
            }
        }
    }

    static void pro(){
        //최단거리 계산
        for (int i=1; i<=n; i++) bfs(i);

        //모든 경우로 세워보기
        int ans = Integer.MAX_VALUE, ans_x = 0, ans_y=0;
        for (int i=1; i<=n; i++){
            for (int j=i+1; j<=n; j++){
                int cnt=0;
                for (int k=1; k<=n; k++){
                    cnt+=Math.min(D[k][i], D[k][j]);
                }
                if (ans>cnt){
                    ans = cnt;
                    ans_x = i;
                    ans_y = j;
                }
            }
        }
        sb.append(ans_x).append(' ').append(ans_y).append(' ').append(ans*2);
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
