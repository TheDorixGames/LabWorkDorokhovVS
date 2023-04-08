import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import java.util.InputMismatchException;

/**
 * Calculate the distance between two points with the given coordinates (x1, y1) and (x2, y2).
 *
 * @author Victor Dorokhov
 * @since 1.0
 */
public class Lab2_Task2 {
    private static int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
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
         * Input coordinates x1, y1, x2, y2 in the console
         */
        System.out.print("Введите координату x1: ");
        x1 = scanner.nextInt();
        System.out.print("Введите координату y1: ");
        y1 = scanner.nextInt();
        System.out.print("Введите координату x2: ");
        x2 = scanner.nextInt();
        System.out.print("Введите координату y2: ");
        y2 = scanner.nextInt();;
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
                x1 = in.nextInt();
                y1 = in.nextInt();
                x2 = in.nextInt();
                y2 = in.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка " + e + "! файл " + path + " не найден!");
        } catch (InputMismatchException e) {
            System.out.println("Ошибка " + e + "! Не соответствие типов данных!");
        }
    }

    /**
     * A method for calculating the distance between two points with given coordinates (x1, y1) and (x2, y2).
     */
    public static void ResultCalculation() {
        /**
         * Initializing the distance
         */
        double distance = 0;
        /**
         * Calculating the distance between two points with the given coordinates
         */
        distance = Math.sqrt((Math.pow(x2-x1, 2)) + (Math.pow(y2-y1, 2)));
        /**
         * Output of distance result to the console
         */
        System.out.print("Расстояние между двумя точками с данными координатами (" + x1 + "; " + y1 + ") (" + x2 + "; " + y2 + ") равно "+ distance);
    }
}
