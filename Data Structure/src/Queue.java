import java.util.ArrayList;

public class Queue<T> {
    T value;
    private int maxSize;
    private ArrayList<T> queue;
    private int front,rear;


    public Queue() {
        this.queue = new ArrayList<T>();
        front = -1;
        rear=-1;
    }

    public void add(T data) {
        front=0;
        queue.add(data);
        rear++;
    }

    public T remove() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is already empty");
        }
        T data = queue.get(front);
        queue.remove(0);
        if(rear==0){
            front =-1;
            rear=-1;
        }
        return data;
    }

    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue.get(front);
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public static void main(String[] args) {

        Queue<Object> myQueue= new Queue<>();
        myQueue.add(10);
        myQueue.add(20.0);
        myQueue.add("1000");
        myQueue.add("Gaurav");

        System.out.println(myQueue.poll());
        System.out.println(myQueue.remove());
        System.out.println(myQueue.remove());
        System.out.println(myQueue.remove());
        System.out.println(myQueue.remove());
        System.out.println(myQueue.poll());


    }
}
