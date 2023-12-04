import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyQueue<E> {
    private LinkedList<E> backingList;
    public MyQueue() {
        backingList = new LinkedList<>();
        }


    public void add(E e) {
        backingList.addLast(e);
    }


    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return backingList.removeFirst();
    }


    public E peekHead() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return backingList.getFirst();
      }


    public E peekTail() {
        if (isEmpty()) {
            throw new NoSuchElementException();
            }
        return backingList.getLast();
    }

    public boolean isEmpty() {
        return backingList.isEmpty();
    }

    public int size() {
        return backingList.size();
    }
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();


        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Remove: " + queue.remove());
        System.out.println("Remove: " + queue.remove());
        System.out.println("Peek Head: " + queue.peekHead());
        System.out.println("Peek Tail: " + queue.peekTail());

        // Check if the queue is empty
        System.out.println("Is Empty: " + queue.isEmpty());


        System.out.println("Size: " + queue.size());
    }
}

