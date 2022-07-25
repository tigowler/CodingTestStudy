package Doit.DataStructure_03;

import java.io.*;
import java.util.StringTokenizer;

public class P11660 {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int N = in.nextInt();
        int C = in.nextInt();
        int[][] A = new int[N+1][N+1];
        for (int i=1; i<=N; i++){
            for (int j=1; j<=N; j++){
                A[i][j] = in.nextInt();
            }
        }

        int[][] S = new int[N+1][N+1];
        for (int i=1; i<=N; i++){
            for (int j=1; j<=N; j++){
                S[i][j] = S[i][j-1] + S[i-1][j] - S[i-1][j-1] + A[i][j];
            }
        }

        for (int i=0; i<C; i++){
            int x1 = in.nextInt(), y1=in.nextInt(), x2=in.nextInt(), y2=in.nextInt();
            System.out.println(S[x2][y2]-S[x1-1][y2]-S[x2][y1-1]+S[x1-1][y1-1]);
        }
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }

        double nextDouble(){
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            } catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
