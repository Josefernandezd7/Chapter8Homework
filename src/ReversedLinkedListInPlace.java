import java.util.LinkedList;
import java.util.ListIterator;

public class ReversedLinkedListInPlace {
    public static <E> void reverseLinkedListInPlace(LinkedList<E> list) {
           if (list == null || list.size() < 2) {
            return;
            }

        ListIterator<E> forwardIterator = list.listIterator();
        ListIterator<E> backwardIterator = list.listIterator(list.size());

           while (forwardIterator.nextIndex() < backwardIterator.previousIndex()) {

            E forwardElement = forwardIterator.next();
            E backwardElement = backwardIterator.previous();

            forwardIterator.set(backwardElement);
            backwardIterator.set(forwardElement);
           }
    }

       public static void main(String[] args) {
        LinkedList<Integer> integerList = new LinkedList<>();
        integerList.add(1);
         integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);

        System.out.println("Original List: " + integerList);
        reverseLinkedListInPlace(integerList);
        System.out.println("Reversed List In Place: " + integerList);

        LinkedList<String> stringList = new LinkedList<>();
        stringList.add("apple");
         stringList.add("banana");
        stringList.add("orange");
        stringList.add("grape");

        System.out.println("\nOriginal List: " + stringList);
         reverseLinkedListInPlace(stringList);
        System.out.println("Reversed List In Place: " + stringList);
    }
}

