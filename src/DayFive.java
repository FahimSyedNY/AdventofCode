import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class DayFive {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("DayFive.txt");
        Scanner s = new Scanner(f);
        ArrayList<String[]> ranges = new ArrayList<>();
        ArrayList<String> ids = new ArrayList<>();
        String[] nextLine = s.nextLine().split("-");
        while (!nextLine[0].isEmpty()) {
            ranges.add(nextLine);
            nextLine = s.nextLine().split("-");
        }
        while (s.hasNextLine()) {
            ids.add(s.nextLine());
        }
        System.out.println(ids.size());
    }
}
