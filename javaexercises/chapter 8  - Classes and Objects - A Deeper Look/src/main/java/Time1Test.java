/**
 * Created by geoffrey on 2/13/18.
 */
public class Time1Test {
    public static void main(String[] args){
        Time1 time = new Time1();

        display("After time object is created.", time);

        time.setTime(13, 27, 6);
        display("After setting time:", time);
        System.out.println();

        try
        {
            time.setTime(99,99, 99);
        }
        catch(IllegalArgumentException e)
        {
            System.out.printf("Exception: %s%n%n", e.getMessage());
        }

        display("After calling setTime with invalid values.", time);
    }

    private static void display(String s, Time1 time) {
        System.out.printf("%s%nUniversal time: %s%nStandard time: %s%n%n",
                s, time.toUniversalString(), time.toString());
    }
}
