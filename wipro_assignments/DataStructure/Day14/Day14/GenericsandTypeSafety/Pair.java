package Assignment.Day14.GenericsandTypeSafety;
public class Pair<T, U> {
    // Private fields to hold the two elements of the pair
    private T first;
    private U second;

    // Constructor to initialize the pair with two elements
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    // Getter method to retrieve the first element
    public T getFirst() {
        return first;
    }

    // Getter method to retrieve the second element
    public U getSecond() {
        return second;
    }

    // Method to reverse the pair, swapping the elements
    public Pair<U, T> reverse() {
        // Create a new pair with the elements swapped
        return new Pair<>(second, first);
    }

    // Override the toString method to provide a nice string representation
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public static void main(String[] args) {
        // Create a pair with a String and an Integer
        Pair<String, Integer> pair = new Pair<>("Hello", 42);
        System.out.println("Step 1: Create a pair with a String and an Integer");
        System.out.println("Original pair: " + pair);

        // Get the first element of the pair
        String firstElement = pair.getFirst();
        System.out.println("Step 2: Get the first element of the pair: " + firstElement);

        // Get the second element of the pair
        Integer secondElement = pair.getSecond();
        System.out.println("Step 3: Get the second element of the pair: " + secondElement);

        // Reverse the pair
        Pair<Integer, String> reversedPair = pair.reverse();
        System.out.println("Step 4: Reverse the pair");
        System.out.println("Reversed pair: " + reversedPair);

        // Get the first element of the reversed pair
        Integer reversedFirstElement = reversedPair.getFirst();
        System.out.println("Step 5: Get the first element of the reversed pair: " + reversedFirstElement);

        // Get the second element of the reversed pair
        String reversedSecondElement = reversedPair.getSecond();
        System.out.println("Step 6: Get the second element of the reversed pair: " + reversedSecondElement);
    }
}