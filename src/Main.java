import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String result = calc((in.nextLine()));
        System.out.println(result);
    }

    public static String calc(String input) throws Exception {
        String resStr;
        String[] elements = input.split(" ");
        if (!(elements.length == 3)) {
            throw new Exception("Неудовлетворительный формат записи математической операции");
        }
        int res;
        char rimNum1 = elements[0].charAt(0);
        char rimNum2 = elements[2].charAt(0);
        if ((rimNum1 == 'I' || rimNum1 == 'V' || rimNum1 == 'X') && (rimNum2 == 'I' || rimNum2 == 'V' || rimNum2 == 'X')) {
            Roms convert = new Roms();
            int var1 = convert.toArabic(elements[0]);
            int var2 = convert.toArabic(elements[2]);
            switch (elements[1]) {
                case ("-") -> res = var1 - var2;
                case ("+") -> res = var1 + var2;
                case ("*") -> res = var1 * var2;
                case ("/") -> res = var1 / var2;
                default -> throw new Exception("Неподходящая арифметическая операция");
            }
            if (res > 0) {
                resStr = convert.toRoman(res);
            } else throw new Exception("В римской системе нет отрицательных чисел и 0");

        } else {
            int num1 = 0;
            int num2 = 0;
            try {
                num1 = Integer.parseInt(elements[0]);
                num2 = Integer.parseInt(elements[2]);
            } catch (NumberFormatException e) {
                System.out.println("Введите подходящее значение чисел");
            }

            if (!(0 < num1 && num1 < 11) || !(0 < num2 && num2 < 11)) {
                throw new Exception("Числа должны находиться в диапазоне от 1 до 10");
            }
            switch (elements[1]) {
                case ("-") -> res = num1 - num2;
                case ("+") -> res = num1 + num2;
                case ("*") -> res = num1 * num2;
                case ("/") -> res = num1 / num2;
                default -> throw new Exception("Неподходящая арифметическая операция");
            }
            resStr = String.valueOf(res);
        }
        return resStr;
    }


    static class Roms {
        int var;

        public int toArabic(String num) throws Exception {
            switch (num) {
                case ("I") -> var = 1;
                case ("II") -> var = 2;
                case ("III") -> var = 3;
                case ("IV") -> var = 4;
                case ("V") -> var = 5;
                case ("VI") -> var = 6;
                case ("VII") -> var = 7;
                case ("VIII") -> var = 8;
                case ("IX") -> var = 9;
                case ("X") -> var = 10;
                default -> throw new Exception("Число не находится в диапазоне от 1 до 10 или записано неправильно");
            }
            return var;

        }

        public String toRoman(int num) {
            int x;
            String romanNum = "";
            x = num / 10;
            switch (x) {
                case (1) -> romanNum = "X";
                case (2) -> romanNum = "XX";
                case (3) -> romanNum = "XXX";
                case (4) -> romanNum = "XL";
                case (5) -> romanNum = "L";
                case (6) -> romanNum = "LX";
                case (7) -> romanNum = "LXX";
                case (8) -> romanNum = "LXXX";
                case (9) -> romanNum = "XC";
                case (10) -> romanNum = "C";
            }
            x = num % 10;
            switch (x) {
                case (1) -> romanNum += "I";
                case (2) -> romanNum += "II";
                case (3) -> romanNum += "III";
                case (4) -> romanNum += "IV";
                case (5) -> romanNum += "V";
                case (6) -> romanNum += "VI";
                case (7) -> romanNum += "VII";
                case (8) -> romanNum += "VIII";
                case (9) -> romanNum += "IX";
            }
            return romanNum;
        }
    }
}