/**
 * Calculate the distance between two points with the given coordinates (x1, y1) and (x2, y2).
 *
 * @author Victor Dorokhov
 * @since 1.0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import java.util.InputMismatchException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Lab3_Task2 {
    private static int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
    private static final Logger logger = LogManager.getLogger(Lab3_Task2.class);
    /**
     * Data entry selection method
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            logger.debug("Метод main начал выполнение");
            int choice; // User mode selection variable
            while (true) {
                /**
                 * Menu output to the console
                 */
                System.out.println("Выберите способ ввода данных: ");
                System.out.println("1) - Ввод данных с клавиатуры");
                System.out.println("2) - Ввод данных из файла");
                System.out.print("\nВыбор пользователя: ");
                choice = sc.nextInt();
                logger.debug("Выбор пользователя принят");
                /**
                 * Selecting a data entry option
                 */
                switch (choice) {
                    case 1: {
                        logger.debug("Запуск метода InputConsole");
                        InputConsole(); // Calling the input method from the console
                        break;
                    }
                    case 2: {
                        logger.debug("Запуск метода InputFile");
                        InputFile(); // Calling an input method from a file
                        break;
                    }
                    default:
                        logger.warn("Такого режима нет. Попробуйте выбрать режим заново.");
                        return;
                }
                logger.debug("Запуск метода ResultCalculation");
                ResultCalculation(); // Launching the calculation method
            }
        }
        /**
         * Checking for data type compliance
         */
        catch (InputMismatchException e)
        {
            logger.fatal("Ошибка " + e + "! Не соответствие типов данных!");
        }
    }

    /**
     * Method for entering data from the console
     */
    public static void InputConsole() {
        logger.debug("Метод InputConsole начал выполнение");
        Scanner scanner = new Scanner(System.in);
        /**
         * Input coordinates x1, y1, x2, y2 in the console
         */
        System.out.print("Введите координату x1: ");
        x1 = scanner.nextInt();
        logger.debug("Значение x1 получено");
        System.out.print("Введите координату y1: ");
        y1 = scanner.nextInt();
        logger.debug("Значение y1 получено");
        System.out.print("Введите координату x2: ");
        x2 = scanner.nextInt();
        logger.debug("Значение x2 получено");
        System.out.print("Введите координату y2: ");
        y2 = scanner.nextInt();;
        logger.debug("Значение y2 получено");
    }

    /**
     * Method for entering data from a file
     */
    public static void InputFile() {
        logger.debug("Метод InputFile начал выполнение");
        String path = "src/main/resources/Input.txt";
        /**
         * Checking for file search and matching data type
         */
        try {
            try (Scanner in = new Scanner(new File(path))) {
                logger.debug("Чтение значения x1 из файла Input.txt");
                x1 = in.nextInt();
                logger.debug("Чтение значения y1 из файла Input.txt");
                y1 = in.nextInt();
                logger.debug("Чтение значения x2 из файла Input.txt");
                x2 = in.nextInt();
                logger.debug("Чтение значения y2 из файла Input.txt");
                y2 = in.nextInt();
            }
        } catch (FileNotFoundException e) {
            logger.fatal("Ошибка чтения из файла " + e + "! файл " + path + " не найден!");
        } catch (InputMismatchException e) {
            logger.fatal("Ошибка чтения из файла " + e + "! Не соответствие типов данных!");
        }
    }

    /**
     * A method for calculating the distance between
     * two points with given coordinates (x1, y1) and (x2, y2).
     */
    public static void ResultCalculation() {
        logger.debug("Метод ResultCalculation начал выполнение");
        /**
         * Initializing the distance
         */
        logger.debug("Инициализация дистанции");
        double distance = 0; // Initializing the distance
        /**
         * Calculating the distance between two points with the given coordinates
         */
        logger.debug("Вычисление расстояния между двумя точками с заданными координатами");
        distance = Math.sqrt((Math.pow(x2-x1, 2))
                + (Math.pow(y2-y1, 2)));
        /**
         * Output of distance result to the console
         */
        logger.debug("Вывод результата");
        System.out.print("Расстояние между двумя точками с данными координатами ("
                + x1 + "; " + y1 + ") " + "(" + x2 + "; " + y2 + ") равно "+ distance + "\n\n");
    }
}
