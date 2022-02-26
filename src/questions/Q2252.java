package questions;

import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q2252 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] indeg;
    static ArrayList<Integer>[] adj;

    static void input() {
        N = in.nextInt();
        M = in.nextInt();
        adj  = new ArrayList[N+1];
        indeg = new int[N+1];
        for (int i=1; i<=N; i++) adj[i] = new ArrayList<>();
        for (int i=1; i<=M; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            adj[x].add(y);
            indeg[y]++;
        }
    }

    static void pro() {
        Deque<Integer> queue = new LinkedList<>();
        for (int i=1; i<=N; i++){
            if (indeg[i]==0) queue.add(i);
        }

        while(!queue.isEmpty()){
            int x = queue.poll();
            sb.append(x).append(' ');
            for (int y: adj[x]){
                indeg[y]--;
                if (indeg[y] == 0) queue.add(y);
            }
        }

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
