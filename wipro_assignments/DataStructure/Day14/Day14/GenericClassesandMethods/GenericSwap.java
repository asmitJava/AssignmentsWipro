package Assignment.Day14.GenericClassesandMethods;

public class GenericSwap {
    // Generic method to swap two elements in an array
    public static <T> void swap(T[] array, int i, int j) {
        // Create a temporary variable to hold the element at index i
        T temp = array[i];
        // Assign the element at index j to index i
        array[i] = array[j];
        // Assign the temporary variable to index j
        array[j] = temp;
    }

    public static void main(String[] args) {
        // Demonstrate with an array of Integers
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Step 1: Create an array of Integers");
        System.out.println("Original intArray: " + java.util.Arrays.toString(intArray));
        System.out.println("Step 2: Swap elements at indices 1 and 3");
        swap(intArray, 1, 3);
        System.out.println("Swapped intArray: " + java.util.Arrays.toString(intArray));

        // Demonstrate with an array of Strings
        String[] stringArray = {"Hello", "World", "Java", "Programming"};
        System.out.println("\nStep 3: Create an array of Strings");
        System.out.println("Original stringArray: " + java.util.Arrays.toString(stringArray));
        System.out.println("Step 4: Swap elements at indices 1 and 2");
        swap(stringArray, 1, 2);
        System.out.println("Swapped stringArray: " + java.util.Arrays.toString(stringArray));

        // Demonstrate with an array of custom objects
        Person[] personArray = {new Person("John", 25),
                new Person("Jane", 30), new Person("Bob", 35)};

        System.out.println("\nStep 5: Create an array of custom Person objects");
        System.out.println("Original personArray: " + java.util.Arrays.toString(personArray));
        System.out.println("Step 6: Swap elements at indices 0 and 2");
        swap(personArray, 0, 2);
        System.out.println("Swapped personArray: " + java.util.Arrays.toString(personArray));
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}