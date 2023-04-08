/**
 * Given a natural number N. Calculate: s=1-1/2+1/4-1/8+...+(-1)^n*1/2^n
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

public class Lab3_Task7 {
    private static int N = 0;
    private static final Logger logger = LogManager.getLogger(Lab3_Task7.class);
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
         * Input values N in the console
         */
        System.out.print("Введите значение N: ");
        N = scanner.nextInt();
        logger.debug("Значение N получено");
        /**
         * Checking the input of the N value
         */
        if (N<=0) {
            logger.info("Введеное вами значение n не является натуральным число!");
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
                logger.debug("Чтение значения N из файла Input.txt");
                N = in.nextInt();
                /**
                 * Checking the input of the N value
                 */
                if (N<=0) {
                    logger.info("Значение N из файла не является натуральным число!");
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
     * Method for calculating the value of
     * s=1-1/2+1/4-1/8+...+(-1)^n*1/2^n
     */
    public static void ResultCalculation() {
        logger.debug("Метод ResultCalculation начал выполнение");
        logger.debug("Иницализация значения суммы");
        double s = 1; // Initializing the initial value of the sum
        logger.debug("Иницализация начала вычисления формулы");
        double d = 1; // Initializing the beginning of the formula calculation
        logger.debug("Иницализация знаменателя");
        double k = 1; // Initializing the denominator
        /**
         * Performing calculations
         */
        logger.debug("Получение результата");
        for (int i=0; i<N; i++) {
            k*=2;
            d*=-1;
            s+=d*(1/k);
        }
        /**
         * Output of result to the console
         */
        logger.debug("Вывод результата");
        System.out.print("Результат вычислений равен " + s + "\n\n");
    }
}
