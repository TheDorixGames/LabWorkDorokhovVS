/**
 * Given a natural number n < 99. Add the number k to it at the end and at the beginning.
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

public class Lab3_Task6 {
    private static int n = 0, k = 0;
    private static final Logger logger = LogManager.getLogger(Lab3_Task6.class);
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
         * Input values n in the console
         */
        System.out.print("Введите значение n: ");
        n = scanner.nextInt();
        logger.debug("Значение n получено");
        /**
         * Checking the input of the n value
         */
        if (n<=0) {
            logger.info("Введеное вами значение n не является натуральным число!");
            return;
        }
        if (n>99) {
            logger.info("Введеное вами значение n больше 99!");
            return;
        }
        /**
         * Input values k in the console
         */
        System.out.print("Введите значение k: ");
        k = scanner.nextInt();
        logger.debug("Значение k получено");
        /**
         * Checking the input of the k value
         */
        if (k<=0) {
            logger.error("Введеное вами значение k должно быть положительным значением!");
            return;
        }
        if (k>9) {
            logger.error("Введеное вами значение k должно быть цифрой, а не числом!");
            return;
        }
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
                logger.debug("Чтение значения n из файла Input.txt");
                n = in.nextInt();
                /**
                 * Checking the input of the n value
                 */
                if (n<=0) {
                    logger.info("Значение n из файла не является натуральным число!");
                    return;
                }
                if (n>99) {
                    logger.info("Значение n из файла больше 99!");
                    return;
                }
                logger.debug("Чтение значения k из файла Input.txt");
                k = in.nextInt();
                /**
                 * Checking the input of the k value
                 */
                if (k<=0) {
                    logger.info("Значение k из файла должно быть положительным значением!");
                    return;
                }
                if (k>9) {
                    logger.info("Значение k из файла должно быть цифрой, а не числом!");
                    return;
                }
            }
        } catch (FileNotFoundException e) {
            logger.fatal("Ошибка чтения из файла " + e + "! файл " + path + " не найден!");
        } catch (InputMismatchException e) {
            logger.fatal("Ошибка чтения из файла " + e + "! Не соответствие типов данных!");
        }
    }

    /**
     * A method appending the digit k to the end and to the beginning of the entered value.
     */
    public static void ResultCalculation() {
        logger.debug("Метод ResultCalculation начал выполнение");
        /**
         * Initializing the result
         */
        logger.debug("Иницализация результата");
        int result = 0; // Initializing the result
        /**
         * Getting the result
         */
        logger.debug("Получение результата");
        if (n < 10) {
            result = 100*k+n*10+k;
        } else {
            result = 1000*k+n*10+k;
        }
        /**
         * Output of result to the console
         */
        logger.debug("Вывод результата");
        System.out.print("Полученное число = " + result + "\n\n");
    }
}
