package graph;

import java.util.*;

public class KruskalAlgorithm {

    //노드의 parent node를 알기 위해 필요, root node의 parent node는 자기 자신을 가리키도록 함
    HashMap<String, String> parent = new HashMap<String, String>();
    //노드의 rank(높이)
    HashMap<String, Integer> rank = new HashMap<String, Integer>();

    public ArrayList<Edge> kruskalFunc(ArrayList<String> vertices, ArrayList<Edge> edges){
        ArrayList<Edge> mst = new ArrayList<Edge>();
        Edge currentEdge;

        // 1) 초기화
        for (int index=0; index < vertices.size(); index++){
            makeSet(vertices.get(index));
        }

        // 2) 간선 weight 기반 sorting
        Collections.sort(edges);

        // 3) weight가 작은 간선부터 연결
        for (int index=0; index<edges.size(); index++){
            currentEdge = edges.get(index); //현재 가장 weight가 작은 간선
            //Cycle이 없는 경우만 union으로 연결
            if (find(currentEdge.nodeV)!=find(currentEdge.nodeU)){
                union(currentEdge.nodeV, currentEdge.nodeU);
                mst.add(currentEdge);
            }
        }

        return mst;
    }

    //Union find를 위한 초기화
    public void makeSet(String node){
        parent.put(node, node);
        rank.put(node, 0);
    }

    //루트 노드를 확인 -> 두 노드가 같은 그래프에 속하는지 확인하기 위함
    public String find(String node){
        //path compression 기법
        if(parent.get(node)!=node){
            parent.put(node, find(parent.get(node)));
        }
        return parent.get(node);
    }

    //두 개의 노드 간에 간선을 연결
    //nodeV, nodeU 연결 시 Cycle이 생기지 않을 때만 본 메소드를 호출한다고 가정
    public void union(String nodeV, String nodeU){
        String root1 = find(nodeV);
        String root2 = find(nodeU);

        //union-by-rank
        // 1) root1의 rank가 더 높을 경우
        if(rank.get(root1)>rank.get(root2)){
            parent.put(root2, root1);
        }
        // 2) root2의 rank가 더 높을 경우 + 두 rank가 같을 경우
        else {
            parent.put(root1, root2);
            // 2-1) 두 rank가 같으면 한 쪽의 rank를 하나 증가
            if(Objects.equals(rank.get(root1), rank.get(root2))){
                rank.put(root2, rank.get(root2)+1);
            }
        }
    }


    public void test(){
        ArrayList<String> vertices =  new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<Edge> edges = new ArrayList<Edge>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(7, "B", "A"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(8, "C", "B"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(5, "D", "A"));
        edges.add(new Edge(9, "D", "B"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(7, "E", "B"));
        edges.add(new Edge(5, "E", "C"));
        edges.add(new Edge(7, "E", "D"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(6, "F", "D"));
        edges.add(new Edge(8, "F", "E"));
        edges.add(new Edge(11, "F", "G"));
        edges.add(new Edge(9, "G", "E"));
        edges.add(new Edge(11, "G", "F"));

        ArrayList<Edge> list = this.kruskalFunc(vertices, edges);
        System.out.println(list);
    }
}
