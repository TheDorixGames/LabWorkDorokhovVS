/**
 * Calculate the values of the expression using the formula: x-(x^3/3)+(x^5/5)
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

public class Lab3_Task1 {
    private static double x = 0;
    private static final Logger logger = LogManager.getLogger(Lab3_Task1.class);
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
         * Input x in the console
         */
        System.out.print("Введите значение x: ");
        x = scanner.nextDouble();
        logger.debug("Значение x получено");
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
            logger.debug("Чтение значения x из файла Input.txt");
            try (Scanner in = new Scanner(new File(path))) {
                x = in.nextInt();
            }
        } catch (FileNotFoundException e) {
            logger.fatal("Ошибка чтения из файла " + e + "! файл " + path + " не найден!");
        } catch (InputMismatchException e) {
            logger.fatal("Ошибка чтения из файла " + e + "! Не соответствие типов данных!");
        }
    }

    /**
     * Method for calculating the value of
     * an expression using the formula: x-(x^3/3)+(x^5/5)
     */
    public static void ResultCalculation() {
        logger.debug("Метод ResultCalculation начал выполнение");
        /**
         * Initializing the result
         */
        logger.debug("Иницализация результата");
        double result = 0; // Initializing the result
        /**
         * Calculating the result using the formula
         */
        logger.debug("Расчет результата");
        result = x-(Math.pow(x, 3)/3)+(Math.pow(x, 5)/5);
        /**
         * Output of result to the console
         */
        logger.debug("Вывод результата");
        System.out.print("Результат вычислений при x = " + x +" равен " + result + "\n\n");
    }
}
