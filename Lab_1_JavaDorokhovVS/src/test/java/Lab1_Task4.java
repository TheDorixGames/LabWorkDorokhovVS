import java.util.Scanner;
/**
 * A program that calculates the factorial of an integer.
 *
 * @author Victor Dorokhov
 * @since 1.0
 */
public class Lab1_Task4 {
    /**
     * A method that calculates the factorial of an integer.
     */
    public static void main(String[] args) {
        /**
         * The factorial is the value of the product so it should be 1
         */
        int factorial = 1;
        System.out.print("Введите значение факториала: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        /**
         * Checking the value
         */
        if (num < 0)
        {
            System.out.print("Ошибка: Число факториала должно быть положительным значением!");
            return;
        }
        /**
         * Calculating factorial
         */
        for (int i=2;i<=num; i++) {
            factorial*=i;
        }
        /**
         * Output of factorial result to the console
         */
        System.out.print("Факториал числа "+ num +" равен "+ factorial);
    }
}
