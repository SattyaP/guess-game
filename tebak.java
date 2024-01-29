import java.util.Random;
import java.util.Scanner;

public class tebak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] range = {0, 100};

        while (true) {
            System.out.print("Sudah siap untuk bermain ? (Y/T) : ");
            String ready = scanner.nextLine();
            if (!ready.equals("") && !ready.toLowerCase().equals("y")) {
                continue;
            }

            System.out.println("Tentukan angka mu dari 0 - 100!");
            int rangeMin = range[0];
            int rangeMax = range[1];
            boolean finish = false;

            while (!finish) {
                // System.out.println(rangeMin + " " + rangeMax);

                if (rangeMax - rangeMin <= range[0]) {
                    finish = true;
                    break;
                }

                int randomGuessNumber = 0;
                if (rangeMax - rangeMin < 3) {
                    randomGuessNumber = rangeMin;
                } else {
                    randomGuessNumber = (int) (Math.random() * (rangeMax - rangeMin - 1) + rangeMin);
                }

                System.out.print("Apakah angka mu lebih besar dari " + randomGuessNumber + "? (Y/T): ");
                String guess = scanner.nextLine();

                if (guess.toLowerCase().equals("y")) {
                    rangeMin = randomGuessNumber + 1;
                } else if (guess.toLowerCase().equals("t")) {
                    rangeMax = randomGuessNumber;
                } else {
                    System.out.println("Tidak Valid\n");
                    main(args);
                    break;
                }
            }

            if (finish) {
                System.out.println("Angka anda adalah " + rangeMax + "!\n");
            }
        }
    }
}
