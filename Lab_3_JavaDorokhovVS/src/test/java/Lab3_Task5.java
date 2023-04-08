/**
 * Create a program that allows you to get a verbal description of school grades
 * (1 - bad, 2 - unsatisfactory, 3 - satisfactory, 4 - good, 5 - excellent).
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

public class Lab3_Task5 {
    private static int mark = 0;
    private static final Logger logger = LogManager.getLogger(Lab3_Task5.class);
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
         * Input school grade in the console and search
         * for a verbal description of a school grade
         */
        System.out.print("Введите школьную отметку: ");
        mark = scanner.nextInt();
        logger.debug("Значение школьной отметки получено");
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
            logger.debug("Чтение значения mark из файла Input.txt");
            try (Scanner in = new Scanner(new File(path))) {
                mark = in.nextInt();
            }
        } catch (FileNotFoundException e) {
            logger.fatal("Ошибка чтения из файла " + e + "! файл " + path + " не найден!");
        } catch (InputMismatchException e) {
            logger.fatal("Ошибка чтения из файла " + e + "! Не соответствие типов данных!");
        }
    }

    /**
     * A method that allows you to get
     * a verbal description of school grades
     */
    public static void ResultCalculation() {
        logger.debug("Метод ResultCalculation начал выполнение");
        String word;
        logger.debug("Поиск необходимого названия");
        switch (mark) {
            case 1: word = "плохо"; break;
            case 2: word = "неудовлетворительно"; break;
            case 3: word = "удовлетворительно"; break;
            case 4: word = "хорошо"; break;
            case 5: word = "отлично"; break;
            default: System.out.print("Нет такой оценки"); return;
        }
        /**
         * Output of school grade and verbal description to the console
         */
        logger.debug("Вывод школьной оценки на экран");
        System.out.print("Оценке " + mark + " соответствует " + word + "\n\n");
    }
}
