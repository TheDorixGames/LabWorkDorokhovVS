import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import java.util.InputMismatchException;

/**
 * Given the numbers x, y, z. Find the value of the expression:
 * u=(max^2(x,y,z)-2^x*min(x,y,z))/((sin(2*x)+max(x,y,z))/(min(x,y, z)))
 *
 * @author Victor Dorokhov
 * @since 1.0
 */
public class Lab2_Task4 {
    private static int x = 0, y = 0, z = 0;
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
         * Input values x, y, z in the console
         */
        System.out.print("Введите значение x: ");
        x = scanner.nextInt();
        System.out.print("Введите значение y: ");
        y = scanner.nextInt();
        System.out.print("Введите значение z: ");
        z = scanner.nextInt();
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
                x = in.nextInt();
                y = in.nextInt();
                z = in.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка " + e + "! файл " + path + " не найден!");
        } catch (InputMismatchException e) {
            System.out.println("Ошибка " + e + "! Не соответствие типов данных!");
        }
    }

    /**
     * Method for calculating the value of the expression: u=(max^2(x,y,z)-2^x*min(x,y,z))/((sin(2*x)+max(x,y,z))/(min(x,y, z)))
     */
    public static void ResultCalculation() {
        /**
         * Initializing the maximum and minimym
         */
        int max = x, min = x;
        /**
         * Search for the maximum
         */
        if (max < y) {
            max = y;
        }
        if (max < z) {
            max = z;
        }
        /**
         * Search for the minimym
         */
        if (min > y) {
            min = y;
        }
        if (min > z) {
            min = z;
        }
        /**
         * Initializing the result
         */
        double result = 0;
        /**
         * Calculating the result of the expression: u=(max^2(x,y,z)-2^x*min(x,y,z))/((sin(2*x)+max(x,y,z))/(min(x,y, z)))
         */
        result = (Math.pow(max, 2)-Math.pow(2, x)*min)/((Math.sin(2*x)+max)/min);
        /**
         * Output of result to the console
         */
        System.out.print("Максимум = " + max +"\nМинимум = " + min + "\nРезультат вычислений равен " + result);
    }
}
