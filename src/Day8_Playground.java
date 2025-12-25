import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day8_Playground {
    public static void run() throws FileNotFoundException {
        File f = new File("Day8_Playground.txt");
        Scanner s = new Scanner(f).useDelimiter(",|\\R");
        ArrayList<int[]> points = new ArrayList<>();
        ArrayList<Set<Integer>> circuits = new ArrayList<>();
        int ans = 1;
        while (s.hasNext()) points.add(new int[]{s.nextInt(), s.nextInt(), s.nextInt()});
        int size = points.size();
        double[][] distances = new double[size * (size - 1) / 2][3];
        int index = 0;
        for (int i = 0; i < size - 1; i++) for (int j = i + 1; j < size; j++) distances[index++] = new double[]{distance(points.get(i), points.get(j)), i, j};
        Arrays.sort(distances, Comparator.comparingDouble(a -> a[0]));
        List<Set<Integer>> matches = new ArrayList<>();
        for (int i = 0; i < size / 2; i++) {
            int ind1 = (int) distances[i][1];
            int ind2 = (int) distances[i][2];
            matches.clear();
            for (Set<Integer> circuit : circuits) if (circuit.contains(ind1) || circuit.contains(ind2)) matches.add(circuit);
            if (matches.isEmpty()) {
                // New circuit
                circuits.add(new HashSet<>() {{add(ind1); add(ind2);}});
                System.out.println("New Circuit");
            } else if (matches.size() == 1) {
                // Widen circuit
                matches.getFirst().add(ind1);
                matches.getFirst().add(ind2);
                System.out.println("Widened Circuit");
            } else {
                // Merge circuits
                Set<Integer> merged = new HashSet<>();
                for (Set<Integer> match : matches) {
                    merged.addAll(match);
                    circuits.remove(match);
                }
                merged.add(ind1);
                merged.add(ind2);
                circuits.add(merged);
                System.out.println("Conjoined " + matches.size() + " Circuits");
            }
        }
        ArrayList<Integer> sizes = new  ArrayList<>();
        int max;
        for (Set<Integer> circuit : circuits) sizes.add(circuit.size());
        System.out.println(sizes);
        for (int i = 0; i < 3; i++) {
            max = Collections.max(sizes);
            ans *= max;
            sizes.remove((Integer) max);
        }
        System.out.println(ans);
    }
    public static double distance(int[] point1, int[] point2) {
        double x = Math.pow((point1[0] - point2[0]), 2);
        double y = Math.pow((point1[1] - point2[1]), 2);
        double z = Math.pow((point1[2] - point2[2]), 2);
        return Math.sqrt(x + y + z);
    }
}
