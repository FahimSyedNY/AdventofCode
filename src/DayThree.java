import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class DayThree {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("DayThree.txt");
        Scanner s = new Scanner(f);
        ArrayList<String> list;
        String max = "";
        String max2 = "";
        int index;
        while (s.hasNextLine()) {
            list = new ArrayList<>(Arrays.asList(s.nextLine().split("")));
            max = Collections.max(list);
            index = list.indexOf(max);
            list.set(index, "0");
            max2 = Collections.max(list);
            if (list.indexOf(max2) > index) System.out.println(max + max2);
            if (list.indexOf(max2) < index) {
                if (Integer.parseInt(max2) > Integer.parseInt(max)) System.out.println(max2 + max);
                // Use list.subList(1, 4).clear()
            }
        }
    }
}