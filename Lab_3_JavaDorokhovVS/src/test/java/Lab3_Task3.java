/**
 * The integers m, n are given. If the numbers are not equal,
 * then replace each of them with the same number equal to the larger
 * of the original ones, and if equal, then replace the numbers with zeros.
 *
 * @author Victor Dorokhov
 * @since 1.0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Lab3_Task3 {
    private static int m = 0, n = 0;
    private static final Logger logger = LogManager.getLogger(Lab3_Task3.class);
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
         * Input the m and n numbers in the console
         */
        System.out.print("Введите число m: ");
        m = scanner.nextInt();
        logger.debug("Значение m получено");
        System.out.print("Введите число n: ");
        n = scanner.nextInt();
        logger.debug("Значение n получено");
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
                logger.debug("Чтение значения m из файла Input.txt");
                m = in.nextInt();
                logger.debug("Чтение значения n из файла Input.txt");
                n = in.nextInt();
            }
        } catch (FileNotFoundException e) {
            logger.fatal("Ошибка чтения из файла " + e + "! файл " + path + " не найден!");
        } catch (InputMismatchException e) {
            logger.fatal("Ошибка чтения из файла " + e + "! Не соответствие типов данных!");
        }
    }

    /**
     * A method for finding the largest value among unequal numbers
     */
    public static void ResultCalculation() {
        logger.debug("Метод ResultCalculation начал выполнение");
        /**
         * Equality check
         */
        logger.debug("Получение результата");
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
        logger.debug("Вывод результата");
        System.out.print("\nЗначение m = " + m + "\nЗначение n = " + n + "\n\n");
    }
}
