package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        if (dataList.size()<=1){
            return dataList;
        }
        int pivot = dataList.get(0);

        ArrayList<Integer> leftArr = new ArrayList<Integer>();
        ArrayList<Integer> rightArr = new ArrayList<Integer>();

        for (int index=1; index < dataList.size(); index++){
            if (dataList.get(index)>pivot){
                rightArr.add(dataList.get(index));
            } else {
                leftArr.add(dataList.get(index));
            }
        }

        ArrayList<Integer> mergedArr = new ArrayList<Integer>();
        mergedArr.addAll(sort(leftArr));
        mergedArr.addAll(List.of(pivot));
        mergedArr.addAll(sort(rightArr));

        return mergedArr;
    }

    public void test(ArrayList<Integer> testData){
        System.out.println(this.sort(testData));
    }
}
