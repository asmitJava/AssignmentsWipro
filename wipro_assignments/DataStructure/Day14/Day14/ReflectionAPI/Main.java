package Assignment.Day14.ReflectionAPI;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception
    {
        // Step 1: Get the Class object for the Person class
        Class<?> clazz = Class.forName("Person");
        System.out.println("Step 1: Get the Class object for the Person class");
        System.out.println("Class name: " + clazz.getName());

        // Step 2: Inspect the constructors of the Person class
        Constructor<?>[] constructors = clazz.getConstructors();
        System.out.println("\nStep 2: Inspect the constructors of the Person class");
        System.out.println("Number of constructors: " + constructors.length);
        for (Constructor<?> constructor : constructors) {
            System.out.println("Constructor: " + constructor);
        }

        // Step 3: Inspect the methods of the Person class
        Method[] methods = clazz.getMethods();
        System.out.println("\nStep 3: Inspect the methods of the Person class");
        System.out.println("Number of methods: " + methods.length);
        for (Method method : methods) {
            System.out.println("Method: " + method);
        }

        // Step 4: Inspect the fields of the Person class
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("\nStep 4: Inspect the fields of the Person class");
        System.out.println("Number of fields: " + fields.length);
        for (Field field : fields) {
            System.out.println("Field: " + field);
        }

        // Step 5: Modify the access level of a private field
        Field privateField = clazz.getDeclaredField("privateString");
        privateField.setAccessible(true); // Make the private field accessible
        System.out.println("\nStep 5: Modify the access level of a private field");
        System.out.println("Private field: " + privateField);

        // Step 6: Create an instance of the Person class
        Person1 person1 = new Person1("John", 25);
        System.out.println("\nStep 6: Create an instance of the Person class");
        System.out.println("Person object: " + person1);

        // Step 7: Set the value of the private field during runtime
        privateField.set(person1, "New private string value");
        System.out.println("\nStep 7: Set the value of the private field during runtime");
        System.out.println("Private field value: " + privateField.get(person1));
    }
}
