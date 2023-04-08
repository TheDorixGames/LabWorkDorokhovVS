import java.util.Scanner;
/**
 * An integer is given. If it is positive, then add 1 to it;
 * otherwise, do not change it. Print the resulting number.
 *
 * @author Victor Dorokhov
 * @since 1.0
 */
public class Lab1_Task5 {
    /**
     * A method that adds 1 to a positive number
     */
    public static void main(String[] args) {
        System.out.print("Введите целое число: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        /**
         * If the number is positive add 1
         */
        if (num > 0) {
            num+=1;
        }
        System.out.print("Результат: " + num);
    }
}
