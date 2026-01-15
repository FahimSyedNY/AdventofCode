import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day9_MovieTheater {
    public static void run() throws FileNotFoundException {
        File f = new File("Day9_MovieTheater.txt");
        Scanner s = new Scanner(f).useDelimiter(",|\\r?\\n");
        ArrayList<Integer> xcoords = new ArrayList<>();
        ArrayList<Integer> ycoords = new ArrayList<>();
        ArrayList<int[]> coords = new ArrayList<>();
        ArrayList<Long> areas = new ArrayList<>();
        while (s.hasNextInt()) {
            coords.add(new int[] {s.nextInt(), s.nextInt()});
        }
        coords.sort(Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));
        int size = coords.size();
        for (int[] coord : coords) {
            xcoords.add(coord[0]);
            ycoords.add(coord[1]);
        }
        // Part One:
        for (int i = 0; i < size - 1; i++) for (int j = i + 1; j < size; j++) {
            areas.add((Math.abs((long) xcoords.get(i) - xcoords.get(j)) + 1) * (Math.abs((ycoords.get(i) - ycoords.get(j)) + 1)));
        }
        System.out.println(areas);
        System.out.println(Collections.max(areas));
        // Part Two:
        Collections.sort(xcoords);
        int ind = 0;
        for (int i = 0; i < Collections.max(ycoords) + 1; i++) {
            for (int j = 0; j < Collections.max(xcoords) + 1; j++) {
                if (xcoords.get(ind) == j && ycoords.get(ind) == i) {
                    System.out.print("#");
                    ind++;
                }
                else System.out.print(".");
            }
            System.out.println();
        }
    }
    public static boolean containslist(ArrayList<Integer> origxs, ArrayList<Integer> ys, int x, int y) {
        ArrayList<Integer> xs = new ArrayList<>(origxs);
        while (xs.contains(x)) {
            if (ys.get(xs.indexOf(x)).equals(y)) return true;
            else xs.set(xs.indexOf(x), -1);
        }
        return false;
    }
}
