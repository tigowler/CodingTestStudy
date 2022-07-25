package Lecture.test2_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q21940 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int INF = 0x3f3f3f3f;
    static int n, m;
    static int[][] graph = new int[201][201];
    static ArrayList<Integer> friends, result;

    static void input(){
        n = in.nextInt();
        m = in.nextInt();
        //최단 거리 테이블을 모두 max 값으로 초기화
        for (int i=0; i<201; i++){
            Arrays.fill(graph[i], INF);
        }

        //자기 도시에서 자기 도시로의 비용은 0으로 초기화
        for (int a = 1; a<=n; a++){
            for (int b = 1; b<=n; b++){
                if (a==b) graph[a][b] = 0;
            }
        }

        //각 간선 정보를 입력 받아 값을 초기화
        for (int i=0; i<m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int cost = in.nextInt();
            graph[a][b] = cost;
        }

        int k = in.nextInt();
        friends = new ArrayList<>();
        result = new ArrayList<>();
        for (int i=0; i<k; i++){ //친구들이 사는 도시 번호 입력
            int c = in.nextInt();
            friends.add(c);
        }
    }

    static void pro(){
        //플로이드 워셜 알고리즘을 이용, 모든 도시에 대하여 모든 다른 도시로의 최단거리 계산
        for (int k = 1; k<=n; k++){
            for (int a = 1; a<=n; a++){
                for (int b=1; b<=n; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k]+graph[k][b]);
                }
            }
        }

        int max = INF;
        for (int i=1; i<=n; i++){
            int now = 0; //왕복 시간 최대값
            for (int j=0; j< friends.size(); j++){
                int friend = friends.get(j);
                if (graph[friend][i]==INF || graph[i][friend]==INF) now = Integer.MAX_VALUE;
                //i라는 도시에 갔다가 돌아오는 최대 왕복시간 구하기
                now = Math.max(now, graph[friend][i] + graph[i][friend]);
            }
            //왕복시간들 중 최대가 최소가 되는 도시 찾기
            if (max>now){
                result.clear();
                result.add(i);
                max = now;
            }
            else if(max==now){
                result.add(i);
            }
        }

        //출력
        for (int i=0; i<result.size(); i++){
            System.out.print(result.get(i) + " ");
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
