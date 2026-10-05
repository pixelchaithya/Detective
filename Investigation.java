public class Investigation {

    // Search for a suspect using the suspect ID
    public Suspect searchSuspect(Suspect[] suspects, int suspectId) {

        for (Suspect suspect : suspects) {

            if (suspect.getId() == suspectId) {
                return suspect;
            }
        }

        return null;
    }


    // Investigate and display the details of a suspect
    public void investigateSuspect(Suspect[] suspects, int suspectId) {

        Suspect suspect = searchSuspect(suspects, suspectId);

        if (suspect != null) {
            System.out.println("\n--- SUSPECT FOUND ---");
            suspect.displaySuspectDetails();
        } 
        else {
            System.out.println("No suspect found with ID: " + suspectId);
        }
    }


    // Handle the accusation process
    public void accuseSuspect(
            Suspect[] suspects,
            int actualCulpritId,
            int[] accusationAttempts) {

        int attempts = 0;

        for (int accusedId : accusationAttempts) {

            attempts++;

            Suspect accusedSuspect = searchSuspect(suspects, accusedId);

            if (accusedSuspect == null) {
                System.out.println("Invalid suspect ID: " + accusedId);
                continue;
            }

            System.out.println("\nAttempt " + attempts);
            System.out.println("Accusing: " + accusedSuspect.getName());

            if (accusedId == actualCulpritId) {

                System.out.println("\nCASE SOLVED!");
                System.out.println("You identified the culprit.");
                System.out.println("The missing question paper has been recovered.");

                return;
            } 
            else {

                System.out.println("Incorrect accusation.");
            }

            // Maximum of 3 accusation attempts
            if (attempts == 3) {
                break;
            }
        }

        // If all 3 attempts are used without finding the culprit
        if (attempts == 3) {

            System.out.println("\nINVESTIGATION FAILED!");
            System.out.println("You have used all three attempts.");
            System.out.println("The culprit escaped.");
        }
    }
}