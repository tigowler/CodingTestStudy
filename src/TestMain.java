import dataStructure.BinaryTree;
import sort.BubbleSort;

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

        bubbleSortTest();
    }

    public static void bubbleSortTest(){
        ArrayList<Integer> testData = new ArrayList<Integer>();
        for (int i=0; i<100; i++){
            testData.add((int)(Math.random()*100));
        }
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(bubbleSort.sort(testData));
    }
}
