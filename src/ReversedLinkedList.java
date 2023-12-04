import java.util.LinkedList;
import java.util.ListIterator;

public class ReversedLinkedList {
    public static <E> LinkedList<E> reverseLinkedList(LinkedList<E> list) {
        LinkedList<E> reversedList = new LinkedList<>();


        ListIterator<E> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            reversedList.add(iterator.previous());
        }

        return reversedList;
    }

    public static void main(String[] args) {
        LinkedList<Integer> integerList = new LinkedList<>();
        integerList.add(1);
        integerList.add(2);
         integerList.add(3);
        integerList.add(4);
        integerList.add(5);

        System.out.println("Original List: " + integerList);
        LinkedList<Integer> reversedIntegerList = reverseLinkedList(integerList);
        System.out.println("Reversed List: " + reversedIntegerList);

        LinkedList<String> stringList = new LinkedList<>();
         stringList.add("apple");
        stringList.add("banana");
        stringList.add("orange");
        stringList.add("grape");

        System.out.println("\nOriginal List: " + stringList);
        LinkedList<String> reversedStringList = reverseLinkedList(stringList);
         System.out.println("Reversed List: " + reversedStringList);
       }
}

