/**
 * Emulate the work of the next "Warcraft" process. A given number
 * of units extract gold in equal portions from one mine, lingering
 * on the way for a random time until it is depleted.
 * The work of each unit is implemented in the generated process (thread).
 *
 * @author Victor Dorokhov
 * @since 1.0
 */

import java.util.Random;
import java.util.Scanner;

public class Warcraft {
    /**
     * Number of units
     */
    private static int numUnits = 0;
    /**
     * The amount of gold in the mine
     */
    private static int goldMine = 0;
    /**
     * The amount of gold that 1 unit can mine
     */
    private static int goldCount = 0;
    /**
     * Method of creating a multithreaded application
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /**
         * Creating a counter variable for the thread name
         */
        int counter = 0;
        /**
         * Input the numUnits in the console
         */
        System.out.print("Введите количество юнитов: ");
        numUnits = scanner.nextInt();
        /**
         * Checking the input of the numUnits value
         */
        if (numUnits <= 0) {
            System.out.println("Ошибка: Параметр \"Количество юнитов\" должен быть положительным значением больше 0.");
            return;
        }
        /**
         * Input the goldMine in the console
         */
        System.out.print("Введите количество золота в шахте: ");
        goldMine = scanner.nextInt();
        /**
         * Checking the input of the goldMine value
         */
        if (goldMine <= 0) {
            System.out.println("Ошибка: Параметр \"Количество золота в шахт\" должен быть положительным значением больше 0.");
            return;
        }
        /**
         * Input the goldCount in the console
         */
        System.out.print("Введите количество золота, которое может добыть 1 юнит: ");
        goldCount = scanner.nextInt();
        /**
         * Checking the input of the goldCount value
         */
        if (goldCount <= 0) {
            System.out.println("Ошибка: Параметр \"Количество золота 1 юнита\" должен быть положительным значением больше 0.");
            return;
        }
        if ((goldCount < 11)||(goldCount > 25)) {
            System.out.println("Ошибка: Параметр \"Количество золота 1 юнита\" не должен быть меньше 10 и больше 25.");
            return;
        }
        /**
         * Creating an array of threads
         */
        Thread[] unitThreads = new Thread[numUnits];
        for (int i = 0; i < numUnits; i++) {
            counter = i+1;
            unitThreads[i] = new Thread(() -> {
                try {
                    Random rand = new Random();
                    /**
                     * Setting a random delay time
                     */
                    int time = rand.nextInt(5) + 1;
                    Thread.sleep(time * 1000);
                    /**
                     * Perform while there is gold in the mine
                     */
                    while (goldMine > 0) {
                        /**
                         * Synchronization of threads
                         */
                        synchronized (Warcraft.class) {
                            /**
                             * Checking the presence of gold in the mine
                             */
                            if (goldMine > 0) {
                                /**
                                 * Gold mining
                                 */
                                if (goldMine > goldCount) {
                                    goldMine -= goldCount;
                                    System.out.println(Thread.currentThread().getName() + " добыл " + goldCount + " золота");
                                } else {
                                    System.out.println(Thread.currentThread().getName() + " добыл " + goldMine + " золота");
                                    goldMine -= goldMine;
                                }
                            }
                        }
                        /**
                         * 1 second delay after gold mining
                         */
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            /**
             * Setting the thread name
             */
            unitThreads[i].setName("Юнит #" + counter);
            /**
             * Starting a thread
             */
            unitThreads[i].start();
        }

        /**
         * Creating a results output thread
         */
        Thread resultsThread = new Thread(() -> {
            try {
                for (int i = 0; i < numUnits; i++) {
                    /**
                     * Waiting for the completion of gold mining flows
                     */
                    unitThreads[i].join();
                }
                System.out.println("Золото в шахте закончилось");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        /**
         * Starting the output stream of the results
         */
        resultsThread.start();
    }
}