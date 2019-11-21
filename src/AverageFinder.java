import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AverageFinder {

    public static void main(String[] args) {
        //input filepath of input file
        String filepath = "";

        File file = new File(filepath);
        Scanner scanner;
        try {
            //try to find file
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            //if no file is found, use input from terminal
            scanner = new Scanner(System.in);
        }

        int length = scanner.nextInt();
        double[] prefixsum = new double[length + 1];

        //write array and  presum
        for (int i = 0; i < length; i++) {
            prefixsum[i + 1] = prefixsum[i] + scanner.nextDouble();
        }
        int[] query = new int[2];
        int queryLength = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < queryLength; i++) {
            //take queries split into an int array
            String q = scanner.nextLine();
            query[0] = Integer.parseInt(q.split(" ")[0]);
            query[1] = Integer.parseInt(q.split(" ")[1]);
            //find average from subtracting prefix sums
            double average = (prefixsum[query[1]] - prefixsum[query[0] - 1]) / (query[1] - query[0] + 1);
            //round to the nearest thousandths
            System.out.println((double) Math.round(average * 1000) / 1000);
        }
    }
}
