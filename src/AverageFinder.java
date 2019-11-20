import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AverageFinder {

    public static void main(String[] args) throws FileNotFoundException {
        //input filepath of input file
        String filepath = "";

        File file = new File(filepath);
        Scanner scanner = new Scanner(file);
        int[] arr = new int[scanner.nextInt()];
        int[] presum = new int[arr.length + 1];

        //write array and  presum
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            presum[i + 1] = presum[i] + arr[i];
        }
        int[] query = new int[2];
        int len = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < len; i++) {
            String q = scanner.nextLine();
            query[0] = Integer.parseInt(q.split(" ")[0]);
            query[1] = Integer.parseInt(q.split(" ")[1]);
            System.out.println((presum[query[1]] - presum[query[0] - 1]) / (query[1] - query[0] + 1));
        }


    }
}