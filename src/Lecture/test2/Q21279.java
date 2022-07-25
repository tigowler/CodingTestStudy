package Lecture.test2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q21279 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, C, W=-1, H=100000, cnt=0;
    static long ans=0, V=0;
    static ArrayList<Stone>[] X, Y;

    static void input(){
        n = in.nextInt();
        C = in.nextInt();
        X = new ArrayList[100005];
        Y = new ArrayList[100005];
        for (int i=0; i<=100001; i++){
            X[i] = new ArrayList<>();
            Y[i] = new ArrayList<>();
        }
        for (int i=1; i<=n; i++){
            int x = in.nextInt(), y = in.nextInt(), v = in.nextInt();
            X[x].add(new Stone(x, y, v));
            Y[y].add(new Stone(x, y, v));
        }
    }

    static void del(int y, int x){
        for (Stone stone : Y[y]){
            if (stone.x<=x){
                cnt--;
                V -= stone.v;
            }
        }
    }

    static void add(int x, int y){
        for (Stone stone : X[x]){
            if (stone.y<=y){
                cnt++;
                V+=stone.v;
            }
        }
    }

    static void pro(){
        while(W<=100000 && H>=0){
            if (cnt>C){
                del(H--, W);
            }
            else {
                add(++W, H);
            }
            if (cnt<=C){
                ans = Math.max(ans, V);
            }
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

    private static class Stone {
        int x;
        int y;
        int v;
        public Stone(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }
}
