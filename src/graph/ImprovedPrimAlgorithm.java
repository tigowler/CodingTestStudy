package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ImprovedPrimAlgorithm {

    public ArrayList<Path> improvedPrimFunc(HashMap<String, HashMap<String, Integer>> graph, String startNode){
        ArrayList<Path> mst = new ArrayList<>();
        PriorityQueue<ImprovedPrimEdge> keys = new PriorityQueue<>();
        HashMap<String, String> mstPath = new HashMap<>();
        HashMap<String, ImprovedPrimEdge> keysObjects = new HashMap<>();
        HashMap<String, Integer> linkedEdges;
        ImprovedPrimEdge edgeObject, poppedEdge, linkedEdge;
        Integer totalWeight = 0;

        //초기화
        for (String key: graph.keySet()){
            if (key == startNode){
                edgeObject = new ImprovedPrimEdge(key, 0);
                mstPath.put(key, key);
            } else {
                edgeObject = new ImprovedPrimEdge(key, Integer.MAX_VALUE);
                mstPath.put(key, null);
            }
            keys.add(edgeObject);
            keysObjects.put(key, edgeObject);
        }

        while(keys.size()>0){
            poppedEdge = keys.poll();
            keysObjects.remove(poppedEdge.node);

            mst.add(new Path(mstPath.get(poppedEdge.node), poppedEdge.node, poppedEdge.weight));
            totalWeight += poppedEdge.weight;

            linkedEdges = graph.get(poppedEdge.node); //인접 간선 정보
            for (String adjacent: linkedEdges.keySet()){
                if (keysObjects.containsKey(adjacent)){
                    linkedEdge = keysObjects.get(adjacent);

                    if (linkedEdges.get(adjacent) < linkedEdge.weight){
                        linkedEdge.weight = linkedEdges.get(adjacent);
                        mstPath.put(adjacent, poppedEdge.node);

                        keys.remove(linkedEdge);
                        keys.add(linkedEdge);
                    }
                }
            }
        }
        System.out.println(totalWeight);
        return mst;
    }

    public void test(){
        HashMap<String, HashMap<String, Integer>> mygraph = new HashMap<>();
        HashMap<String, Integer> edges;
        edges = new HashMap<String, Integer>();
        edges.put("B", 7);
        edges.put("D", 5);
        mygraph.put("A", edges);

        edges = new HashMap<String, Integer>();
        edges.put("A", 7);
        edges.put("D", 9);
        edges.put("C", 8);
        edges.put("E", 7);
        mygraph.put("B", edges);

        edges = new HashMap<String, Integer>();
        edges.put("B", 8);
        edges.put("E", 5);
        mygraph.put("C", edges);

        edges = new HashMap<String, Integer>();
        edges.put("A", 5);
        edges.put("B", 9);
        edges.put("E", 7);
        edges.put("F", 6);
        mygraph.put("D", edges);

        edges = new HashMap<String, Integer>();
        edges.put("B", 7);
        edges.put("C", 5);
        edges.put("D", 7);
        edges.put("F", 8);
        edges.put("G", 9);
        mygraph.put("E", edges);

        edges = new HashMap<String, Integer>();
        edges.put("D", 6);
        edges.put("E", 8);
        edges.put("G", 11);
        mygraph.put("F", edges);

        edges = new HashMap<String, Integer>();
        edges.put("E", 9);
        edges.put("F", 11);
        mygraph.put("G", edges);

        ArrayList<Path> list = this.improvedPrimFunc(mygraph, "A");
        System.out.println(list);

    }
}
