import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayTwo {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("DayTwo.txt");
        Scanner s = new Scanner(f);
        String[] list = s.nextLine().split(",");
        int dashInd;
        int size;
        long sum = 0;
        String num;
        for (String string : list) {
            dashInd = string.indexOf('-');
            for (long j = Long.parseLong(string.substring(0, dashInd)); j <= Long.parseLong(string.substring(dashInd + 1)); j++) {
                num = j + "";
                size = num.length();
                if (size % 2 == 0 && num.substring(0, size / 2).equals(num.substring(size / 2))) sum += j;
            }
        }
        System.out.println(sum);
    }
}
