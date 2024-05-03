public class Node<T>{

    public T data;
    public Node<T> next;
    public Node<T> previous;

    public void displayNode(){
        System.out.println(" ["+data+"] ");
    }

}
