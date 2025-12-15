import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayTwo {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("DayTwo.txt");
        Scanner s = new Scanner(f);
        String[] list = s.nextLine().split(",");
        int[] factors;
        int pos;
        int dashInd;
        int size;
        long sum = 0;
        String num;
        boolean isInvalid;
        for (String str : list) {
            dashInd = str.indexOf('-');
            for (long j = Long.parseLong(str.substring(0, dashInd)); j <= Long.parseLong(str.substring(dashInd + 1)); j++) {
                num = j + "";
                size = num.length();
                factors = factors(size);
                isInvalid = false;
                for (int i = factors.length - 1; i >= 0; i--) {
                    pos = factors[i];
                    while (pos != size) {
                        if (!(num.substring(pos - factors[i], pos).equals(num.substring(pos, pos + factors[i])))) break;
                        else if (pos + factors[i] == size) {
                            sum += j;
                            isInvalid = true;
                        }
                        pos += factors[i];
                    }
                    if (isInvalid) break;
                }
            }
        }
        System.out.println(sum);
    }
    public static int[] factors(int n) {
        String factors = "1,";
        for (int i = 2; i <= n / 2; i++) if (n % i == 0) factors += i + ",";
        String[] stringArray = factors.split(",");
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) intArray[i] = Integer.parseInt(stringArray[i]);
        return intArray;
    }
}
