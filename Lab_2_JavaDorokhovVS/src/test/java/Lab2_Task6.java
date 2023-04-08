import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Given a natural number n < 99. Add the number k to it at the end and at the beginning.
 *
 * @author Victor Dorokhov
 * @since 1.0
 */
public class Lab2_Task6 {
    private static int n = 0, k = 0;
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
         * Input values n in the console
         */
        System.out.print("Введите значение n: ");
        n = scanner.nextInt();
        /**
         * Checking the input of the n value
         */
        if (n<=0) {
            System.out.print("Ошибка: Введеное вами значение n не является натуральным число!");
            return;
        }
        if (n>99) {
            System.out.print("Ошибка: Введеное вами значение n больше 99!");
            return;
        }
        /**
         * Input values k in the console
         */
        System.out.print("Введите значение k: ");
        k = scanner.nextInt();
        /**
         * Checking the input of the k value
         */
        if (k<=0) {
            System.out.print("Ошибка: Введеное вами значение k должно быть положительным значением!");
            return;
        }
        if (k>9) {
            System.out.print("Ошибка: Введеное вами значение k должно быть цифрой, а не числом!");
            return;
        }
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
                n = in.nextInt();
                /**
                 * Checking the input of the n value
                 */
                if (n<=0) {
                    System.out.print("Ошибка: Введеное вами значение n не является натуральным число!");
                    return;
                }
                if (n>99) {
                    System.out.print("Ошибка: Введеное вами значение n больше 99!");
                    return;
                }
                k = in.nextInt();
                /**
                 * Checking the input of the k value
                 */
                if (k<=0) {
                    System.out.print("Ошибка: Введеное вами значение k должно быть положительным значением!");
                    return;
                }
                if (k>9) {
                    System.out.print("Ошибка: Введеное вами значение k должно быть цифрой, а не числом!");
                    return;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка " + e + "! файл " + path + " не найден!");
        } catch (InputMismatchException e) {
            System.out.println("Ошибка " + e + "! Не соответствие типов данных!");
        }
    }

    /**
     * A method appending the digit k to the end and to the beginning of the entered value.
     */
    public static void ResultCalculation() {
        /**
         * Initializing the result
         */
        int result = 0;
        /**
         * Getting the result
         */
        if (n < 10) {
            result = 100*k+n*10+k;
        } else {
            result = 1000*k+n*10+k;
        }
        /**
         * Output of result to the console
         */
        System.out.print("Полученное число = " + result);
    }
}
