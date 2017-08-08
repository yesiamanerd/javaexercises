public class StudentPoll0708 {
    public static void main(String[] args){
        // student response array
        int[] responses = { 1, 2, 5, 4, 3, 5, 2, 1, 3, 3, 1, 4, 3, 3, 3,
                2, 3, 3, 2, 14 };

        int[] frequency = new int[6]; // array of frequeny counters

        // for each answer, select responses element and use that value
        // as frequency index to determine element to increment
        for(int answers = 0; answers < responses.length; answers++){
            try{
                ++frequency[responses[answers]];
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println(e);
                System.out.printf("     responses[%d] = %d%n%n",
                        answers, responses[answers]);
            }
        }

        System.out.printf("%s%10s%n", "Rating", "Frequency");

        // output each array elements value
        for(int rating = 1; rating < frequency.length; rating++){
            System.out.printf("%6d%10d%n", rating, frequency[rating]);
        }
    }
}
