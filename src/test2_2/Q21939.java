package test2_2;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Q21939 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static TreeSet<Problem> tree;
    static HashMap<Integer, Integer> problems;
    static int n, m;
    static class Problem implements Comparable<Problem>{
        public int id;
        public int level;

        public Problem(int id, int level){
            this.id = id;
            this.level = level;
        }


        @Override
        public int compareTo(Problem o) {
            //난이도가 낮은 것이 우선
            if (this.level!=o.level) return this.level - o.level;
            return this.id - o.id;
        }
    }

    static void input(){
        tree = new TreeSet<>();
        problems = new HashMap<>();
        n = in.nextInt();
        for (int i=0; i<n; i++){
            int id = in.nextInt();
            int level = in.nextInt();
            tree.add(new Problem(id, level));
            problems.put(id, level);
        }
        m = in.nextInt();
    }

    static void pro(){
        String command = in.next();
        if (command.equals("add")){
            int id = in.nextInt();
            int level = in.nextInt();
            tree.add(new Problem(id, level));
            problems.put(id, level);
        }
        else if(command.equals("recommend")){
            int x = in.nextInt();
            if (x==-1){
                sb.append(tree.first().id).append('\n');
            }
            else {
                sb.append(tree.last().id).append('\n');
            }
        }
        else {
            int id = in.nextInt();
            int level = problems.get(id);
            tree.remove(new Problem(id, level));
            problems.remove(id);
        }
    }

    public static void main(String[] args) {
        input();
        for (int i=0; i<m; i++){
            pro();
        }
        System.out.println(sb);
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
