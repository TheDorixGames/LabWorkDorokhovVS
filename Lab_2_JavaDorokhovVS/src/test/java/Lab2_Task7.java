import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Given a natural number N. Calculate: s=1-1/2+1/4-1/8+...+(-1)^n*1/2^n
 *
 * @author Victor Dorokhov
 * @since 1.0
 */
public class Lab2_Task7 {
    private static int N = 0;
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
         * Input values N in the console
         */
        System.out.print("Введите значение N: ");
        N = scanner.nextInt();
        /**
         * Checking the input of the N value
         */
        if (N<=0) {
            System.out.print("Ошибка: Введеное вами значение n не является натуральным числом!");
            return;
        }
    }

    /**
     * Method for entering data from a file
     */
    public static void InputFile() {
        String path = "src/main/resources/Input.txt";
        N = 0;
        /**
         * Checking for file search and matching data type
         */
        try {
            try (Scanner in = new Scanner(new File(path))) {
                N = in.nextInt();
                /**
                 * Checking the input of the N value
                 */
                if (N<=0) {
                    System.out.print("Ошибка: Введеное вами значение n не является натуральным числом!");
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
     * Method for calculating the value of s=1-1/2+1/4-1/8+...+(-1)^n*1/2^n
     */
    public static void ResultCalculation() {
        /**
         * Initializing the initial value of the sum
         */
        double s = 1;
        /**
         * Initializing the beginning of the formula calculation
         */
        double d = 1;
        /**
         * Initializing the denominator
         */
        double k = 1;
        /**
         * Performing calculations
         */
        for (int i=0; i<N; i++) {
            k*=2;
            d*=-1;
            s+=d*(1/k);
        }
        /**
         * Output of result to the console
         */
        System.out.print("Результат вычислений равен " + s);
    }
}
