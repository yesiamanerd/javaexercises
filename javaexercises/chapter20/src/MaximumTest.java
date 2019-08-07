public class MaximumTest {
    public static void main(String[] args) {
        System.out.printf("The maximum value of %d, %d, and %d is %d%n",
                3, 4, 5, maximum(3, 4, 5));
        System.out.printf("The maximum value of %.1f, %.1f, and %.1f is %.1f%n",
                6.6, 7.7, 8.8, maximum(6.6, 7.7, 8.8));
        System.out.printf("The maximum value of %s, %s, and %s is %s%n",
                "apple", "orange", "pear", maximum("apple", "orange", "pear"));
    }

    private static <T extends Comparable<T>> T maximum(T x, T y, T z){
        T max = x;

        if(y.compareTo(max) > 0)
            max = y;
        if(z.compareTo(max) > 0)
            max = z;

        return max;

    }
}
