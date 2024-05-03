import java.util.ArrayList;

public class Stack<T> {
    T value;
    private int maxSize;
    private ArrayList<T> stackArray;
    private int top;


    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new ArrayList<T>(size);
        top = -1;
    }

    public void push(T data) {
        if (isFull()) {
            throw new RuntimeException("Stack is already full");
        }
        top++;
        if (stackArray.size() > top)
            stackArray.set(top, data);
        else
            stackArray.add(data);

    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is already empty");
        }
        T data = stackArray.get(top);
        top--;
        return data;
    }

    public T peek() {
        return stackArray.get(top);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == (maxSize - 1);
    }

    public static void main(String[] args) {

        Stack<Object> myStack = new Stack<>(3);
        myStack.push(10);
        myStack.push(20.0);
        myStack.push("1000");
        myStack.push("Gaurav");

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

    }
}
