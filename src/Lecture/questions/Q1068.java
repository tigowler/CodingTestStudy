package Lecture.questions;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1068 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int n, root, erased;
    static ArrayList<Integer>[] child;
    //leaf[x] := x를 root로 하는 subtree에 있는 단말 노드의 개수
    //x가 단말 노드인 경우 => leaf[x] = 1
    //아닌 경우 => x의 자식들에 대해 leaf를 먼저 계산한 후 leaf[x] = leaf[x의 자식 노드들]의 합
    static int[] leaf;

    static void input(){
        n = in.nextInt();
        child = new ArrayList[n];
        leaf = new int[n];
        for (int i=0; i<n; i++) child[i] = new ArrayList<>();
        for (int i=0; i<n; i++){
            int par = in.nextInt();
            if (par == -1){
                root = i;
                continue;
            }
            child[par].add(i);
        }
        erased = in.nextInt();
    }

    static void dfs(int x){
        if (child[x].isEmpty()){
            leaf[x] = 1;
        }
        for (int y:  child[x]){
            dfs(y);
            //leaf[y]가 계산된 상태로 돌아옴
            leaf[x] += leaf[y];
        }
    }

    static void pro(){
        for (int i=0; i<n; i++){
            if (child[i].contains(erased)){
                child[i].remove(child[i].indexOf(erased));
            }
        }
        if (root!=erased) dfs(root);
        System.out.println(leaf[root]);
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
