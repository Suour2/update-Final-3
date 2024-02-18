import java.util.Comparator;
import java.util.Scanner;

public class PalApp {
    PalList palList;

    // constructor
    public PalApp() {
        this.palList = new PalList();
    }

    // display completed pals, capture count == 10
    public void displayCompletePals() {
        System.out.println("Complete Pals:");
        for (Pal pal : palList.getPals()) {
            if (pal.getCapturedCount() == 10) {
                System.out.println("ID: " + pal.getPalNumber() + ", " + pal.getName() + ", "
                        + pal.getElementType() + ", Captures: " + pal.getCapturedCount());
            }
        }
    }

    // display incomplete pals, capture count < 10
    public void displayIncompletePals() {
        System.out.println("Incomplete Pals:");
        for (Pal pal : palList.getPals()) {
            if (pal.getCapturedCount() < 10) {
                System.out.println("ID: " + pal.getPalNumber() + ", " + pal.getName() + ", "
                        + pal.getElementType() + ", Captures: " + pal.getCapturedCount());
            }
        }
    }

    public void saveChanges() {
        // Placeholder method to simulate saving changes
        System.out.println("Changes saved.");
    }

    // select a sorting option and sort pals
    public void selectSortOption(SortingOption option) {
        if (option.getOptionName().equalsIgnoreCase("CapturedCount")) {
            palList.getPals().sort(Comparator.comparingInt(Pal::getCapturedCount).reversed());
        } else {
            palList.getPals().sort(option.getComparator());
        }
    }

    // populate pals from a text file
    public void populatePalsFromTextFile(String filename) {
        palList.populateFromTextFile(filename);
    }

    // main memthod to run the Pal companion
    public static void main(String[] args) {
        PalApp palApp = new PalApp();
        Scanner scanner = new Scanner(System.in);

        // Populate pals from text file
        palApp.populatePalsFromTextFile("C:\\Java\\Final update 3\\ListOfPals.txt");

        // Display unsorted pals
        System.out.println("Unsorted Pals:");
        for (Pal pal : palApp.palList.getPals()) {
            System.out.println("ID: " + pal.getPalNumber() + ", " + pal.getName() + ", "
                    + pal.getElementType() + ", Captures: " + pal.getCapturedCount());
        }

        // Select sorting option
        System.out.println("Select sorting option (ID, Name, Element, CapturedCount):");
        String sortingOption = scanner.nextLine();

        SortingOption option = new SortingOption(sortingOption);
        palApp.selectSortOption(option);

        // Display sorted pals
        System.out.println("\nSorted Pals:");
        for (Pal pal : palApp.palList.getPals()) {
            System.out.println("ID: " + pal.getPalNumber() + ", " + pal.getName() + ", "
                    + pal.getElementType() + ", Captures: " + pal.getCapturedCount());
        }

        // display complete pals then incomplete pals
        palApp.displayCompletePals();
        palApp.displayIncompletePals();

        // save changes, will be implemented later as a button to save to changes to
        // capture count based off the slider value in javaFX
        palApp.saveChanges();

        scanner.close();
    }
}
