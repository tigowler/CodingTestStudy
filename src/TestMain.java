import dataStructure.BinaryTree;
import sort.BubbleSort;
import sort.InsertionSort;
import sort.SelectionSort;

import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args) {
//        dataStructure.SingleLinkedList<Integer> MyLinkedList = new dataStructure.SingleLinkedList<Integer>();
//        MyLinkedList.test(MyLinkedList);

//        dataStructure.DoubleLinkedList<Integer> dll = new dataStructure.DoubleLinkedList<>();
//        dll.test(dll);

//        dataStructure.HashTableWithChaining htc = new dataStructure.HashTableWithChaining(20);
//        htc.test(htc);

//        dataStructure.HashTableWithLinearProbing htlp = new dataStructure.HashTableWithLinearProbing(20);
//        htlp.test(htlp);

//        BinaryTree tree = new BinaryTree();
//        tree.test(tree);

//        bubbleSortTest();
//        selectionSortTest();
        insertionSortTest();
    }


    public static ArrayList<Integer> createRandomArray(){
        ArrayList<Integer> testData = new ArrayList<Integer>();
        for (int i=0; i<100; i++){
            testData.add((int)(Math.random()*100));
        }
        return testData;
    }

    public static void bubbleSortTest(){
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(bubbleSort.sort(createRandomArray()));
    }

    public static void selectionSortTest(){
        SelectionSort selectionSort = new SelectionSort();
        System.out.println(selectionSort.sort(createRandomArray()));
    }

    public static void insertionSortTest(){
        InsertionSort insertionSort = new InsertionSort();
        System.out.println(InsertionSort.sort(createRandomArray()));
    }
}
