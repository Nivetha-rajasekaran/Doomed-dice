#doomed dice
  import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Main {

    static int totalCombination(List<Integer> a, List<Integer> b) {
        return a.size() * b.size();
    }

    static List<Integer> distribution(List<Integer> a, List<Integer> b) {
        int maxSize = Collections.max(a) + Collections.max(b) + 1;
        int[] res = new int[maxSize];
        Arrays.fill(res, 0);
        
        for (int i : a) {
            for (int j : b) {
                res[i + j]++;
            }
        }
        
        List<Integer> resultList = new ArrayList<>();
        for (int value : res) {
            resultList.add(value);
        }
        return resultList;
    }

    static int undoomDice(List<Integer> a, List<Integer> b, List<Double> probabilities) {
        if (Collections.max(a) + Collections.max(b) == 12) {
            List<Integer> dist = distribution(a, b);
            int len = totalCombination(a, b);
            for (int i = 0; i < dist.size(); i++) {
                if (dist.get(i) != 0) {
                    double currProb = dist.get(i) / (double) len;
                    if (probabilities.get(i) != currProb) {
                        return 0;
                    }
                }
            }
            return 1;
        }
        return 0;
    }

    static void findComb1(int index, List<Integer> temp1, List<Integer> a, List<List<Integer>> comb1) {
        if (temp1.size() == 6) {
            comb1.add(new ArrayList<>(temp1));
            return;
        }
        if (index < 0) {
            return;
        }
        for (int i = index; i >= 0; i--) {
            temp1.add(a.get(i));
            findComb1(i, temp1, a, comb1);
            temp1.remove(temp1.size() - 1);
        }
    }

    static void findComb2(int index, List<Integer> temp2, List<Integer> b, List<List<Integer>> comb2) {
        if (temp2.size() == 6) {
            comb2.add(new ArrayList<>(temp2));
            return;
        }
        if (index < 0) {
            return;
        }
        for (int i = index; i >= 0; i--) {
            temp2.add(b.get(i));
            findComb2(i - 1, temp2, b, comb2);
            temp2.remove(temp2.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 2, 3, 4);
        List<Integer> b = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        List<List<Integer>> comb1 = new ArrayList<>();
        List<List<Integer>> comb2 = new ArrayList<>();
        List<Double> probabilities = Arrays.asList(0.0, 0.0, 0.027777777777777776, 0.05555555555555555,
                0.08333333333333333, 0.1111111111111111, 0.1388888888888889, 0.16666666666666666,
                0.1388888888888889, 0.1111111111111111, 0.08333333333333333, 0.05555555555555555,
                0.027777777777777776);

        findComb1(a.size() - 1, temp1, a, comb1);
        findComb2(b.size() - 1, temp2, b, comb2);

        for (List<Integer> aComb1 : comb1) {
            for (List<Integer> bComb2 : comb2) {
                if (undoomDice(aComb1, bComb2, probabilities) == 1) {
                    System.out.println(aComb1);
                    System.out.println(bComb2);
                }
            }
        }
    }
}
