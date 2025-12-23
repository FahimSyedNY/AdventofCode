import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class DaySix {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("DaySix.txt");
        Scanner s = new Scanner(f);
        ArrayList<String[]> list = new ArrayList<>();

        //Part One
        while (s.hasNextLine()) list.add(s.nextLine().trim().split("\\s+"));
        int size =  list.size();
        int length = list.getFirst().length;
        long tempsum;
        long totalsum = 0L;
        for (int i = 0; i < length; i++) {
            tempsum = 0L;
            if (list.get(size - 1)[i].equals("+")) for (int j = 0; j < size - 1; j++) tempsum += Long.parseLong(list.get(j)[i]);
            else {
                tempsum = 1L;
                for (int j = 0; j < size - 1; j++) tempsum *= Long.parseLong(list.get(j)[i]);
            }
            totalsum += tempsum;
        }
        System.out.println("Read like human: " + totalsum);

        //Part Two
        s = new Scanner(f);
        list = new ArrayList<>();
        String num;
        totalsum = 0;
        while (s.hasNextLine()) list.add(s.nextLine().split(""));
        length = list.getFirst().length;
        ArrayList<String> terms = new ArrayList<>();
        for (int i = length - 1; i >= 0; i--) {
            num = "";
            for (int j = 0; j < size - 1; j++) num += list.get(j)[i].trim();
            terms.add(num);
            if (list.get(size - 1)[i].equals("+")) {
                tempsum = 0L;
                for (String term : terms) tempsum += Integer.parseInt(term);
                terms = new ArrayList<>();
                totalsum += tempsum;
                i--;
            }
            if (list.get(size - 1)[i].equals("*")) {
                tempsum = 1L;
                for (String term : terms) tempsum *= Integer.parseInt(term);
                terms = new ArrayList<>();
                totalsum += tempsum;
                i--;
            }
        }
        System.out.println("Read like cephalopod: " + totalsum);
    }
}
