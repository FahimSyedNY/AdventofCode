import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class DayFive {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("DayFive.txt");
        Scanner s = new Scanner(f);
        ArrayList<String[]> list = new ArrayList<>();
        String[] nextLine;
        while (s.hasNextLine()) {
            nextLine = s.nextLine().split("-");
            list.add(nextLine);
        }
        System.out.println(list.size());
    }
}
