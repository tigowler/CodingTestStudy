package dataStructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimAlgorithm {

    public ArrayList<Edge> primFunc(String startNode, ArrayList<Edge> edges){
        Edge currentEdge, poppedEdge, adjacentEdgeNode;
        ArrayList<Edge> currentEdgeList, candidateEdgeList, adjacentEdgeNodes;
        PriorityQueue<Edge> priorityQueue;

        ArrayList<String> connectedNodes = new ArrayList<>();
        ArrayList<Edge> mst = new ArrayList<>();
        HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<>();

        //초기화
        for (int i = 0; i<edges.size(); i++){
            currentEdge = edges.get(i);
            if (!adjacentEdges.containsKey(currentEdge.nodeV)){
                adjacentEdges.put(currentEdge.nodeV, new ArrayList<Edge>());
            }
            if (!adjacentEdges.containsKey(currentEdge.nodeU)){
                adjacentEdges.put(currentEdge.nodeU, new ArrayList<Edge>());
            }
        }

        for (int i=0; i<edges.size(); i++){
            currentEdge = edges.get(i);
            currentEdgeList = adjacentEdges.get(currentEdge.nodeV);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.nodeV, currentEdge.nodeU));
            currentEdgeList = adjacentEdges.get(currentEdge.nodeU);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.nodeU, currentEdge.nodeV));
        }

        connectedNodes.add(startNode);
        candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<Edge>());
        priorityQueue = new PriorityQueue<Edge>();

        for (int i = 0; i<candidateEdgeList.size(); i++){
            priorityQueue.add(candidateEdgeList.get(i));
        }

        while (priorityQueue.size()>0){
            poppedEdge = priorityQueue.poll();
            if (!connectedNodes.contains(poppedEdge.nodeU)){
                //해당 edge를 mst에 추가
                connectedNodes.add(poppedEdge.nodeU);
                mst.add(new Edge(poppedEdge.weight, poppedEdge.nodeV, poppedEdge.nodeU));

                adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.nodeU, new ArrayList<Edge>());
                for (int i=0; i< adjacentEdgeNodes.size(); i++){
                    adjacentEdgeNode = adjacentEdgeNodes.get(i);
                    if (!connectedNodes.contains(adjacentEdgeNode.nodeU)){
                        priorityQueue.add(adjacentEdgeNode);
                    }
                }
            }
        }

        return mst;
    }

    public void test(){
        ArrayList<Edge> myedges = new ArrayList<>();
        myedges.add(new Edge(7, "A", "B"));
        myedges.add(new Edge(5, "A", "D"));
        myedges.add(new Edge(8, "B", "C"));
        myedges.add(new Edge(9, "B", "D"));
        myedges.add(new Edge(7, "D", "E"));
        myedges.add(new Edge(5, "C", "E"));
        myedges.add(new Edge(7, "B", "E"));
        myedges.add(new Edge(6, "D", "F"));
        myedges.add(new Edge(8, "E", "F"));
        myedges.add(new Edge(9, "E", "G"));
        myedges.add(new Edge(11, "F", "G"));

        ArrayList<Edge> list = this.primFunc("A", myedges);
        System.out.println(list);
    }
}
