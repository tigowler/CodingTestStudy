package test2_1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q21922 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[][] arr = new int[2001][2001];
    //방문 여부 체크 배열(BFS)
    static boolean[][][] visited = new boolean[2002][2001][4];
    //바람이 한 번 이상 지난 곳
    static boolean[][] checked = new boolean[2001][2001];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Point> starts = new LinkedList<>();
    static class Point{
        public int x, y, dir;
        public Point(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static void input(){
        n = in.nextInt();
        m = in.nextInt();
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                arr[i][j] = in.nextInt();
                if (arr[i][j] == 9) starts.add(new Point(i, j, -1));
            }
        }
    }

    static void pro(){
        Queue<Point> queue = new LinkedList<>();
        while(!starts.isEmpty()){
            Point cur = starts.poll();
            int start_x = cur.x;
            int start_y = cur.y;
            for (int i=0; i<4; i++){
                int nx = start_x + dx[i];
                int ny = start_y + dy[i];
                if (nx<0 || ny<0 || nx>=n || ny>=m) continue;
                if (visited[nx][ny][i]) continue;
                //방문 처리
                visited[nx][ny][i] = true;
                queue.add(new Point(nx, ny, i));
                checked[nx][ny] = true;
            }
            //에어컨 위치도 바람이 지나간 것을 check
            checked[start_x][start_y] = true;
        }

        //BFS
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int dir = cur.dir;
            //물건에 의해 바람의 방향이 변하는지 체크
            dir = changeDir(arr[x][y], dir);
            //다음 위치 계산
            int nx = x+dx[dir];
            int ny = y+dy[dir];

            if (nx<0 || ny<0 || nx>=n || ny>=m) continue;
            if (visited[nx][ny][dir]) continue;
            //방문 처리
            visited[nx][ny][dir] = true;
            queue.add(new Point(nx, ny, dir));
            checked[nx][ny] = true;
        }

        int answer = 0;
        for (int i=0; i<n; i++){
            for (int j= 0; j<m; j++){
                if (checked[i][j]) answer++;
            }
        }
        System.out.println(answer);
    }

    public static int changeDir(int type, int dir){
        if (type==1){
            if (dir==2) return 3;
            if (dir==3) return 2;
        }
        else if (type==2){
            if (dir==0) return 1;
            if (dir==1) return 0;
        }
        else if (type==3){
            if (dir==0) return 3;
            if (dir==1) return 2;
            if (dir==2) return 1;
            if (dir==3) return 0;
        }
        else if (type==4){
            if (dir==0) return 2;
            if (dir==1) return 3;
            if (dir==2) return 0;
            if (dir==3) return 1;
        }
        return dir;
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
