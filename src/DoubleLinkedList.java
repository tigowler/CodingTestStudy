public class DoubleLinkedList<T> {
    public Node<T> head = null;
    public Node<T> tail = null;

    public class Node<T>{
        T data;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T data){
            this.data = data;
        }
    }

    public void addNode(T data){
        if(this.head == null){
            //노드가 하나도 존재하지 않을 경우
            this.head = new Node<T>(data);
            this.tail=this.head;
        } else {
            Node<T> node = this.head;
            //마지막 노드까지 이동
            while(node.next!=null){
                node = node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public void printAll(){
        if(this.head!=null){
            Node<T> node = this.head;
            System.out.println(node.data);
            while(node.next!=null){
                node=node.next;
                System.out.println(node.data);
            }
        }
    }

    public T searchFromHead(T isData){
        if(this.head==null){
            return null;
        } else {
            Node<T> node = this.head;
            while(node!=null){
                if(node.data==isData){
                    return node.data;
                } else {
                    node = node.next;
                }
            }
            return null;
        }
    }

    public T searchFromTail(T isData){
        if(this.head == null){
            return null;
        } else {
            Node<T> node = this.tail;
            while(node!= null){
                if(node.data==isData){
                    return node.data;
                } else {
                    node = node.prev;
                }
            }
            return null;
        }
    }

    public boolean insertToFront(T existedData, T addData){
        if(this.head == null){ //노드가 하나도 없을 경우
            this.head = new Node<T>(addData);
            this.tail = this.head;
            return true;
        }
        //가장 첫 노드가 찾는 노드일 경우
        else if(this.head.data==existedData){
            Node<T> newHead = new Node<T>(addData);
            newHead.next = this.head;
            this.head=newHead;
            this.head.next.prev = this.head;
            return true;
        } else {
            Node<T> node = this.head;
            while(node!=null){
                if(node.data == existedData){
                    Node<T> nodePrev = node.prev;

                    nodePrev.next = new Node<T>(addData);
                    nodePrev.next.next = node;

                    nodePrev.next.prev = nodePrev;
                    node.prev = nodePrev.next;
                    return true;
                } else {
                    node = node.next;
                }
            }
            return false;
        }
    }

    public void test(DoubleLinkedList<Integer> list){
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.printAll();
        System.out.println("----------------");

        list.insertToFront(3, 2);
        list.printAll();
        System.out.println("----------------");

        list.insertToFront(6, 2);
        list.insertToFront(1, 0);
        list.printAll();
        System.out.println("----------------");

        list.addNode(6);
        list.printAll();
    }

}
