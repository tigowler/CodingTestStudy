package dataStructure;

import java.util.ArrayList;
import java.util.Collections;

//Max dataStructure.Heap
//parent node's index = child node's index / 2
//left child node's index = parent node's index * 2
//right child node's index = parent node's index * 2 + 1
public class Heap {
    public ArrayList<Integer> heapArray = null;

    public Heap(Integer data){
        this.heapArray = new ArrayList<Integer>();
        //root node index를 1로 하기 위해 0번 index에는 null을 넣음
        this.heapArray.add(null);
        this.heapArray.add(data);
    }

    public boolean move_up(Integer inserted_idx){
        if(inserted_idx<=1){
            return false;
        }
        Integer parent_idx = inserted_idx / 2;
        //새로 삽입한 데이터가 부모의 데이터보다 크면 true return
        if(this.heapArray.get(inserted_idx)>this.heapArray.get(parent_idx)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean insert(Integer data){
        Integer inserted_idx, parent_idx;
        //heapArray가 null일 경우
        if(this.heapArray == null){
            this.heapArray = new ArrayList<Integer>();
            this.heapArray.add(null);
            this.heapArray.add(data);
            return true;
        }

        this.heapArray.add(data);
        inserted_idx = this.heapArray.size()-1;

        while(this.move_up(inserted_idx)){
            parent_idx = inserted_idx/2;
            Collections.swap(heapArray, inserted_idx, parent_idx);
            inserted_idx = parent_idx;
        }
        return true;
    }

    public boolean move_down(Integer popped_idx){
        Integer left_child_popped_idx, right_child_popped_idx;

        left_child_popped_idx = popped_idx * 2;
        right_child_popped_idx = popped_idx * 2 + 1;

        //1) 왼쪽 자식 노드도 없을 때
        if(left_child_popped_idx >= this.heapArray.size()){
            return false;
        }
        //2) 오른쪽 자식 노드만 없을 때
        else if(right_child_popped_idx>=this.heapArray.size()){
            //2-1) 현재 노드 값이 왼쪽 자식 노드 값보다 작을 때 => 더 아래로 내려가야 함
            if(this.heapArray.get(popped_idx)<this.heapArray.get(left_child_popped_idx)){
                return true;
            }
            //2-2) 현재 노드 값이 왼쪽 자식 노드 값보다 클 때 => 더 아래로 갈 필요 없음
            else{
                return false;
            }
        }
        //3) 왼쪽 오른쪽 자식 노드가 모두 있을 때
        else {
            //3-1) 왼쪽 자식 노드 값이 오른쪽 자식 노드 값보다 클 때
            if (this.heapArray.get(left_child_popped_idx)>this.heapArray.get(right_child_popped_idx)){
                //3-1-1) 현재 노드 값이 왼쪽 자식 노드 값보다 작을 때
                if(this.heapArray.get(popped_idx)<this.heapArray.get(left_child_popped_idx)){
                    return true;
                }
                //3-1-2) 현재 노드 값이 왼쪽 자식 노드 값보다 클 때
                else{
                    return false;
                }
            }
            //3-2) 오른쪽 자식 노드 값이 왼쪽 자식 노드 값보다 클 때
            else{
                //3-2-1) 현재 노드 값이 오른쪽 자식 노드 값보다 작을 때
                if(this.heapArray.get(popped_idx)<this.heapArray.get(right_child_popped_idx)){
                    return true;
                }
                //3-2-2) 현재 노드 값이 오른쪽 자식 노드 값보다 클 때
                else {
                    return false;
                }
            }
        }
    }

    public Integer pop(){
        Integer return_data, popped_idx, left_child_popped_idx, right_child_popped_idx;

        //heapArray가 비어있을 경우
        if(this.heapArray.size()<=1){
            return null;
        }


        return_data=this.heapArray.get(1);
        //가장 뒤의 item을 맨 앞(위)으로 이동
        this.heapArray.set(1, this.heapArray.get(this.heapArray.size()-1));
        //가장 뒤의 item 없애기
        this.heapArray.remove(this.heapArray.size()-1);
        popped_idx=1;

        while(this.move_down(popped_idx)){
            left_child_popped_idx = popped_idx * 2;
            right_child_popped_idx = popped_idx * 2 + 1;

            if(right_child_popped_idx>=this.heapArray.size()){
                if(this.heapArray.get(popped_idx)<this.heapArray.get(left_child_popped_idx)){
                    Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);
                    popped_idx = left_child_popped_idx;
                }
            }
            else {
                if(this.heapArray.get(left_child_popped_idx)>this.heapArray.get(right_child_popped_idx)){
                    if (this.heapArray.get(popped_idx)<this.heapArray.get(left_child_popped_idx)){
                        Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);
                        popped_idx = left_child_popped_idx;
                    }
                }
                else {
                    if(this.heapArray.get(popped_idx)<this.heapArray.get(right_child_popped_idx)){
                        Collections.swap(this.heapArray, popped_idx, right_child_popped_idx);
                        popped_idx = right_child_popped_idx;
                    }
                }
            }
        }
        return return_data;
    }
}
