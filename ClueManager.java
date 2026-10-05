public class ClueManager
{
        private String[] clues = {
        "The office door was opened at 2:15 PM.",
        "CCTV shows someone entering the office.",
        "A torn piece of paper was found near the printer.",
        "A suspect's ID card was found inside the office.",
        "The printer was used shortly before the question paper disappeared."
    };

    private boolean[] isCollected = new boolean[5];

    public void displayAvailableClues()
    {
        System.out.println("\n--- AVAILABLE CLUES ---");
        for (int i = 0; i < clues.length; i++)
            {
            String status = isCollected[i] ? "[Collected]" : "[Not Collected]";
            System.out.println((i + 1) + ". " + clues[i] + " " + status);
            }
    }

    public void collectClue(int clueNumber)
    {
        int index = clueNumber - 1;
        if (index < 0 || index >= clues.length)
        {
        System.out.println("Invalid clue number! Please select a number between 1 and " + clues.length + ".");
        return;
    }

    // Check if already collected
    if (isCollected[index])
        {
            System.out.println("Clue #" + clueNumber + " has already been collected!");
        } 
        else 
        {
            isCollected[index] = true; // Mark as collected
            System.out.println("Successfully collected Clue #" + clueNumber + ": \"" + clues[index] + "\"");
        }
    }   
    
    public void displayCollectedClues()
    {
        System.out.println("\n--- COLLECTED CLUES ---");
        boolean anyCollected = false;

        for (int i = 0; i < clues.length; i++)
        {
            if (isCollected[i])
            {
                System.out.println("- " + clues[i]);
                anyCollected = true;
            }
        }

        if (!anyCollected) { // If no clues were true
            System.out.println("No clues have been collected yet.");
        }
    }
}

