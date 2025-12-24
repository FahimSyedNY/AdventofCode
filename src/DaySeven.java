import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class DaySeven {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("DaySeven.txt");
        Scanner s = new Scanner(f);
        ArrayList<String[]> lists = new ArrayList<>();
        ArrayList<Integer> indicies = new ArrayList<>();
        ArrayList<Integer> buildindex = new ArrayList<>();
        indicies.add(s.nextLine().indexOf("S"));
        int count = 0;
        while (s.hasNextLine()) lists.add(s.nextLine().split(""));
        for (String[] list : lists) {
            for (int index : indicies) {
                if (list[index].equals("^")) {
                    count++;
                    if (!buildindex.contains(index - 1)) buildindex.add(index - 1);
                    if (!buildindex.contains(index + 1)) buildindex.add(index + 1);
                } else if (!buildindex.contains(index)) buildindex.add(index);
            }
            indicies = new ArrayList<>(buildindex);
            buildindex.clear();
        }
        System.out.println(count);
    }
}
