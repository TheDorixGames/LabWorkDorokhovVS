/**
 * The real x is given. Calculate: p=((x-1)*(x-3)*(x-7)...(x-63))/((x-2)*(x-4)*(x-6)...(x-64))
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

public class Lab3_Task8 {
    private static double x = 0;
    private static final Logger logger = LogManager.getLogger(Lab3_Task8.class);
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
         * Input values x in the console
         */
        System.out.print("Введите значение x: ");
        double x = scanner.nextDouble();
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
                x = in.nextDouble();
            }
        } catch (FileNotFoundException e) {
            logger.fatal("Ошибка чтения из файла " + e + "! файл " + path + " не найден!");
        } catch (InputMismatchException e) {
            logger.fatal("Ошибка чтения из файла " + e + "! Не соответствие типов данных!");
        }
    }

    /**
     * Calculation method:
     * p=((x-1)*(x-3)*(x-7)...(x-63))/((x-2)*(x-4)*(x-6)...(x-64))
     */
    public static void ResultCalculation() {
        logger.debug("Метод ResultCalculation начал выполнение");
        int i = 1;
        logger.debug("Иницализация числителя");
        double p1 = 1; // Initializing the numerator
        logger.debug("Иницализация знаменателя");
        double p2 = 1; // Initializing the denominator
        logger.debug("Иницализация результата");
        double result = 0; // Initializing the result
        /**
         * Performing calculations in the numerator
         */
        logger.debug("Выполнение вычислений в числителе");
        while (i<=63) {
            p1*=(x-i);
            i=2*i+1;
        }
        /**
         * Performing calculations in the denominator
         */
        logger.debug("Выполнение вычислений в знаменателе");
        i = 2;
        while (i<=64) {
            p2*=(x-i);
            i=2*i;
        }
        /**
         * Performing calculations
         */
        logger.debug("Получение результата");
        result = p1/p2;
        /**
         * Output of result to the console
         */
        logger.debug("Вывод результата");
        System.out.print("Результат вычисления = " + result + "\n\n");
    }
}
