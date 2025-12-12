import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayOne {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("DayOne.txt");
        Scanner s = new Scanner(f);
        String turn;
        int pos = 50;
        int count = 0;
        int twist;
        int sign = 1;
        while (s.hasNextLine()) {
            turn = s.nextLine();
            twist = Integer.parseInt(turn.substring(1));
            count += twist / 100;
            twist %= 100;
            sign = Integer.compare(pos, 0);
            if (turn.charAt(0) == 'R') {
                pos += twist;
                if (Integer.compare(pos, 0) != sign) count++;
            }
            else {
                pos -= twist;
                if (Integer.compare(pos, 0) != sign) count++;
            }
            if (pos % 100 == 0) count++;
        }
        System.out.println(count);
    }
}
