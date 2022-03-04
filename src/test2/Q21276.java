package test2;

import java.io.*;
import java.util.*;

public class Q21276 {
    static FastReader in = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static String[] names;
    static HashMap<String, Integer> map_name;
    static ArrayList<Integer>[] con;
    static ArrayList<String>[] child;
    static ArrayList<String> roots;

    static void input(){
        n = in.nextInt();
        names = new String[n+1];
        map_name = new HashMap<>();
        con = new ArrayList[n+1];
        child = new ArrayList[n+1];
        for (int i=1; i<=n; i++){
            names[i] = in.next();
            map_name.put(names[i], i);

            con[i] = new ArrayList<>();
            child[i] = new ArrayList<>();
        }

        m = in.nextInt();
        for (int i=1; i<=m; i++){
            String x = in.next(), y = in.next();
            con[map_name.get(x)].add(map_name.get(y));
        }
    }

    static void pro(){
        roots = new ArrayList<>();
        for (int i=1; i<=n; i++){
            if (con[i].size()==0){
                roots.add(names[i]);
            }

            for (int j: con[i]){
                int depth_i = con[i].size();
                int depth_j = con[j].size();
                if (depth_i-1 == depth_j){
                    child[j].add(names[i]);
                }
            }
        }

        sb.append(roots.size()).append('\n');
        Collections.sort(roots);
        for (String root : roots) sb.append(root).append(' ');
        sb.append('\n');

        Arrays.sort(names, 1, n+1);
        for (int i=1; i<=n; i++){
            String name = names[i];
            int idx = map_name.get(name);
            sb.append(name).append(' ').append(child[idx].size());
            Collections.sort(child[idx]);
            for (String ch: child[idx]) sb.append(' ').append(ch);
            sb.append('\n');
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
