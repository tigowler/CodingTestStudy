package dataStructure;

public class SingleLinkedList<T> {
    public Node<T> head = null;

    private class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data){
            this.data = data;
        }
    }

    public void addNode(T data){
        if(head==null){
            //노드가 하나도 없을 경우 head로 만들기
            head = new Node<T>(data);
        } else {
            Node<T> node = this.head;
            //가장 마지막 노드까지 이동
            while(node.next!=null){
                node = node.next;
            }
            node.next = new Node<T>(data);
        }
    }

    public void printAll(){
        if(head!=null){
            Node<T> node = this.head;
            System.out.println(node.data);
            while(node.next!=null){
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public Node<T> search(T data){
        if(this.head==null){
            return null;
        } else {
            Node<T> node = this.head;
            while(node!=null){
                if(node.data==data){
                    return node;
                } else {
                    node = node.next;
                }
            }
            return null;
        }
    }

    public void addNodeInside(T data, T isData){
        Node<T> searchedNode = this.search(isData);

        if(searchedNode==null){
            //찾는 노드가 없을 경우 맨 뒤에 추가
            this.addNode(data);
        } else {
            Node<T> nextNode = searchedNode.next;
            searchedNode.next = new Node<T>(data);
            searchedNode.next.next = nextNode;
        }
    }

    public boolean delNode(T isData){
        if(this.head==null){
            return false;
        } else {
            Node<T> node = this.head;
            if(node.data == isData){
                this.head = this.head.next;
                return true;
            } else {
                while(node.next!=null){
                    if(node.next.data == isData){
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        }
    }

    public void test(SingleLinkedList<Integer> list){

        System.out.println("초기 설정");
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);

        list.printAll();

        System.out.println("중간 노드 삭제");
        list.delNode(3);
        list.printAll();

        System.out.println("head 노드 삭제");
        list.delNode(1);
        list.printAll();

        System.out.println("마지막 노드 삭제");
        list.delNode(5);
        list.printAll();

        System.out.println("존재하지 않는 노드 삭제");
        list.delNode(20);
    }
}
