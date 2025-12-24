import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1_SecretEntrance {
    public static void run() throws FileNotFoundException {
        File f = new File("Day1_SecretEntrance.txt");
        Scanner s = new Scanner(f);
        String turn;
        int pos = 50;
        int passedZero = 0;
        int atZero = 0;
        int twist;
        while (s.hasNextLine()) {
            turn = s.nextLine();
            twist = Integer.parseInt(turn.substring(1));
            passedZero += twist / 100;
            twist %= 100;
            boolean fromZero = pos == 0;
            if (turn.charAt(0) == 'R') pos += twist;
            else pos -= twist;
            if (!fromZero && pos % 100 != 0 && (pos < 0 || pos > 99)) passedZero++;
            pos %= 100;
            if (pos == 0) atZero++;
            if (pos < 0) pos += 100;
        }
        System.out.println("Stops at zero: " + atZero);
        System.out.println("Passed zero: " + (passedZero + atZero));
    }
}
