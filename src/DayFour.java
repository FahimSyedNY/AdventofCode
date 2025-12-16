import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class DayFour {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("DayFour.txt");
        Scanner s = new Scanner(f);
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        int[][] addList = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int count;
        int canMove = 1;
        int sum = 0;
        while (s.hasNextLine()) {
            list.add(new ArrayList<>(Arrays.asList(s.nextLine().split(""))));
        }
        int size = list.size();
        int length = list.getFirst().size();
        while (canMove > 0) {  // 1. Remove while loop-
            canMove = 0;
            for (int k = 0; k < size; k++) {
                for (int j = 0; j < length; j++) {
                    if (list.get(k).get(j).equals("@")) {
                        count = 0;
                        for (int i = 0; i < 8 && count < 4; i++) {
                            if (k + addList[i][0] > -1 && j + addList[i][1] > -1 && k + addList[i][0] < size && j + addList[i][1] < length) {
                                if (list.get(k + addList[i][0]).get(j + addList[i][1]).equals("@")) count++;
                            }
                        }
                        if (count < 4) {
                            canMove++;
                            list.get(k).set(j, "."); // 2. Remove set at index
                        }
                    }
                }
            }
            sum += canMove; // 3. and report canMove instead of sum to find Part 1
        }
        System.out.println(sum);
    }
}
