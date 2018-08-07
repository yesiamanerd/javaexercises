/**
 * Created by geoffrey on 2/14/18.
 */
public class ThisTest {
    public static void main(String[] args){
        SimpleTime time = new SimpleTime(15, 30, 19);
        System.out.println(time.buildString());
    }


}

class SimpleTime{
    private int hour;
    private int minute;
    private int second;

    public SimpleTime(int hour, int min, int sec){
        this.hour = hour;
        this.minute = min;
        this.second = sec;
    }

    public String buildString(){
        return String.format("%24s: %s%n%24s: %s",
                "this.toUniversalString()", this.toUniversalString(),
                "toUniversalString()", toUniversalString());
    }

    public String toUniversalString(){
        return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
    }
}