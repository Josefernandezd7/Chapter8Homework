import java.util.ArrayList;

public class ReverseArrayList {
    public static <E> void reverseArrayListInPlace(ArrayList<E> list) {
        int size = list.size();
        int lastIndex = size - 1;

        for (int i = 0; i < size / 2; i++) {
            E temp = list.get(i);
            list.set(i, list.get(lastIndex - i));
            list.set(lastIndex - i, temp);
        }
       }

    public static void main(String[] args) {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);

         System.out.println("Original List: " + integerList);
        reverseArrayListInPlace(integerList);
        System.out.println("Reversed List: " + integerList);

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
         stringList.add("orange");
        stringList.add("grape");

        System.out.println("\nOriginal List: " + stringList);
        reverseArrayListInPlace(stringList);
        System.out.println("Reversed List: " + stringList);
    }
}

