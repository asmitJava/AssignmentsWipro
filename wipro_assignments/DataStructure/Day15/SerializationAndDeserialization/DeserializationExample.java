package Day15.SerializationAndDeserialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream("\\C:\\Users\\natha\\Desktop\\ASSIGNMENT\\foleIO\\Employee1.ser.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Employee1 employee = (Employee1) ois.readObject();

            employee.displayEmployeeInfo();

            double annualSalary = employee.calculateAnnualSalary();
            System.out.println("Annual Salary: " + annualSalary);

            boolean isEligibleForPromotion = employee.isEligibleForPromotion();
            System.out.println("Is Eligible for Promotion: " + isEligibleForPromotion);

            System.out.println("\nDeserialized Employee object: " +" \n"+ employee.toString());
        }
    }
}