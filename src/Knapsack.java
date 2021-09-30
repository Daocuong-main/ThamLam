import java.util.Arrays;

public class Knapsack {

    static int valueAux = 0;    // added
    static int weightAux = 0;   // added
    static int[] weights = {12, 4, 2, 1, 1};
    static int[] values = {4, 10, 2, 2, 1};
    static int[] sol = new int[weights.length];
    static int[] finalSol = new int[weights.length];
    static int max = 15;
    public static void main(String[] args) {
        knapsack(0);    // removed the two parameters
        for (int i = 1; i < finalSol.length; i++) {
            System.out.println(finalSol[i] * weights[i]);
        }

    }

    public static void knapsack(int index) {  // removed the parameters
        sol[index] = -1;
        int n = weights.length;
        while (sol[index] < 1) {
            sol[index] = sol[index] + 1;
            if (sum(sol, weights) <= max && index == n - 1) {
                System.out.println("Sol: " + Arrays.toString(sol));
                System.out.println("weight = " + sum(sol, weights));
                update();
                System.out.println("*******************************");
            } else if (index < n - 1) {    // changed
                knapsack(index + 1);
            }
        }
    }

    private static int sum(int[] weights, int[] sol) {
        int res = 0;
        for (int i = 0; i < sol.length; i++) {
            if (sol[i] < 0 ) System.out.println("in sum: i = " + i + "   sol[i] = " + sol[i]);
            res += sol[i] * weights[i];
        }
        return res;
    }

    private static void update() {  //removed the two parameters

        int totalValue = 0;
        int totalWeight = 0;

        for (int i = 0; i < weights.length; i++) {
            if (sol[i] == 1) {
                totalValue += values[i];
                totalWeight += weights[i];
            }
        }

        if (totalValue > valueAux) {
            for (int i = 0; i < weights.length; i++) {
                finalSol[i] = sol[i];
            }
            valueAux = totalValue;
            weightAux = totalWeight;
            System.out.println("new valueAux: " + valueAux);   // changed
        }

    }
}