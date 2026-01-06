import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day9_MovieTheater {
    public static void run() throws FileNotFoundException {
        File f = new File("Day9_MovieTheater.txt");
        Scanner s = new Scanner(f).useDelimiter(",|\\r?\\n");
        ArrayList<List<Integer>> coords = new ArrayList<>();
        ArrayList<Long> areas = new ArrayList<>();
        while (s.hasNextInt()) coords.add(new List<Integer> {s.nextInt(), s.nextInt()});

        // Part One:
        int size = coords.size();
        List<Integer> point1;
        List<Integer> point2;
        for (int i = 0; i < size - 1; i++) for (int j = i + 1; j < size; j++) {
            point1 = coords.get(i);
            point2 = coords.get(j);
            areas.add(((long) point1.getFirst() - point2.getFirst() + 1) * ((point1.getLast() - point2.getLast() + 1)));
        }
        System.out.println(Collections.max(areas));

        for (int i = 0; i < Collections.max(coords, Comparator.comparingInt(a -> a[1]))[1]; i++) {
            for (int j = 0; j < Collections.max(coords, Comparator.comparingInt(a -> a[0]))[0]; j++) {
                if () {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println(coords.contains(new int[] {7, 1}));
        System.out.println(Arrays.equals(coords.getFirst(), new int[]{7, 1}));
        // Part Two:

    }
}
