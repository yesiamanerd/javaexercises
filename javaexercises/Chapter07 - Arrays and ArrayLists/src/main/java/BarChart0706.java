public class BarChart0706 {
    public static void main(String[] args){
        int[] array = { 0, 0, 0, 0, 0, 0, 1, 2, 4, 2, 1 };

        System.out.printf("%nGrade Distribution%n");

        for(int counter = 0; counter < array.length; counter++){
            if(counter == 10)
                System.out.printf("%5d", 100);
            else
                System.out.printf("%2d-%2d", counter * 10, counter * 10 + 9);

            for(int stars = 0; stars < array[counter]; stars++)
                System.out.printf("%s", "*");
            System.out.println();
        }
    }
}
