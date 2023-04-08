import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * The real x is given. Calculate: p=((x-1)*(x-3)*(x-7)...(x-63))/((x-2)*(x-4)*(x-6)...(x-64))
 *
 * @author Victor Dorokhov
 * @since 1.0
 */
public class Lab2_Task8 {
    private static double x = 0;
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
         * Input values x in the console
         */
        System.out.print("Введите значение x: ");
        x = scanner.nextDouble();
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
                x = in.nextDouble();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка " + e + "! файл " + path + " не найден!");
        } catch (InputMismatchException e) {
            System.out.println("Ошибка " + e + "! Не соответствие типов данных!");
        }
    }

    /**
     * Calculation method: p=((x-1)*(x-3)*(x-7)...(x-63))/((x-2)*(x-4)*(x-6)...(x-64))
     */
    public static void ResultCalculation() {
        int i = 1;
        /**
         * Initializing the numerator, denominator and result
         */
        double p1 = 1, p2 = 1, result = 0;
        /**
         * Performing calculations in the numerator
         */
        while (i<=63) {
            p1*=(x-i);
            i=2*i+1;
        }
        /**
         * Performing calculations in the denominator
         */
        i = 2;
        while (i<=64) {
            p2*=(x-i);
            i=2*i;
        }
        /**
         * Performing calculations
         */
        result = p1/p2;
        /**
         * Output of result to the console
         */
        System.out.print("Результат вычисления = " + result);
    }
}
