import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DayThree {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(anyDigit(2));
        System.out.println(anyDigit(12));
    }

    public static long anyDigit(int length) throws FileNotFoundException {
        File f = new File("DayThree.txt");
        Scanner s = new Scanner(f);
        ArrayList<String> list;
        ArrayList<String> templist;
        int index;
        int size;
        long sum = 0;
        String voltage;
        String max;
        while (s.hasNextLine()) {
            list = new ArrayList<>(Arrays.asList(s.nextLine().split("")));
            templist = new ArrayList<>(list);
            size = templist.size();
            voltage = "";
            int i = length;
            while (voltage.length() < length) {
                max = Collections.max(templist);
                index = templist.indexOf(max);
                if (index <= size - i) {
                    voltage += max;
                    templist = new ArrayList<>(list);
                    Collections.fill(templist.subList(0, index + 1), "0");
                    i--;
                } else templist.set(index, "0");
            }
            sum += Long.parseLong(voltage);
        }
        return sum;
    }
}