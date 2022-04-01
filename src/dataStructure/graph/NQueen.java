package dataStructure.graph;

import java.util.ArrayList;
import java.util.Objects;

public class NQueen {

    public boolean isAvailable(ArrayList<Integer> candidate, Integer currentCol){
        Integer currentRow = candidate.size();
        for (int i=0; i<currentRow; i++){
            if ((Objects.equals(candidate.get(i), currentCol)) || (Math.abs(candidate.get(i)-currentCol) == currentRow-i)){
                return false;
            }
        }
        return true;
    }

    public void dfsFunc(Integer N, Integer currentRow, ArrayList<Integer> currentCandidate){
        if (Objects.equals(currentRow, N)){
            System.out.println(currentCandidate);
            return ;
        }

        for (int i=0; i<N; i++){
            if (this.isAvailable(currentCandidate, i)){
                currentCandidate.add(i);
                this.dfsFunc(N, currentRow+1, currentCandidate);
                currentCandidate.remove(currentCandidate.size()-1);
            }
        }
    }

    public void test(){
        this.dfsFunc(4, 0, new ArrayList<Integer>());
    }
}
