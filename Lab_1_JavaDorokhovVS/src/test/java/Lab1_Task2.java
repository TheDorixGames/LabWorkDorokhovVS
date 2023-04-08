import java.util.Scanner;
/**
 * A program in which all arguments passed to the input string are displayed
 * on the screen in reverse order. For example, if 2 arguments were passed – make install, then
 * llatsni ekam should be displayed on the screen. Note*: To spell a word,
 * you need to use the charAt() function. For example, str.charAt(i) will return a character from
 * position i in a word written to the string variable str. The str.length() command returns
 * the length of the word str.
 *
 * @author Victor Dorokhov
 * @since 1.0
 */
public class Lab1_Task2 {
    /**
     * Methods of which all arguments passed to the input string are displayed on the screen in reverse order.
     */
    public static void main (String[] args) {
        String a;
        String b;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите 1-ое слово");
        a = in.nextLine();
        System.out.println("Введите 2-ое слово");
        b = in.nextLine();
        String str = a + " " + b;
        System.out.println("Входная строка: " + str);
        char sim;
        String res = "";
        /**
         * A loop for flipping a string
         */
        for (int i=0; i<str.length(); i++)
        {
            sim= str.charAt(i);
            res= sim+res;
        }
        System.out.println("Конечная строка: " + res);
    }
}
