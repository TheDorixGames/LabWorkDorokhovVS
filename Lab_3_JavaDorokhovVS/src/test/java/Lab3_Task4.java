/**
 * Given the numbers x, y, z. Find the value of the expression:
 * u=(max^2(x,y,z)-2^x*min(x,y,z))/((sin(2*x)+max(x,y,z))/(min(x,y, z)))
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

public class Lab3_Task4 {
    private static int x = 0, y = 0, z = 0;
    private static final Logger logger = LogManager.getLogger(Lab3_Task4.class);
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
         * Input values x, y, z in the console
         */
        System.out.print("Введите значение x: ");
        x = scanner.nextInt();
        logger.debug("Значение x получено");
        System.out.print("Введите значение y: ");
        y = scanner.nextInt();
        logger.debug("Значение y получено");
        System.out.print("Введите значение z: ");
        z = scanner.nextInt();
        logger.debug("Значение z получено");
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
                logger.debug("Чтение значения x из файла Input.txt");
                x = in.nextInt();
                logger.debug("Чтение значения y из файла Input.txt");
                y = in.nextInt();
                logger.debug("Чтение значения z из файла Input.txt");
                z = in.nextInt();
            }
        } catch (FileNotFoundException e) {
            logger.fatal("Ошибка чтения из файла " + e + "! файл " + path + " не найден!");
        } catch (InputMismatchException e) {
            logger.fatal("Ошибка чтения из файла " + e + "! Не соответствие типов данных!");
        }
    }

    /**
     * Method for calculating the value of the expression:
     * u=(max^2(x,y,z)-2^x*min(x,y,z))/((sin(2*x)+max(x,y,z))/(min(x,y, z)))
     */
    public static void ResultCalculation() {
        logger.debug("Метод ResultCalculation начал выполнение");
        /**
         * Initializing the maximum and minimym
         */
        logger.debug("Инициализация минимума и максимума");
        int max = x, min = x;
        /**
         * Search for the maximum
         */
        logger.debug("Поиск максимума");
        if (max < y) {
            max = y;
        }
        if (max < z) {
            max = z;
        }
        /**
         * Search for the minimym
         */
        logger.debug("Поиск минимума");
        if (min > y) {
            min = y;
        }
        if (min > z) {
            min = z;
        }
        /**
         * Initializing the result
         */
        logger.debug("Инициализация результата");
        double result = 0; // Initializing the result
        /**
         * Calculating the result of the expression:
         * u=(max^2(x,y,z)-2^x*min(x,y,z))/((sin(2*x)+max(x,y,z))/(min(x,y, z)))
         */
        logger.debug("Получение результата");
        result = (Math.pow(max, 2)-Math.pow(2, x)*min)/((Math.sin(2*x)+max)/min);
        /**
         * Output of result to the console
         */
        logger.debug("Вывод результата");
        System.out.print("Максимум = " + max +"\nМинимум = "
                + min + "\nРезультат вычислений равен " + result + "\n\n");
    }
}
