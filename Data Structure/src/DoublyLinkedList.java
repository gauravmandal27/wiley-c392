
public class DoublyLinkedList<T>{

    private Node<T> first;
    private Node<T> last;

    public DoublyLinkedList(){
        first=null;
        last=null;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public void insertFirst(T data){
        Node<T> newNode= new Node<T>();
        newNode.data =  data;
        if (isEmpty()){
            first=newNode;
            last=newNode;
        }
        else {
            newNode.next = first;
            first.previous=newNode;
            first = newNode;
        }
    }


    public void insertLast(T data){

        Node<T> newNode = new Node<T>();
        newNode.data = data;
        if(isEmpty()){
            first=newNode;
            last=newNode;
        }
        else {
            last.next=newNode;
            newNode.previous=last;
            last=newNode;
        }


    }

    public Node<T> removeFirst(){
        Node<T> temp = first;
        if (first.next==null){
            last=null;
        }
        first=first.next;
        return temp;
    }

    public Node<T> removeLast(){
        Node<T> temp = last;
        if (last.previous==null){
            last=null;
        }
        else
            last=last.previous;
        return temp;
    }


    public void displayList(){
        Node<T> current = first;
        do {
            current.displayNode();
            current=current.next;
        }while (current!=null);
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Object> doubleList = new DoublyLinkedList<>();
        doubleList.insertLast(10);
        doubleList.insertFirst("gaurav");
        doubleList.displayList();
        doubleList.removeLast();
        doubleList.displayList();
        doubleList.removeFirst();
        doubleList.displayList();
    }
}
