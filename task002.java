/**
 2.	На вход некоторому исполнителю подаётся два числа (a, b). У исполнителя есть две команды
- команда 1 (к1): увеличить в с раза, а умножается на c
- команда 2 (к2): увеличить на d ( +2 ), к a прибавляется d
написать программу, которая выдаёт набор команд, позволяющий число a превратить в число b или сообщить, что это невозможно
Пример 1: а = 1, b = 7, c = 2, d = 1
ответ: к1, к1, к1, к1, к1, к1 или к1, к2, к1, к1, к1 или к1, к1, к2, к1. 
Пример 2: а = 11, b = 7, c = 2, d = 1
ответ: нет решения. 

 */
public class task002 {

    public static void main(String[] args) {
        executor(1, 7, 1, 3, "");

    }

    public static void executor(int source, int target, int c, int d, String path) {
        if (source > target)
            return;
        if (source == target) {
            System.out.println(path);
            return;
        }
        executor(source + c, target, c, d, path + " K1");
        executor(source * d, target, c, d, path + " K2");
    }
}
