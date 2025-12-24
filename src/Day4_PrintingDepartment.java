import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day4_PrintingDepartment {
    public static void run() throws FileNotFoundException {
        File f = new File("Day4_PrintingDepartment.txt");
        Scanner s = new Scanner(f);
        ArrayList<String[]> list = new ArrayList<>();
        int[][] addList = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int count;
        int canMove = 1;
        int firstIteration = 0;
        int sum = 0;
        while (s.hasNextLine()) list.add(s.nextLine().split(""));
        int size = list.size();
        int length = list.getFirst().length;
        while (canMove > 0) {
            canMove = 0;
            for (int k = 0; k < size; k++) for (int j = 0; j < length; j++)
                if (list.get(k)[j].equals("@")) {
                    count = 0;
                    for (int i = 0; i < 8 && count < 4; i++) {
                        if (k + addList[i][0] > -1 && j + addList[i][1] > -1 && k + addList[i][0] < size && j + addList[i][1] < length)
                            if (list.get(k + addList[i][0])[j + addList[i][1]].equals("@")) count++;
                    }
                    if (count < 4) {
                        canMove++;
                        if (sum != 0) list.get(k)[j] = ".";
                    }
                }
            if (sum == 0) firstIteration = canMove;
            sum += canMove;
        }
        System.out.println("First Iteration Accessibility: " + firstIteration);
        System.out.println("Total Accessible: " + (sum - firstIteration));
    }
}
