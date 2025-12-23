import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class DaySix {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("DaySix.txt");
        Scanner s = new Scanner(f);
        ArrayList<String[]> list = new ArrayList<>();

        while (s.hasNextLine()) list.add(s.nextLine().trim().split("\\s+"));
        s.close();
        int size =  list.size();
        int length = list.get(0).length;
        Long tempsum;
        Long totalsum = 0L;
        for (int i = 0; i < length; i++) {
            tempsum = 0L;
            if (list.get(size - 1)[i].equals("+")) {
                for (int j = 0; j < size - 1; j++) {
                    tempsum += Long.parseLong(list.get(j)[i]);
                }
            } else {
                tempsum = 1L;
                for (int j = 0; j < size - 1; j++) {
                    tempsum *= Long.parseLong(list.get(j)[i]);
                }
            }
            System.out.println(tempsum);
            totalsum += tempsum;
        }
        System.out.println(totalsum);

        s = new Scanner(f);
        while (s.hasNextLine()) {
            list.add(s.nextLine().split(""));
        }

    }
}
