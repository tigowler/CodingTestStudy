import dataStructure.BinaryTree;
import sort.BubbleSort;
import sort.InsertionSort;
import sort.MergeSort;
import sort.SelectionSort;

import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args) {

    }


    public static ArrayList<Integer> createRandomArray(){
        ArrayList<Integer> testData = new ArrayList<Integer>();
        for (int i=0; i<100; i++){
            testData.add((int)(Math.random()*100));
        }
        return testData;
    }

}
