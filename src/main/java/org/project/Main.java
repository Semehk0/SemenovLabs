package org.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Объявляем и инициализируем значения, которые ждем от пользователя
        double first = 0;
        double second = 0;
        double delta = 0;
        // Создаем объект сканера
        Scanner sc = new Scanner(System.in);
        // Читаем ввод от пользователя
        System.out.println("Первое значение: ");
        String firstInputString = sc.next();
        System.out.println("Второе значение: ");
        String secondInputString = sc.next();
        System.out.println("delta: ");
        String deltaXString = sc.next();

        // Объявляем переменную для определения валидности введенных данных
        boolean ok;
        try {
            // Преобразовывваем в double ввод от юзера
            first = Double.parseDouble(firstInputString);
            second = Double.parseDouble(secondInputString);
            delta = Double.parseDouble(deltaXString);
            // Определяем валидны ли данные
            ok = (delta > 0 && (first < second));
        } catch (NumberFormatException e) {
            // Ловим эксепшен (он может выбросится при неудаче преобразования строки в double)
            // В таком случае данные очевидно не валидны
            ok = false;
        }

        // Если данные валидны, можем начинать рисовать
        if (ok) {
            // Создаем счетчит для строк
            int temp = 1;
            // Рисуем заголовки
            System.out.println("------------------------------------------------------------");
            System.out.println("|№           |x                     |result                |");
            System.out.println("------------------------------------------------------------");
            // Переменная для формелы по варианту
            int num = 75;
            // Идем по диапазону от первого числа до второго с шагом delta
            for (double i = first; i <= second; i += delta) {
                // Считаем по формуле
                double a = (float) (Math.log((1 - num) / (Math.cos(i - num))) / Math.log(Math.abs(num / 10) + 4));
                double b = (float) (Math.sin(i) / num);
                double r = Math.min(a, b);
                // Выводим строку таблицы с форматированием
                System.out.printf("| %-10d | %-20s | %-20s |\n", temp, String.format("%.6f", i), String.format("%.6f", r));
                System.out.println("------------------------------------------------------------");
                // Увеличиваем счетчик
                temp++;
            }
        } else {
            // Если данные не валидны, оповещаем юзера об этом
            System.out.println("Недопустимый пользовательский ввод");
        }
    }
}