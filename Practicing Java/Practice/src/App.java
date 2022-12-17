import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
    int num;
    int fact=1;
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a number: ");
    num = input.nextInt();
        for (int i=1;i<=num; i++){
            fact=fact*i;
            System.out.println("Factorial: "+fact);
        }
    input.close();
    }
}