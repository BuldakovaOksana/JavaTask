/**
1. Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму. 
Пример 1: а = 3, b = 2, ответ: 9 
Пример 2: а = 2, b = -2, ответ: 0.25
Пример 3: а = 3, b = 0, ответ: 1
Пример 4: а = 0, b = 0, ответ: не определено
Пример 5
 */
public class task001 {
    public static void main(String[] args) {
        System.out.println(exponentiation(5, 3));
    }

    public static double exponentiation(double a, int b) {
        if (a == 0 || a == 1) {
            return a;
        }
        if (b == 0) {
            return 1;
        }
        if (b < 0) {
            b = -b;
            a = 1 / a;
        }

        double res = 1;
        for (int i = 0; i < b; i++) {
            res *= a;
        }
        return res;
    }

}