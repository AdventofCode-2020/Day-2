import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Advent2020_Day_2 {

    public static void main (String[] args) throws IOException {
        String fileName = "input";
        int result = getPassword(fileName);
        System.out.println(result);
    }

    public static int getPassword (String fileName) throws IOException {
        File file = new File(fileName);
        Scanner input = new Scanner(file);
        int result = 0;

        while (input.hasNext()) {
            String temp = input.nextLine();
            if (isValid(temp))
                result++;
        }
        return result;
    }

    public static boolean isValid(String password) {
        String[] arr = password.split(" ");
        String[] range = arr[0].split("-");
        int min = Integer.parseInt(range[0]);
        int max = Integer.parseInt(range[1]);
        char[] letter = arr[1].toCharArray();
        char key = letter[0];
        boolean result = getResult(max, min, key, arr[2]);
        return result;
    }

    public static boolean getResult(int max, int min, char key, String password) {
        boolean result = false;
        boolean minPosition = false;
        boolean maxPosition = false;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(min - 1) == key)
                minPosition = true;
            if (password.charAt(max - 1) == key)
                maxPosition = true;
        }
        if (maxPosition == true && minPosition == true)
            result = false;
        else if (maxPosition == true || minPosition == true)
            result = true;
        return result;
    }
}
