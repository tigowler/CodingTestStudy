package Lecture.sort;

import java.util.ArrayList;

public class MergeSort {
    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList){
        ArrayList<Integer> mergedList = new ArrayList<Integer>();
        Integer leftPoint = 0;
        Integer rightPoint = 0;

        // 1) left/right 둘 다 존재할 때
        while(leftList.size()>leftPoint && rightList.size()>rightPoint){
            if(leftList.get(leftPoint)>rightList.get(rightPoint)){
                mergedList.add(rightList.get(rightPoint));
                rightPoint+=1;
            } else {
                mergedList.add(leftList.get(leftPoint));
                leftPoint += 1;
            }
        }

        // 2) left 데이터만 있을 때
        while(leftList.size()>leftPoint){
            mergedList.add(leftList.get(leftPoint));
            leftPoint+=1;
        }

        // 3) right 데이터만 있을 때
        while(rightList.size()>rightPoint){
            mergedList.add(rightList.get(rightPoint));
            rightPoint+=1;
        }

        return mergedList;
    }

    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList){
        if (dataList.size()<=1){
            return dataList;
        }
        int medium = dataList.size()/2;

        ArrayList<Integer> leftArr = this.mergeSplitFunc(new ArrayList<Integer>(dataList.subList(0, medium)));
        ArrayList<Integer> rightArr = this.mergeSplitFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())));

        return this.mergeFunc(leftArr, rightArr);
    }
}
