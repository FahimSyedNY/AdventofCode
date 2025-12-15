import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class DayFour {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("DayFour.txt");
        Scanner s = new Scanner(f);
        ArrayList<String[]> list = new ArrayList<>();
        int[][] addList = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int count;
        int canMove = 0;
        while (s.hasNextLine()) {
            list.add(s.nextLine().split(""));
        }
        for (int k = 0; k < list.size(); k++) {
            for (int j = 0; j < list.get(k).length; j++) {
                count = 0;
                if (!(list.get(k)[j].equals("@"))) break;
                for (int i = 0; i < 8 && count < 4; i++) {
                    if (k + addList[i][0] > -1 && j + addList[i][1] > -1 && k + addList[i][0] < list.size() && j + addList[i][1] < list.get(k).length) {
                        if (list.get(k + addList[i][0])[j + addList[i][1]].equals("@")) count++;
                    }
                }
                if (count < 4) canMove++;
            }
        }
        System.out.println(canMove);
        for (String[] string : list) {
            for (int i = 0; i < string.length; i++) {
                System.out.print(string[i]);
            }
            System.out.println();
        }
    }
}
