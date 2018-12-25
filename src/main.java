import java.util.Scanner;

import static jdk.nashorn.internal.objects.NativeString.trim;

public class main {


    //1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args) {

        chooseMenu();

    }

    private static void chooseMenu() {
        int respoint2;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Здравствуйте!\nВыберите одно из заданий для проверки:");
        System.out.println("1: Создать пустой проект в IntelliJ IDEA");
        System.out.println("2: Инициализация переменных");
        System.out.println("3: Написать метод вычисляющий выражение a * (b + (c / d))");
        System.out.println("4: Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20");
        System.out.println("5: Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное ли число передали или отрицательное");
        System.out.println("6: Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true");
        System.out.println("7: Написать метод, которому в качестве параметра передается строка, обозначающая имя");
        System.out.println("8: Написать метод, который определяет является ли год високосным");
        System.out.println("9: Выход");
        System.out.print("Введите номер меню: ");
        int input_number = scanner.nextInt();

        if (input_number < 1 || input_number > 9) {
            outputError("Такого пнукта в меню нет", true);
            return;
        }
        int a;
        int b;
        int c;
        int d;
        boolean res;
        String astr;
        switch (input_number) {
            case 1:
                outputError("Если вы видите эти надписи, значит класс то создан уже!", false);
                break;
            case 2:
                initAll();
                outputError("Я только что инициализировал кучу переменных, но вы этого не увидите :(", false);
                break;
            case 3:
                System.out.println("Введите 4 целый числа одной стройкой через запятую!");
                scanner.nextLine();
                String input_string = scanner.nextLine();
                String[] ressplit = input_string.split(",");
                if (ressplit.length != 4) {
                    outputError("Просили же 4 целых числа, разделенных запятыми!", true);
                    break;
                }
                a = Integer.parseInt(trim(ressplit[0]));
                b = Integer.parseInt(trim(ressplit[1]));
                c = Integer.parseInt(trim(ressplit[2]));
                d = Integer.parseInt(trim(ressplit[3]));
                respoint2 = point3lesson(a, b, c, d);
                outputError("" + a + " * (" + b + " + (" + c + " / " + d + ")) = " + respoint2, false);
                break;
            case 4:

                System.out.println("Введите 2 целых числа подряд, нажимая \"Ввод\" после каждого числа.");
                a = scanner.nextInt();
                b = scanner.nextInt();
                res = point4lesson(a, b);
                outputError("Ответ на вопрос, находится ли число между 10 и 20: " + res, false);
                break;
            case 5:
                System.out.println("Введите целое число.");
                a = scanner.nextInt();
                System.out.print("Это число ");
                point5lesson(a);
                outputError("", false);
                break;
            case 6:
                System.out.println("Введите целое число.");
                a = scanner.nextInt();
                res = point6lesson(a);
                outputError("Это число отрицательное? Ответ: " + res, false);
                break;
            case 7:
                System.out.println("Введите своё имя:");
                scanner.nextLine();
                astr = scanner.nextLine();
                point7lesson(astr);
                outputError("", false);
                break;
            case 8:
                System.out.println("Введите год для определния високосности:");
                a = scanner.nextInt();
                point8lesson(a);
                outputError("", false);
                break;
            case 9:
                System.out.print("Досвидания!");
                break;
        }

        scanner.close();

    }

    private static void outputError(String string, boolean errore) {

        if (string != "") {
            System.out.println(string);
        }
        System.out.println("\n\n\n\n\n");
        if (errore) {
            System.out.println("Будте внимательнее! И попробуйте еще раз!");
        } else {
            System.out.println("Превосходно!!\nВыберите новое задание!");
        }
        chooseMenu();
    }

    //8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    private static void point8lesson(int year) {
        boolean check1;
        boolean check2;
        boolean check3;
        String res = "Год " + year;
        check1 = year % 4 == 0;
        check2 = year % 100 != 0;
        check3 = year % 400 == 0;

        if (check1 && (check2 || check3)) {
            res += " високосный";
        } else {
            res += " не високосный";
        }
        System.out.println(res);
    }

    //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
    // метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    private static void point7lesson(String user_name) {
        System.out.println("Привет, " + user_name + "!");
    }

    //6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
    private static boolean point6lesson(int i) {
        if (i < 0) {
            return true;
        } else {
            return false;
        }
    }

    //5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное ли число передали
    // или отрицательное; Замечание: ноль считаем положительным числом.
    private static void point5lesson(int i) {
        boolean res = point6lesson(i);
        String textres;
        if (!res) {
            textres = "положительное";
        } else {
            textres = "отрицателное";
        }
        System.out.println(textres);
    }

    //4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
    // если да – вернуть true, в противном случае – false;
    private static boolean point4lesson(int a, int b) {
        if ((a + b >= 10) && (a + b <= 20)) {
            return true;
        } else {
            return false;
        }
    }

    //3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
    private static int point3lesson(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    //2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
    private static void initAll() {
        byte _Byte;
        short _short;
        int _int;
        long _long;
        float _float;
        double _double;
        boolean _boolean;
        char _char;


        _Byte = 2;
        _short = 222;
        _int = 222222;
        _long = 222222222L;
        _float = 2.8f;
        _double = 2.22222;
        _boolean = true;
        _char = 'd';

    }
}




