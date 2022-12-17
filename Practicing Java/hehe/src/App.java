import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = sc.nextInt();
        for (int b = 1; b <= a; b++){
            if (b % 10 == 0 ){
            System.out.print(b + " ");
            }
        sc.close();
        }
    }
}
