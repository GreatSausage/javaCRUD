import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Person {
  String firstName;
  String lastName;
  int age;

  public Person(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  @Override
  public String toString() {
    return firstName + " " + lastName + " (" + age + ")";
  }
}

public class Sausage {
  public static void main(String[] args) throws IOException {
    ArrayList<Person> people = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("Menu:");
      System.out.println("1. Insert data");
      System.out.println("2. Display data");
      System.out.println("3. Exit");
      System.out.print("Enter your choice: ");

      int choice = scanner.nextInt();
      scanner.nextLine();  // consume the newline character

      switch (choice) {
        case 1:
          System.out.print("Enter first name: ");
          String firstName = scanner.nextLine();
          System.out.print("Enter last name: ");
          String lastName = scanner.nextLine();
          System.out.print("Enter age: ");
          int age = scanner.nextInt();
          scanner.nextLine();  // consume the newline character

          Person person = new Person(firstName, lastName, age);
          people.add(person);

          try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("studentlist.txt"), true))) {
            writer.write(person.toString() + "\n");
          } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
          }
          break;
        case 2:
          if (people.isEmpty()) {
            System.out.println("No data to display.");
          } else {
            for (Person p : people) {
              System.out.println(p);
            }
          }
          break;
        case 3:
          return;
        default:
          System.out.println("Invalid choice.");
          break;
      }
    }
  }
}