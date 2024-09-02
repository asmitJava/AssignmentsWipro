package Day15.SerializationAndDeserialization;


import java.io.Serializable;

public class Employee1 implements Serializable {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee1(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }


    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Age: " + age);
        System.out.println("Employee Salary: " + salary);
    }

    public double calculateAnnualSalary() {
        return salary * 12;
    }

    public boolean isEligibleForPromotion() {
        return age > 30 && salary > 5000.0;
    }


}
