public class EnhancedForStatement0712 {
    public static void main(String[] args){
        int[] array = { 87, 68, 94, 100, 83, 78, 85, 91, 76, 87 };
        int total = 0;

        // add each element to total
        for(int number : array)
            total += number;

        System.out.printf("Total of elements in array: %d", total);
    }
}
