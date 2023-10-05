import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


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
        Scanner in = new Scanner(System.in);
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

    //////=========================================================
    // Задание 1
    /////==========================================================

    /**
     * Потенциальный объем программы (задание 1)
     */
    //
    private static float estimatedCodeVolume(int n2) {
        float result = (n2 + 2) * log2(n2 + 2);
        return result;
    }

    /**
     * Потенциальное число ошибок (задание 1)
     */
    private static float estimatedNumberOfErrors(float estimatedCodeVolume, float programmingLanguageTier) {
        return (float) Math.pow(estimatedCodeVolume, 2) / (3000 * programmingLanguageTier);
    }

    /**
     * Задание №1
     */
    private static void task1() {
        int minimalDifferentOperandsNumber =
                getAndCheckInputValueInt("Введите минимальное число различных операндов (для задачи = 6060)");
        float programmingLanguageTier =
                getAndCheckInputValueFloat("Введите уровень языка программирования (для задачи =  1,53)");
        if (!(minimalDifferentOperandsNumber == -1) && !(programmingLanguageTier == -1)) {

            float estimatedCodeVolumeValue = estimatedCodeVolume(minimalDifferentOperandsNumber);
            float estimatedNumberOfErrorsValue = estimatedNumberOfErrors(estimatedCodeVolumeValue, programmingLanguageTier);
            String estimatedCodeVolumeValueAnnotated =
                    annotateResult("Потенциальный объем программы", estimatedCodeVolumeValue);
            String estimatedNumberOfErrorsValueAnnotated =
                    annotateResult("Потенциальное число ошибок", estimatedNumberOfErrorsValue);
            printResult(estimatedCodeVolumeValueAnnotated);
            printResult(estimatedNumberOfErrorsValueAnnotated);
        }
    }

    public static void main(String[] args) {
        task1();
    }


}

