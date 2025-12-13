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
        while (s.hasNextLine()) {
            turn = s.nextLine();
            twist = Integer.parseInt(turn.substring(1));
            count += twist / 100; // Remove this line and
            twist %= 100;
            boolean fromZero = pos == 0;
            if (turn.charAt(0) == 'R') pos += twist;
            else pos -= twist;
            if (!fromZero && pos % 100 != 0 && (pos < 0 || pos > 99)) count++; // this line to find part 1
            pos %= 100;
            if (pos == 0) count++;
            if (pos < 0) pos += 100;
        }
        System.out.println(count);
    }
}
