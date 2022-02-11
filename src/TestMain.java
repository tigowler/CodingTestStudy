import graph.KruskalAlgorithm;
import sort.QuickSort;

import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args) {
//        QuickSort quickSort = new QuickSort();
//        quickSort.test(createRandomArray());

        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm();
        kruskalAlgorithm.test();
    }


    public static ArrayList<Integer> createRandomArray(){
        ArrayList<Integer> testData = new ArrayList<Integer>();
        for (int i=0; i<100; i++){
            testData.add((int)(Math.random()*100));
        }
        return testData;
    }

}
