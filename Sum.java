#Sum
  class HelloWorld {
    public static void main(String[] args) {
        int s, n = 6;
        System.out.println("All Possible Distributions");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                s = i + j;
                System.out.print(i + "+" + j + "=" + s + " ");
            }
            System.out.println();
        }
    }
}
