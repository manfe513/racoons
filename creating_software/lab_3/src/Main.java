import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    /**
     * Сканер используется для получения ввода пользователя из консоли
     */
    Scanner in = new Scanner(System.in);

    /**
     * Форматировать вывод (2 знака после запятой)
     */
    private static String roundTo2(float inputValue) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(inputValue);

    }

    /**
     * Проверка ввода пользователя(+целое число)
     */
    private static int getAndCheckInputValueInt(String valueAnnotation) {
        System.out.println(valueAnnotation);

        int userInput = -1;
        if (in.hasNextInt()) {
            userInput = in.nextInt();
            if (userInput < 0) {
                System.out.println("Число должно быть больше нуля");
                userInput = -1;

            }
        } else {
            System.out.println("Значение должно быть целым числом");
        }

        return userInput;
    }

    /**
     * Проверка ввода пользователя(число с плавающей точкой)
     */
    private static float getAndCheckInputValueFloat(String valueAnnotation) {
        System.out.println(valueAnnotation);
        Scanner in = new Scanner(System.in);
        float userInput = -1;
        if (in.hasNextFloat()) {
            userInput = in.nextFloat();
            if (userInput < 0) {
                System.out.println("Число должно быть больше нуля");
                userInput = -1;

            }
        } else {
            System.out.println("Значение должно быть числом с плавающей точкой");
        }

        return userInput;
    }

    /**
     * Найти логарифм по основанию 2 от числа
     */
    private static float log2(float N) {
        return (float) (Math.log(N) / Math.log(2));
    }

    /**
     * Добавить пояснение к результату
     */
    private static String annotateResult(String nameOfTheOutput, float result) {
        return nameOfTheOutput + ": " + roundTo2(result);

    }

    /**
     * Вывести результат в консоль
     */
    private static void printResult(String result) {
        System.out.println(result);
    }


}