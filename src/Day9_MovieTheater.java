import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day9_MovieTheater {
    public static void run() throws FileNotFoundException {
        File f = new File("Day9_MovieTheater.txt");
        Scanner s = new Scanner(f).useDelimiter(",|\\r?\\n");
        ArrayList<Integer> xcoords = new ArrayList<>();
        ArrayList<Integer> ycoords = new ArrayList<>();
        ArrayList<Long> areas = new ArrayList<>();
        while (s.hasNextInt()) {
            xcoords.add(s.nextInt());
            ycoords.add(s.nextInt());
        }
        // Part One:
        int size = xcoords.size();
        for (int i = 0; i < size - 1; i++) for (int j = i + 1; j < size; j++) {
            areas.add(((long) xcoords.get(i) - xcoords.get(j) + 1) * ((ycoords.get(i) - ycoords.get(j) + 1)));
        }
        System.out.println(Collections.max(areas));
        // Part Two:
        for (int i = 0; i < Collections.max(ycoords) + 1; i++) {
            for (int j = 0; j < Collections.max(xcoords) + 1; j++) {
                if (containslist(xcoords, ycoords, j, i)) System.out.print("#");
                else System.out.print(".");
            }
            System.out.println();
        }
    }
    public static boolean containslist(ArrayList<Integer> origxs, ArrayList<Integer> ys, int x, int y) {
        ArrayList<Integer> xs = new ArrayList<Integer>(origxs);
        while (xs.contains(x)) {
            if (ys.get(xs.indexOf(x)).equals(y)) return true;
            else xs.set(xs.indexOf(x), -1);
        }
        return false;
    }
}
