import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * The integers m, n are given. If the numbers are not equal,
 * then replace each of them with the same number equal to the larger
 * of the original ones, and if equal, then replace the numbers with zeros.
 *
 * @author Victor Dorokhov
 * @since 1.0
 */
public class Lab2_Task3 {
    private static int m = 0, n = 0;
    /**
     * Data entry selection method
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int choice;
            /**
             * Menu output to the console
             */
            System.out.println("Выберите способ ввода данных: ");
            System.out.println("1) - Ввод данных с клавиатуры");
            System.out.println("2) - Ввод данных из файла");
            System.out.print("\nВыбор пользователя: ");
            choice = sc.nextInt();
            /**
             * Selecting a data entry option
             */
            switch (choice) {
                case 1: {
                    InputConsole(); // Calling the input method from the console
                    break;
                }
                case 2: {
                    InputFile(); // Calling an input method from a file
                    break;
                }
                default:
                    System.out.println("\nОшибка: Такого режима нет. Попробуйте выбрать режим заново.");
                    return;
            }
            ResultCalculation(); // Launching the calculation method
        }
        /**
         * Checking for data type compliance
         */
        catch (InputMismatchException e)
        {
            System.out.println("Ошибка " + e + "! Не соответствие типов данных!");
        }
    }

    /**
     * Method for entering data from the console
     */
    public static void InputConsole() {
        Scanner scanner = new Scanner(System.in);
        /**
         * Input the m and n numbers in the console
         */
        System.out.print("Введите число m: ");
        m = scanner.nextInt();
        System.out.print("Введите число n: ");
        n = scanner.nextInt();
    }

    /**
     * Method for entering data from a file
     */
    public static void InputFile() {
        String path = "src/main/resources/Input.txt";
        /**
         * Checking for file search and matching data type
         */
        try {
            try (Scanner in = new Scanner(new File(path))) {
                m = in.nextInt();
                n = in.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка " + e + "! файл " + path + " не найден!");
        } catch (InputMismatchException e) {
            System.out.println("Ошибка " + e + "! Не соответствие типов данных!");
        }
    }

    /**
     * A method for finding the largest value among unequal numbers
     */
    public static void ResultCalculation() {
        /**
         * Equality check
         */
        if (m!=n) {
            /**
             * Finding the maximum value
             */
            if(m>n) {
                n = m;
            }
            else {
                m = n;
            }
        } else {
            m = 0;
            n = 0;
        }
        /**
         * Output of m and n numbers to the console
         */
        System.out.print("\nЗначение m = " + m + "\nЗначение n = " + n);
    }
}
