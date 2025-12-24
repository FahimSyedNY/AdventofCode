import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2_GiftShop {
    public static void run() throws FileNotFoundException {
        File f = new File("Day2_GiftShop.txt");
        Scanner s = new Scanner(f);
        String[] list = s.nextLine().split(",");
        int dashInd;
        int size;
        long simpleSum = 0;
        long complexSum = 0;
        String num;
        for (String str : list) {
            dashInd = str.indexOf('-');
            for (long j = Long.parseLong(str.substring(0, dashInd)); j <= Long.parseLong(str.substring(dashInd + 1)); j++) {
                num = j + "";
                size = num.length();
                if (size % 2 == 0 && num.indexOf(num.substring(size / 2)) == 0) simpleSum += j;
                if ((num + num).indexOf(num, 1) < size) complexSum += j;
            }
        }
        System.out.println("Simple Repetition: " + simpleSum);
        System.out.println("Complex Repetition: " + complexSum);
    }
}
