package test2_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q21924 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static class Edge implements Comparable<Edge>{
        public long distance;
        public int nodeA;
        public int nodeB;

        public Edge(long distance, int nodeA, int nodeB){
            this.distance = distance;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        @Override
        public int compareTo(Edge other){
            if (this.distance < other.distance){
                return -1;
            }
            return 1;
        }
    }
    static int n, m;
    static int[] parent = new int[100001];
    static ArrayList<Edge> edges = new ArrayList<>();
    static long result = 0; //최종 비용

    static int findParent(int x){
        if (x==parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if (a<b) parent[b] = a;
        else parent[a] = b;
    }

    static void input(){
        n = in.nextInt();
        m = in.nextInt();

        //부모를 자기 자신으로 초기화
        for (int i=1; i<=n; i++){
            parent[i] = i;
        }

        //간선 정보 입력
        for (int i=0; i<m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            long cost = in.nextLong();
            edges.add(new Edge(cost, a, b));
            result += cost;
        }
    }

    static void pro(){
        //간선을 비용순으로 정렬
        Collections.sort(edges);

        int count = 0;
        for (int i=0; i<edges.size(); i++){
            long cost = edges.get(i).distance;
            int a = edges.get(i).nodeA;
            int b = edges.get(i).nodeB;
            //사이클이 생기지 않는 경우만 포함
            if (findParent(a) != findParent(b)){
                unionParent(a, b);
                result -= cost;
                count++;
            }
        }

        if (count!=n-1) System.out.println(-1);
        else System.out.println(result);
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
