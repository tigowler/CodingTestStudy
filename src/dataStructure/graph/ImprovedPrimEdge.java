package dataStructure.graph;

public class ImprovedPrimEdge implements Comparable<ImprovedPrimEdge>{
    public String node;
    public int weight;

    public ImprovedPrimEdge(String node, int weight){
        this.weight = weight;
        this.node = node;
    }

    public String toString(){
        return "(" + this.weight + "," + this.node + ")";
    }

    @Override
    public int compareTo(ImprovedPrimEdge improvedPrimEdge){
        return this.weight - improvedPrimEdge.weight;
    }
}
