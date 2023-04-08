/**
 * An arbitrary html file is submitted to the program input,
 * it is necessary to remove all attributes from
 * all tags except those specified by the user.
 * Output statistics on the processed file to the console:
 * – Specify the tag and number in the source file from the user-defined;
 * – Specify the tag and number in the source file whose attributes have been removed.
 * Save a new html file.
 *
 * @author Victor Dorokhov
 * @since 1.0
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Lab4_Task1 {
    /**
     * A method for removing all attributes from all tags except those specified by the user.
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        /**
         * Path to the HTML file
         */
        String filePath = "src/main/resources/index.html";
        /**
         * Input the number of tags to save attributes
         */
        System.out.print("Введите количество тегов, у которых необходимо сохранить атрибуты в конечном файле: ");
        int size = scanner.nextInt();
        /**
         * Checking the input of the size value
         */
        if (size < 0) {
            System.out.print("Ошибка: Введеное вами значение \"Количество тегов\" не является натуральным числом.");
            return;
        }
        Map<String, Integer> userTags = new HashMap<>();
        /**
         * Creating an array of tags
         */
        String[] userMassive = new String[size];
        int counter = 1;
        /**
         * input tags to save attributes and writing their array
         */
        for (int i = 0; i < size; i++) {
            System.out.print("Введите тег #" + counter + ": ");
            userMassive[i] = scanner.next();
            userTags.put(userMassive[i], 0);
            counter++;
        }
        /**
         * Reading a file into a string
         */
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        /**
         * Pattern for tag search
         */
        Pattern tagPattern = Pattern.compile("<([a-zA-Z]+)(\\s+(\\w+\\s*=\\s*\"[^\"]*\"|\\w+\\s*=\\s*'[^']*'|\\w+\\s*=\\s*[^'\"\\s>]+))*\\s*/?>");
        /**
         * Finding and removing attributes from tags
         */
        Matcher tagMatcher = tagPattern.matcher(content);
        StringBuilder output = new StringBuilder();
        while (tagMatcher.find()) {
            String tag = tagMatcher.group(1);
            /**
             * Checking for the presence of a tag in a group of custom tags
             */
            if (userTags.containsKey(tag)) {
                userTags.put(tag, userTags.get(tag) + 1);
                output.append(tagMatcher.group()).append("\n"); // Save attributes
            } else {
                output.append("<").append(tag).append(">\n"); // Delete attributes
            }
        }
        content = output.toString();
        /**
         * Writing to the processed file
         */
        Files.write(Paths.get("src/main/resources/newindex.html"), content.getBytes());
        /**
         * Output of tags that have been found and saved attributes
         */
        System.out.println("\nТеги с атрибутами:");
        for (String tag : userTags.keySet()) {
            /**
             * Checking for the number of tags found
             */
            if (userTags.get(tag) > 0) {
                System.out.println(tag + ": " + userTags.get(tag)); // Output of found custom tags to the console
            }
        }
        /**
         * Output of tags that have been found and removed attributes
         */
        System.out.println("\nТеги без атрибутов:");
        Matcher tagMatcher2 = tagPattern.matcher(content);
        Map<String, Integer> removedTags = new HashMap<>();
        while (tagMatcher2.find()) {
            String tag = tagMatcher2.group(1);
            /**
             * Checking the absence of a tag in a group of custom tags
             */
            if (!userTags.containsKey(tag)) {
                removedTags.put(tag, removedTags.getOrDefault(tag, 0) + 1);
            }
        }
        for (String tag : removedTags.keySet()) {
            System.out.println(tag + ": " + removedTags.get(tag)); // Output of tags with deleted attributes to the console
        }
    }
}