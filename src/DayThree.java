import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DayThree {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("DayThree.txt");
        Scanner s = new Scanner(f);
        ArrayList<String> list;
        String max;
        String max2;
        int index;
        int sum = 0;
        while (s.hasNextLine()) {
            list = new ArrayList<>(Arrays.asList(s.nextLine().split("")));
            max = Collections.max(list);
            index = list.indexOf(max);
            list.set(index, "0");
            max2 = Collections.max(list);
            if (list.indexOf(max2) > index) sum += Integer.parseInt(max + max2);
            else {
                if (list.size() == index + 1) sum += Integer.parseInt(max2 + max);
                else {
                    list.subList(0, index).clear();
                    sum += Integer.parseInt(max + Collections.max(list));
                }
            }
        }
        System.out.println(sum);
    }
}