public class DetectiveGame {
    public static void main(String[] args) {
        Suspect[] suspects = Suspect.createSuspects();
        ClueManager clues = new ClueManager();
        Investigation inv = new Investigation();

        int culpritId = 5; // known only to DetectiveGame, never printed

        // Swap to {2, 3, 4} to demo the "all three attempts used" ending
        int[] accusation = {2, 5, 4};

        String[] menu = {
            "1. View Suspects", "2. Investigate Suspect", "3. Collect Clue",
            "4. View Collected Clues", "5. Accuse Suspect", "6. Exit"
        };

        // Predefined "detective actions": {menu choice, argument}
        int[][] script = {
            {1, 0}, {2, 3}, {2, 9}, {3, 1}, {3, 1}, {3, 4},
            {4, 0}, {7, 0}, {5, 0}, {6, 0}
        };

        int step = 0;
        boolean running = true;

        while (running && step < script.length) {
            int choice = script[step][0];
            int arg = script[step][1];
            step++;

            System.out.println("\n=================================");
            System.out.println("    DETECTIVE INVESTIGATION");
            System.out.println("=================================");
            for (int i = 0; i < menu.length; i++) {
                System.out.println(menu[i]);
            }
            System.out.println("Selected option: " + choice);

            switch (choice) {
                case 1:
                    Suspect.displayAllSuspects(suspects);
                    break;
                case 2:
                    inv.investigateSuspect(suspects, arg);
                    break;
                case 3:
                    clues.displayAvailableClues();
                    clues.collectClue(arg);
                    break;
                case 4:
                    clues.displayCollectedClues();
                    break;
                case 5:
                    inv.accuseSuspect(suspects, culpritId, accusation);
                    running = false; // 3 attempts passed in: solved or failed, either way it's over
                    break;
                case 6:
                    System.out.println("Investigation ended by the detective.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
                    continue;
            }
        }
        System.out.println("\nInvestigation closed.");
        return;
    }
}
