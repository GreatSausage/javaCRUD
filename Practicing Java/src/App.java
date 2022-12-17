import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("A program that will ask for a letter input from the user and output the grade range based on the conditions");

        System.out.print("Enter a letter:");
        String grade = sc.next();

        grade = grade.toUpperCase();
        switch(grade){
            case "A": System.out.println("Grade range is 90 to 100"); break;
            case "B": System.out.println("Grade range is 80 to 89"); break;
            case "C": System.out.println("Grade range is 70 to 79"); break;
            case "D": System.out.println("Grade range is 60 to 69"); break;
            default: System.out.println("Out of range");
        }
    }
}
