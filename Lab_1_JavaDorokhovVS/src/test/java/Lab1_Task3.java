import java.util.Scanner;
/**
 * A program that calculates Fibonacci numbers. Fibonacci numbers are
 * a sequence of numbers in which each subsequent number is equal to the sum
 * of the previous two. The beginning of this sequence is numbers 1, 1, 2, 3, 5, 8, 13…
 *
 * @author Victor Dorokhov
 * @since 1.0
 */
public class Lab1_Task3 {
    /**
     * A method that calculates Fibonacci numbers when entering their number into the console.
     */
    public static void main(String[] args) {
        System.out.print("Введите количество чисел Фибоначчи для вывода в консоль: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        /**
         * Checking the value
         */
        if (n <= 0)
        {
            System.out.print("Ошибка: Количество чисел Фибоначчи должно быть положительным числом");
            return;
        }
        if (n == 1) {
            System.out.print("Числа Фибоначчи: 0");
            return;
        }
        if (n == 2) {
            System.out.print("Числа Фибоначчи: 0 1");
            return;
        }
        /**
         * Creating an array of fibonacci numbers
         */
        int[] fibonachi = new int[n];
        /**
         * Recording the initial Fibonacci numbers for further calculation of the rest
         */
        fibonachi[0] = 0;
        fibonachi[1] = 1;
        /**
         * Calculating Fibonacci numbers
         */
        for (int i = 2; i < n; ++i) {
            fibonachi[i] = fibonachi[i - 1] + fibonachi[i - 2];
        }
        /**
         * Output of Fibonacci numbers to the console
         */
        System.out.print("Числа Фибоначчи: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonachi[i] + " ");
        }
    }
}