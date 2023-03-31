package arrays5;

import java.util.Scanner;
public class Pairs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] arr = new String[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = input.nextLine();
        }
        //arr.length = 8
        String pairs = "";

        for (int i = 0; i < arr.length - 1; i++) {
            pairs += arr[i] + ", " + arr[i + 1] + "\n";
        }
        System.out.print(pairs);
    }
}
