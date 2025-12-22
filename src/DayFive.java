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
        ArrayList<String[]> checkedRanges = new ArrayList<>();
        int count = 0;
        long fresh = 0;
        String[] nextLine = s.nextLine().split("-");
        while (!nextLine[0].isEmpty()) {
            ranges.add(nextLine);
            nextLine = s.nextLine().split("-");
        }
//        while (s.hasNextLine()) {
//            ids.add(s.nextLine());
//        }
//        for (String id : ids) {
//            for (String[] range : ranges) {
//                if (Long.parseLong(id) >= Long.parseLong(range[0]) && Long.parseLong(id) <= Long.parseLong(range[1])) {
//                    count++;
//                    break;
//                }
//            }
//        }
//        System.out.println(count);
        for (String[] range : ranges) {
            for (String[] checkedRange : checkedRanges) {
                checkedRanges.add(range);
                if (Long.parseLong(range[0]) >= Long.parseLong(checkedRange[0]) && Long.parseLong(range[0]) <= Long.parseLong(checkedRange[1])) {
                    range[0] = Long.parseLong(checkedRange[1]) + 1 + "";
                    if (Long.parseLong(range[0]) > Long.parseLong(range[1])) break;
                    fresh += Long.parseLong(range[1]) - Long.parseLong(range[0]) + 1;
                }
                if (Long.parseLong(range[1]) >= Long.parseLong(checkedRange[0]) && Long.parseLong(range[1]) <= Long.parseLong(checkedRange[1])) {
                    range[1] = Long.parseLong(checkedRange[0]) - 1 + "";
                    if (Long.parseLong(range[1]) < Long.parseLong(range[0])) break;
                    fresh += Long.parseLong(range[1]) - Long.parseLong(range[0]) + 1;
                }
            }
        }
        System.out.println(fresh);
    }
}
