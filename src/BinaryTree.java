//시간복잡도
//1) O(h) : h=트리의 높이
//2) n개의 노드를 가진다면 O(logn), 트리가 균형잡혀 있을 때의 평균 시간복잡도
//3) 노드가 한 쪽에 치우쳐 있는 최악의 경우 O(n)
public class BinaryTree {
    Node head = null;

    public class Node{
        Node left;
        Node right;
        int value;
        Node(int data){
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    public boolean insertNode(int data){
        //1) 노드가 하나도 없는 경우
        if(this.head==null){
            this.head = new Node(data);
        }
        //2) 노드가 하나 이상 존재하는 경우
        else {
            Node findNode = this.head;
            while(true){
                //2-1) data가 현재 노드 값보다 작은 경우
                if(data<findNode.value){
                    // left가 null이면 data 노드 추가, null이 아니면 왼쪽으로 이동
                    if(findNode.left!=null){
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }
                }
                //2-2) data가 현재 노드 값보다 큰 경우
                else {
                    //right가 null이면 data 노드 추가, null이 아니면 오른쪽으로 이동
                    if(findNode.right!=null){
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;
    }

    public Node search(int data){
        //1) 노드가 하나도 없는 경우 null return
        if(head==null){
            return null;
        }
        //2) 노드가 하나 이상 존재하는 경우
        else {
            Node findNode = this.head;
            while(findNode!=null){
                //2-1) 현재 노드 value가 data와 같은 경우
                if(findNode.value==data){
                    return findNode;
                }
                //2-2) 현재 노드 value가 data보다 작은 경우 왼쪽으로 이동
                else if (data<findNode.value){
                    findNode = findNode.left;
                }
                //2-3) 현재 노드 value가 data보다 큰 경우 오른쪽으로 이동
                else {
                    findNode = findNode.right;
                }
            }
            //data를 찾지 못하고 노드의 최하단까지 온 경우
            return null;
        }
    }

    public boolean delete(int value){
        boolean searched = false;
        Node currParentNode = this.head; //삭제할 노드의 parent node
        Node currNode = this.head; //삭제할 노드

        //1) 노드가 하나도 존재하지 않는 경우
        if(this.head == null){
            return false;
        }
        //2) 노드가 하나 이상 존재하는 경우
        else {
            //2-1) 노드가 단 하나 존재하고 그 루트 노드가 삭제할 value일 경우
            if(this.head.value == value&&this.head.left == null && this.head.right==null){
                this.head = null;
                return true;
            }
            //2-2) 노드가 두 개 이상 존재하고 루트 노드가 삭제할 value가 아닌 경우
            while(currNode!=null){
                //2-2-1) 현재 노드의 value가 삭제할 value와 동일한 경우
                if(currNode.value ==value){
                    searched = true;
                    break;
                }
                //2-2-2) 삭제할 value가 현재 노드의 value보다 작은 경우
                else if(value<currNode.value){
                    currParentNode = currNode;
                    currNode = currNode.left;
                }
                //2-2-3) 삭제할 value가 현재 노드의 value보다 큰 경우
                else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }

            //삭제할 value를 마지막까지 찾지 못한 경우
            if(searched == false){
                return false;
            }

        }

        //삭제할 value를 찾은 경우
        //현재 currNode는 삭제할 value에 해당하는 노드
        //currParentNode는 삭제할 노드(currNode)의 부모 노드
        //1) 삭제할 노드의 자식이 하나도 없는 경우
        if(currNode.left == null && currNode.right==null){
            //1-1) 삭제할 value가 부모 노드의 value보다 작은 경우 == 부모 노드 왼쪽에 삭제할 노드가 있는 경우
            if(value < currParentNode.value){
                currParentNode.left = null;
                currNode = null;
            }
            //1-2) 삭제한 value가 부모 노드의 value보다 큰 경우 == 부모 노드 오른쪽에 삭제할 노드가 있는 경우
            else {
                currParentNode.right = null;
                currNode = null;
            }
            return true;
        }
        //2) 삭제할 노드의 왼쪽에만 자식이 있는 경우
        else if(currNode.left!=null && currNode.right==null){
            //2-1) 삭제할 value가 부모 노드의 value보다 작은 경우 == 부모 노드 왼쪽에 삭제할 노드가 있는 경우
            if(value< currParentNode.value){
                currParentNode.left = currNode.left;
                currNode = null;
            }
            //2-2) 삭제한 value가 부모 노드의 value보다 큰 경우 == 부모 노드 오른쪽에 삭제할 노드가 있는 경우
            else {
                currParentNode.right = currNode.left;
                currNode = null;
            }
            return true;
        }
        //3) 삭제할 노드의 오른쪽에만 자식이 있는 경우
        else if(currNode.left == null && currNode.right!=null){
            //3-1) 삭제할 value가 부모 노드의 value보다 작은 경우 == 부모 노드 왼쪽에 삭제할 노드가 있는 경우
            if(value < currParentNode.value){
                currParentNode.left = currNode.right;
                currNode = null;
            }
            //3-2) 삭제한 value가 부모 노드의 value보다 큰 경우 == 부모 노드 오른쪽에 삭제할 노드가 있는 경우
            else {
                currParentNode.right = currNode.right;
                currNode = null;
            }
            return true;
        }
        //4) 삭제할 노드의 양쪽에 모두 자식이 있는 경우
        else {
            //4-1) 삭제할 value가 부모 노드의 value보다 작은 경우 == 부모 노드 왼쪽에 삭제할 노드가 있는 경우
            if(value < currParentNode.value){
                //⭐삭제할 노드의 오른쪽 자식 중 가장 작은 값을 가진 노드 찾기
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while(currNode.left!=null){
                    changeParentNode = currNode;
                    changeNode = currNode.left;
                }

                //changeNode는 삭제할 노드의 오른쪽 자식 중 가장 작은 값을 가진 노드
                //changeParentNode는 changeNode의 부모 노드
                //4-1-1) 삭제할 노드의 오른쪽 자식 중 가장 작은 값을 가진 노드의 오른쪽 자식이 있는 경우
                if(changeNode.right!=null){
                    changeParentNode.left = changeNode.right;
                }
                //4-1-2) 삭제할 노드의 오른쪽 자식 중 가장 작은 값을 가진 노드에 자식이 없는 경우
                else {
                    changeParentNode.left = null;
                }
                currParentNode.left = changeNode;
                changeNode.right = currNode.right;
                changeNode.left = currNode.left;

                currNode = null;
            }
            //4-2) 삭제할 value가 부모 노드의 value보다 작은 경우 == 부모 노드 오른쪽에 삭제할 노드가 있는 경우
            else {
                //⭐삭제할 노드의 오른쪽 자식 중 가장 작은 값을 가진 노드 찾기
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while(changeNode.left!=null){
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }

                //changeNode는 삭제할 노드의 오른쪽 자식 중 가장 작은 값을 가진 노드
                //changeParentNode는 changeNode의 부모 노드
                //4-2-1) 삭제할 노드의 오른쪽 자식 중 가장 작은 값을 가진 노드의 오른쪽 자식이 있는 경우
                if(changeNode.right!=null){
                    changeParentNode.left = changeNode.right;
                }
                //4-2-2) 삭제할 노드의 오른쪽 자식 중 가장 작은 값을 가진 노드에 자식이 없는 경우
                else {
                    changeParentNode.left = null;
                }

                currParentNode.right = changeNode;

                if(currNode.right!=changeNode){
                    changeNode.right = currNode.right;
                }
                changeNode.left = currNode.left;
                currNode = null;
            }
            return true;
        }


    }

    public void test(BinaryTree tree){
        tree.insertNode(10);
        tree.insertNode(15);
        tree.insertNode(13);
        tree.insertNode(11);
        tree.insertNode(14);
        tree.insertNode(18);
        tree.insertNode(16);
        tree.insertNode(19);
        tree.insertNode(17);
        tree.insertNode(7);
        tree.insertNode(8);
        tree.insertNode(6);
        System.out.println(tree.delete(15));
        System.out.println("HEAD: " + tree.head.value);
        System.out.println("HEAD LEFT: " + tree.head.left.value);
        System.out.println("HEAD LEFT LEFT: " + tree.head.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + tree.head.left.right.value);

        System.out.println("HEAD RIGHT: " + tree.head.right.value);
        System.out.println("HEAD RIGHT LEFT: " + tree.head.right.left.value);
        System.out.println("HEAD RIGHT RIGHT: " + tree.head.right.right.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + tree.head.right.right.left.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + tree.head.right.right.right.value);
    }

}
