import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class DayThree {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Day Three.txt");
        Scanner s = new Scanner(f);
        String[] list;
        int max = 0;
        while (s.hasNextLine()) {
            max = 0;
            list = s.nextLine().split("");
            for (int i = 0; i < list.length; i++) {
                if (Integer.parseInt(list[i]) > max) {
                    max = Integer.parseInt(list[i]); // Update max if a larger element is found
                }
            }
            System.out.println(max);
        }
    }
}