import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DayThree {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(anyDigit(12));
        System.out.println(twoDigit());
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
            while(voltage.length() < length) {
                max = Collections.max(templist);
                index = templist.indexOf(max);
                if (index <= size - i) {
                    voltage += max;
                    templist = new ArrayList<>(list);
                    Collections.fill(templist.subList(0, index + 1), "0");
                    i--;
                }
                else templist.set(index, "0");
            }
            sum += Long.parseLong(voltage);
        }
        return sum;
    }
    public static int twoDigit() throws FileNotFoundException {
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
        return sum;
    }
}