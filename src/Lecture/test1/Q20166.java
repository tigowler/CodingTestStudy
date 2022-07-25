package Lecture.test1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q20166 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int n, m, k;
    static String[] board;
    static int dx[] = {0, 0, -1, -1, -1, 1, 1, 1};
    static int dy[] = {1, -1, -1, 0, 1, -1, 0, 1};
    static Map<String, Integer> M = new HashMap<String, Integer>();

    static void input(){
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        board = new String[n];
        for (int i = 0; i < n; i++) {
            board[i] = in.nextLine();
        }
    }

    // 현재 위치 (i, j)와 지금까지 만든 경로 문자열 path, 그리고 그 길이 len
    // 앞으로 가능한 모든 경우를 탐색해주는 함수
    static void dfs(int i, int j, String path, int len){
        //path라는 문자열을 만들었음을 기록해주기
        if (M.containsKey(path)) M.put(path, M.get(path)+1);
        else M.put(path, 1);

        //최대 5개를 밟았으니 더 이상은 탐색을 하지 않는다.
        if (len == 5) return;

        //8방향으로 이동하기
        for (int dir = 0; dir<8; dir++){
            int ni = (i + dx[dir])%n;
            int nj = (j + dy[dir])%m;
            if (ni<0) ni += n;
            if (nj<0) nj += m;

            dfs(ni, nj, path+board[ni].charAt(nj), len+1);
        }
    }

    static void pro(){
        // 가능한 모든 단어의 등장 횟수 세기
        for (int i=0; i<n; i++){
            for (int j = 0; j<m; j++){
                dfs(i, j, Character.toString(board[i].charAt(j)), 1);
            }
        }
        // 신이 좋아하는 문자열들에 대한 대답하기
        while(k-->0){
            String chk = in.nextLine();
            if (M.containsKey(chk)) System.out.println(M.get(chk));
            else System.out.println(0);
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
