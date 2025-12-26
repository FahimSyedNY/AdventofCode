import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day8_Playground {
    public static void run() throws FileNotFoundException {
        File f = new File("Day8_Playground.txt");
        Scanner s = new Scanner(f).useDelimiter(",|\\R");
        ArrayList<int[]> points = new ArrayList<>();
        ArrayList<Set<Integer>> circuits = new ArrayList<>();
        while (s.hasNext()) points.add(new int[]{s.nextInt(), s.nextInt(), s.nextInt()});
        int size = points.size();
        long[][] distances = new long[size * (size - 1) / 2][3];
        int idx = 0;
        for (int i = 0; i < size - 1; i++) for (int j = i + 1; j < size; j++) distances[idx++] =
                new long[]{distanceSquared(points.get(i), points.get(j)), i, j};
        Arrays.sort(distances, Comparator.comparingLong(a -> a[0]));
        for (int i = 0; i < idx; i++) {
            int ind1 = (int) distances[i][1];
            int ind2 = (int) distances[i][2];
            List<Set<Integer>> matches = new ArrayList<>();
            for (Set<Integer> circuit : circuits) if (circuit.contains(ind1) || circuit.contains(ind2)) matches.add(circuit);
            if (matches.isEmpty()) circuits.add(new HashSet<>() {{add(ind1); add(ind2);}}); // New circuit
            else if (matches.size() == 1) matches.getFirst().addAll(Set.of(ind1, ind2)); // Widen circuit
            else {
                // Merge circuits
                Set<Integer> merged = new HashSet<>();
                for (Set<Integer> match : matches) merged.addAll(match);
                circuits.removeAll(matches);
                merged.add(ind1);
                merged.add(ind2);
                circuits.add(merged);
            }
            if (i == 999) {
                ArrayList<Integer> sizes = new ArrayList<>();
                int max;
                int ans = 1;
                for (Set<Integer> circuit : circuits) sizes.add(circuit.size());
                for (int j = 0; j < 3; j++) {
                    max = Collections.max(sizes);
                    ans *= max;
                    sizes.remove((Integer) max);
                }
                System.out.println("Output after 1000 connections: " + ans);
            }
            if (circuits.size() == 1 && circuits.getFirst().size() == size) {
                System.out.println("Output after final connection: " + (long) points.get(ind1)[0] * points.get(ind2)[0]);
                break;
            }
        }
    }
    public static long distanceSquared(int[] point1, int[] point2) {
        int dx = point1[0] - point2[0];
        int dy = point1[1] - point2[1];
        int dz = point1[2] - point2[2];
        return (long) dx * dx + (long) dy * dy + (long) dz * dz;
    }
}
