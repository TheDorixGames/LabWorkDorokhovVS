/**
 * A program in which numbers from 1 to 500 are sorted and displayed on the screen.
 * If the number is divided by 5, then the word fizz is output instead, if by 7,
 * then buzz. If the number divided by 5 and by 7, then output the word fizzbuzz.
 * Note*: remainder from division in Java denoted by the symbol %
 *
 * @author Victor Dorokhov
 * @since 1.0
 */
public class Lab1_Task1 {
    /**
     * A string containing the value "fizz".
     * Used for output to the console
     * at the suenary when the value is divided by 5.
     */
    public static final String  FiveDivide = "fizz";
    /**
     * A string containing the value "buzz".
     * Used for output to the console
     * at the suenary when the value is divided by 7.
     */
    public static final String  SevenDivide = "buzz";
    /**
     * An integer number that stores the last number of the sequence
     */
    public static final int max = 500;
    /**
     * A method in which numbers from 1 to 500 are sorted and displayed on the screen.
     */
    public static void main(String[] args) {
        for (int i = 1; i <= max; i++) {
            if ((i % 5 == 0) && (i % 7 == 0)) {
                System.out.println(FiveDivide + SevenDivide);
            } else if (i % 5 == 0) {
                System.out.println(FiveDivide);
            } else if (i % 7 == 0) {
                System.out.println(SevenDivide);
            } else {
                System.out.println(i);
            }
        }
    }
}
