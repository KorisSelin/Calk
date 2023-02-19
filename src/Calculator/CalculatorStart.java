package Calculator;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CalculatorStart {
    static int a;
    static int b;
    static String function;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();
        String[] words = string.split(" ");
        if (words.length != 3) {
            System.out.println("Не верная длинна выражения");
            return;
        }
        String s1 = words[0];
        function = words[1];
        String s3 = words[2];
        if (!chekMetod(s1, s3)) {
            System.out.println("Попробуйте ещё раз.");
            return;
        }

        int result = 0;
        switch (function) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                System.out.println("Выбрана не верная операция.");
        }

        if (NewEnum.containValue(s1) && result < 1) {
            throw new IOException("Римские цифры не могут быть меньше 1.");
        }
        try {
            NewEnum newEnumCheck = NewEnum.valueOf(s1);
            String enumString = newEnumCheck.toString();
            String rimsk = NewEnum.containNum(result);
            System.out.println(rimsk);
        } catch (IllegalArgumentException e) {
            System.out.println(result);
        }

    }

    public static boolean chekMetod(String s1, String s3) {
        try {
            if (NewEnum.containValue(s1) == NewEnum.containValue(s3)) {
            } else {
                System.out.println("Выражение должно быть либо римскими либо арабскими.");
                return false;
            }
            if (NewEnum.containValue(s1)) {
                a = NewEnum.valueOf(s1).getArab();
            } else {
                a = Integer.parseInt(s1);
            }
            if (NewEnum.containValue(s3)) {
                b = NewEnum.valueOf(s3).getArab();
            } else {
                b = Integer.parseInt(s3);
            }
        } catch (NumberFormatException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println("Не верно выбоано число.");
            return false;

        }
        if (a >= 1 && a <= 10 && b >= 1 && b <= 10) {

        } else {
            System.out.println("Введено не правильное число.");
            return false;
        }
        return true;
    }
}