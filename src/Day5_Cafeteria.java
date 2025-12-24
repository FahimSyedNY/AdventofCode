import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

public class Day5_Cafeteria {
    public static void run() throws FileNotFoundException {
        File f = new File("Day5_Cafeteria.txt");
        Scanner s = new Scanner(f);
        ArrayList<Long[]> ranges = new ArrayList<>();
        String[] nextLine = s.nextLine().split("-");
        while (!nextLine[0].isEmpty()) {
            ranges.add(new Long[]{Long.parseLong(nextLine[0]), Long.parseLong(nextLine[1])});
            nextLine = s.nextLine().split("-");
        }

        // Part Two Code
        ranges.sort(Comparator.comparingLong(a -> (a[0])));
        long freshIds = 0;
        for (int i = 0; i < ranges.size() - 1; i++)
            if (ranges.get(i)[1] >= ranges.get(i + 1)[0] - 1) {
                if (ranges.get(i)[1] < ranges.get(i + 1)[1]) ranges.get(i)[1] = ranges.get(i + 1)[1];
                ranges.remove(i + 1);
                i--;
            }
        for (Long[] range : ranges) freshIds +=  range[1] - range[0] + 1;

        // Part One Code
        ArrayList<Long> ids = new ArrayList<>();
        int count = 0;
        while (s.hasNextLine()) ids.add(Long.parseLong(s.nextLine()));
        for (Long id : ids) for (Long[] range : ranges)
            if (id >= range[0] && id <= range[1]) {
                count++;
                break;
            }
        System.out.println("Fresh Stock: " + count);
        System.out.println("Fresh Ids: " + freshIds);
    }
}