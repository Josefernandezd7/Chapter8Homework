import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;

public class ListManipulation {
    public static <E> void add(List<E> list, int index, E element) {
        if (index < 0 || index > list.size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        ListIterator<E> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            int currentIndex = iterator.previousIndex();
            if (currentIndex == index) {
                iterator.add(element);
                return;
            }
            iterator.previous();
           }
        if (index == 0) {
            list.add(0, element);
        }
    }
    public static <E> E remove(List<E> list, int index) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        ListIterator<E> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            int currentIndex = iterator.previousIndex();
            if (currentIndex == index) {
                E removedElement = iterator.previous();
                iterator.remove();
                return removedElement;
            }
            iterator.previous();
        }

        return null;
    }

    public static <E> E get(List<E> list, int index) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        ListIterator<E> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            int currentIndex = iterator.previousIndex();
            if (currentIndex == index) {
                return iterator.previous();
            }
            iterator.previous();
        }

        return null;
    }


    public static <E> void set(List<E> list, int index, E element) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        ListIterator<E> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            int currentIndex = iterator.previousIndex();
            if (currentIndex == index) {
                iterator.previous();
                iterator.set(element);
                return;
            }
            iterator.previous();
        }
    }


    public static <E> int indexOf(List<E> list, E element) {
        ListIterator<E> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            int currentIndex = iterator.previousIndex();
            if (iterator.previous().equals(element)) {
                return currentIndex;
            }
        }

        return -1;
    }


    public static <E> int lastIndexOf(List<E> list, E element) {
        ListIterator<E> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            int currentIndex = iterator.previousIndex();
            if (iterator.previous().equals(element)) {
                return currentIndex;
            }
        }

        return -1;
    }


    public static <E> boolean remove(List<E> list, E element) {
        ListIterator<E> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            if (iterator.previous().equals(element)) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Test (a) add
        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("cherry");

        System.out.println("Original List: " + stringList);
        add(stringList, 1, "orange");
        System.out.println("After add: " + stringList);

        // Test (b) remove
        List<Integer> integerList = new LinkedList<>();
        integerList.add(10);
        integerList.add(20);
        integerList.add(30);

        System.out.println("\nOriginal List: " + integerList);
        int removedValue = remove(integerList, 1);
        System.out.println("Removed Element: " + removedValue);
        System.out.println("After remove: " + integerList);

        // Test (c) get
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.1);
        doubleList.add(2.2);
        doubleList.add(3.3);

        System.out.println("\nOriginal List: " + doubleList);
        double element = get(doubleList, 2);
        System.out.println("Element at index 2: " + element);

        // Test (d) set
        List<String> anotherStringList = new LinkedList<>();
        anotherStringList.add("one");
        anotherStringList.add("two");
        anotherStringList.add("three");

        System.out.println("\nOriginal List: " + anotherStringList);
        set(anotherStringList, 1, "four");
        System.out.println("After set: " + anotherStringList);

        // Test (e) indexOf
        List<Character> charList = new ArrayList<>();
        charList.add('a');
        charList.add('b');
        charList.add('c');

        System.out.println("\nOriginal List: " + charList);
        int indexOfB = indexOf(charList, 'b');
        System.out.println("Index of 'b': " + indexOfB);

        // Test (f) lastIndexOf
        List<String> repeatStringList = new ArrayList<>();
        repeatStringList.add("apple");
        repeatStringList.add("orange");
        repeatStringList.add("apple");
        repeatStringList.add("banana");

        System.out.println("\nOriginal List: " + repeatStringList);
        int lastIndexOfApple = lastIndexOf(repeatStringList, "apple");
        System.out.println("Last Index of 'apple': " + lastIndexOfApple);

        // Test (g) remove
        List<Integer> anotherIntegerList = new LinkedList<>();
        anotherIntegerList.add(5);
        anotherIntegerList.add(10);
        anotherIntegerList.add(15);

        System.out.println("\nOriginal List: " + anotherIntegerList);
        Integer removed = remove(anotherIntegerList, 10);
        System.out.println("Removed element: " + removed);
        System.out.println("After remove: " + anotherIntegerList);
    }


}

