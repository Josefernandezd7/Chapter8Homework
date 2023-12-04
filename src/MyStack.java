import java.util.LinkedList;
import java.util.EmptyStackException;

public class MyStack<E> {
    private LinkedList<E> backingList;


    public MyStack() {
        backingList = new LinkedList<>();
    }

    public void push(E e) {
        backingList.addFirst(e);
    }
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return backingList.removeFirst();
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return backingList.getFirst();
    }


    public boolean isEmpty() {
        return backingList.isEmpty();
    }
    public int size() {
        return backingList.size();
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);


        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());

        System.out.println("Peek: " + stack.peek());


        System.out.println("Is Empty: " + stack.isEmpty());
        System.out.println("Size: " + stack.size()); //
       }
}
