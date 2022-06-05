import java.util.Arrays;

/**
 * taskAdd01
 */
public class taskAdd01 {
    public static void main(String[] args) {
        printAllCombination(3, 2);
    }

    public static int[] allCombination (int[] combination, int n) {
        int i = combination.length - 1;
        for (; i > -1 && combination[i] >= n - 1;) {
            i=i-1;
        }
        if (i==-1) {
            return null;
        }

        combination[i] +=1;
        for (int j = i+1; j < combination.length; j++) {
            combination[j]=combination[i];
        }
        return combination;

    }

    public static void printAllCombination(int n, int k) {
        
        int[] combination =new int[k];
        for(;combination != null;){
            System.out.println(Arrays.toString(combination));
            combination=allCombination(combination, n);
        }
    }
}
