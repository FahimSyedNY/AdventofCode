import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class DayFour {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("DayFour.txt");
        Scanner s = new Scanner(f);
        ArrayList<String[]> list = new ArrayList<>();
        while (s.hasNextLine()) {
            list.add(s.nextLine().split(""));
        }
        for (String[] strings : list) {
            for (int j = 0; j < strings.length; j++) {
                // Implement check for surrounding here
            }
        }
    }
}
