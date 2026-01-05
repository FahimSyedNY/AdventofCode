import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day9_MovieTheater {
    public static void run() throws FileNotFoundException {
        File f = new File("Day9_MovieTheater.txt");
        Scanner s = new Scanner(f).useDelimiter(",|\\r?\\n");
        ArrayList<int[]> coords = new ArrayList<>();
        ArrayList<Long> areas = new ArrayList<>();
        while (s.hasNextInt()) coords.add(new int[] {s.nextInt(), s.nextInt()});
        int size = coords.size();
        int[] point1;
        int[] point2;
        for (int i = 0; i < size - 1; i++) for (int j = i + 1; j < size; j++) {
            point1 = coords.get(i);
            point2 = coords.get(j);
            areas.add( Math.abs(((long) (point1[0] - point2[0] + 1)) * ((point1[1] - point2[1] + 1))));
        }
        System.out.println(Collections.max(areas));
    }
}
