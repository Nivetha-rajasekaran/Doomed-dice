#probabilities
  import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void printProbability(int n) {
        int[][] dice = new int[n][n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dice[i - 1][j - 1] = i + j;
            }
        }

        int total = n * n;
        Map<Integer, Double> probability = new HashMap<>();
        for (int i = 2; i <= (n * 2); i++) {
            int occur = 0;
            for (int[] row : dice) {
                for (int value : row) {
                    if (value == i) {
                        occur++;
                    }
                }
            }
            probability.put(i, (double) occur / total);
        }

        System.out.println("Probability of all sums:");
        for (Map.Entry<Integer, Double> entry : probability.entrySet()) {
            System.out.printf("P(%d): %.3f%n", entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        printProbability(6); // You can change the number of sides of the dice here
    }
}
