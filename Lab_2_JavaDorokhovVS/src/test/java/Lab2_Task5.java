import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Create a program that allows you to get a verbal description of school grades
 * (1 - bad, 2 - unsatisfactory, 3 - satisfactory, 4 - good, 5 - excellent).
 *
 * @author Victor Dorokhov
 * @since 1.0
 */
public class Lab2_Task5 {
    private static int mark = 0;
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
         * Input school grade in the console and search for a verbal description of a school grade
         */
        System.out.print("Введите школьную отметку: ");
        mark = scanner.nextInt();
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
                mark = in.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка " + e + "! файл " + path + " не найден!");
        } catch (InputMismatchException e) {
            System.out.println("Ошибка " + e + "! Не соответствие типов данных!");
        }
    }
    /**
     * A method that allows you to get a verbal description of school grades
     */
    public static void ResultCalculation() {
        String word;
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
        System.out.print("Оценке " + mark + " соответствует " + word);
    }
}
