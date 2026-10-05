public class Suspect {
    // Data members for Suspect ID, name, location, and alibi
    private int id;
    private String name;
    private String location;
    private String alibi;

    // Constructor to initialize the data members using the 'this' keyword
    public Suspect(int id, String name, String location, String alibi) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.alibi = alibi;
    }

    // Getters so other parts of the program can access suspect information
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getAlibi() {
        return alibi;
    }

    // Method to display the details of a single suspect
    public void displaySuspectDetails() {
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Location: " + this.location);
        System.out.println("Alibi: " + this.alibi);
        System.out.println("-----------------------------------");
    }

    // Create five Suspect objects and store them in an array
    public static Suspect[] createSuspects() {
        Suspect[] suspects = new Suspect[5];

        suspects[0] = new Suspect(1, "Alex", "Computer Lab", "Working on a project");
        suspects[1] = new Suspect(2, "Maya", "Library", "Studying");
        suspects[2] = new Suspect(3, "Rahul", "Staff Room", "Meeting a faculty member");
        suspects[3] = new Suspect(4, "Sara", "Canteen", "Having lunch");
        suspects[4] = new Suspect(5, "Arjun", "Department Office", "Collecting documents");

        return suspects;
    }

    // Method to display all suspects
    public static void displayAllSuspects(Suspect[] suspects) {
        System.out.println("\n--- LIST OF SUSPECTS ---");
        for (Suspect suspect : suspects) {
            suspect.displaySuspectDetails();
        }
    }
}
