#Total number of possibilities
class HelloWorld {
    public static int formula(int n) {
        return n * n;
    }

    public static void main(String[] args) {
        int s, c = 0, n = 6;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                s = i + j;
                // System.out.println(i + "+" + j + "=" + s + " ");
                c++;
            }
        }
        System.out.println("Using for loop: " + c);
        System.out.println("Using formula: " + formula(n));
    }
}
