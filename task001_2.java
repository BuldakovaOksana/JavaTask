/**
 * 1.	Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму. 
 * Пример 1: а = 3, b = 2, ответ: 9 
Пример 2: а = 2, b = -2, ответ: 0.25
Пример 3: а = 3, b = 0, ответ: 1
Пример 4: а = 0, b = 0, ответ: не определено
Пример 5

 */
public class task001_2 {

    public static void main(String[] args) {
        System.out.println(powRec(2, 512));
    }

   public static double powRec(double a, int b) {
       if (b==0) {
           return 1;
       }
       if (b<0) {
           return powRec(1/a, -b);
       }
       double res=powRec(a, b/2);
       return b%2==0? res*res :res*res*a;
   }
}
