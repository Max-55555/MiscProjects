import java.util.Random;

public class CollectionSimulator {
    private final static int kDuplicateCost = 4;
    private final static int kTotalCollectionItems = 16;
    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 100; i++) {
//            Random random = new Random();
//            TimeUnit.SECONDS.sleep(1);
//            System.out.println(random.nextInt(16));
//        }
        double containerAVG = 0;
        for (int i = 0; i < 10000; i++) {
            Random random = new Random();
            int collection = 0;
            int container = 0;
            int duplicate = 0;
            while (collection + duplicate / kDuplicateCost < kTotalCollectionItems) {
                if (collection <= random.nextInt(kTotalCollectionItems)) {
                    collection++;
                } else {
                    duplicate++;
                }
                container++;
            }
            containerAVG += container;
        }
        System.out.println(containerAVG / 10000);
    }
}
