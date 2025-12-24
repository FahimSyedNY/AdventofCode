import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day7_Laboratories {
    public static void run() throws FileNotFoundException {
        File f = new File("Day7_Laboratories.txt");
        Scanner s = new Scanner(f);
        ArrayList<String[]> lists = new ArrayList<>();
        ArrayList<Integer> indicies = new ArrayList<>();
        ArrayList<Integer> buildIndex = new ArrayList<>();
        indicies.add(s.nextLine().indexOf("S"));
        while (s.hasNextLine()) lists.add(s.nextLine().split(""));
        long[] freq = new long[lists.getFirst().length];
        int splits = 0;
        long timelines = 1;
        freq[indicies.getFirst()] = 1;
        for (String[] list : lists) {
            for (int index : indicies) {
                if (list[index].equals("^")) {
                    splits++;
                    timelines += freq[index];
                    freq[index - 1] += freq[index];
                    freq[index + 1] += freq[index];
                    freq[index] = 0;
                    buildIndex.add(index - 1);
                    buildIndex.add(index + 1);
                } else if (!buildIndex.contains(index)) buildIndex.add(index);
            }
            indicies = new ArrayList<>(buildIndex);
            buildIndex.clear();
        }
        System.out.println("Tachyon Splits: " + splits);
        System.out.println("Tachyon Timelines: " + timelines);
    }
}
