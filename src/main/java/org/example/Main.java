package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static File log;
    private static FileWriter fileWriter;
    static Scanner sc = new Scanner(System.in);


    public static void task1() {
        // Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

        LinkedList<Integer> LL = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            System.out.print("Введите число: ");
            while (!sc.hasNextInt()) {
                sc.next();
            }
            Integer inputInt = sc.nextInt();
            LL.add(inputInt);
        }
        System.out.print(LL);

        for (int i = 0; i < LL.size() - 1; i++) {
            int temp = 0;
            temp = LL.getFirst();
            LL.removeFirst();
            LL.add(LL.size() - i, temp);
        }
        sc.close();
        System.out.print(LL);
    }

    public static void task2() {
        // В калькулятор (урок 1 и 2) добавьте возможность отменить последнюю операцию.
        System.out.println("Введите число: ");
        Deque <String>array = new ArrayDeque<>();
        double sum = 0;
        Boolean isQuit = true;

        while (isQuit) {
            System.out.println("""
                    Выбирете действие:
                    1 - Калькулятор
                    2 - Показать предыдущее действие
                    3 - Выход
                    """);
            while (!sc.hasNextInt()) {
                sc.next();
            }
            int Ent = sc.nextInt();

            try {
                File log = new File("log.txt");
                FileWriter fileWriter = new FileWriter(log, true);
                switch (Ent) {
                    case 1 -> {
                        System.out.println("Введите число: ");
                        while (!sc.hasNextDouble()) {
                            sc.next();
                        }
                        double a = sc.nextDouble();
                        System.out.println("выберите действие: ");
                        while (!sc.hasNext("[-+/*]")) {
                            sc.next();
                        }
                        String zzz = sc.next();
                        System.out.println("Введите число: ");
                        while (!sc.hasNextDouble()) {
                            sc.next();
                        }
                        double b = sc.nextDouble();

                        switch (zzz) {
                            case "+" -> {
                                sum = (a + b);
                                System.out.println(sum);
                                String str = (a + zzz + b + "=" + sum);
                                array.push(str);
                                fileWriter.write(str + '\n');
                                break;
                            }
                            case "-" -> {
                                sum = (a - b);
                                System.out.println(sum);
                                String str = (a + zzz + b + "=" + sum);
                                array.push(str);
                                fileWriter.write(str + '\n');
                                break;
                            }
                            case "*" -> {
                                sum = (a * b);
                                System.out.println(sum);
                                String str = (a + zzz + b + "=" + sum);
                                array.push(str);
                                fileWriter.write(str + '\n');
                                break;
                            }
                            case "/" -> {
                                sum = (a / b);
                                System.out.println(sum);
                                String str = (a + zzz + b + "=" + sum);
                                array.push(str);
                                fileWriter.write(str + '\n');
                                break;
                            }
                        }
                        fileWriter.flush();
                        fileWriter.close();
                        System.out.print("\n");
                    }
                    case 2 -> {
                        System.out.print(array.poll() + "\n");
                        break;
                    }
                    case 3 -> {
                        System.exit(0);
                    }
                    default -> task2();
                }
            }
            catch (IOException ex){

            }

        }
    }
            public static void main (String[]args) throws IOException {
                // task1();
                task2();
            }

}