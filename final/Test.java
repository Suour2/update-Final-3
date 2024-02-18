public class Test {

    // main method to run all test
    public static void main(String[] args) {
        testPal();
        testPalList();
        testPalApp();
        testSortingOption();
    }

    // Pal class test that creates new pal and prints it
    public static void testPal() {
        Pal pal = new Pal(1, "Test", "Element", 5);
        System.out.print("Pal Number: " + pal.getPalNumber());
        System.out.print(", Name: " + pal.getName());
        System.out.print(", Element Type: " + pal.getElementType());
        System.out.println(", Captured Count: " + pal.getCapturedCount());
    }

    // PalList class test that creates a new list and add 2 pals to the list then
    // prints them
    public static void testPalList() {
        PalList palList = new PalList();
        palList.addPal(new Pal(1, "Test1", "Element1", 5));
        palList.addPal(new Pal(2, "Test2", "Element2", 10));

        System.out.println("Pals:");
        for (Pal pal : palList.getPals()) {
            System.out.print("Pal Number: " + pal.getPalNumber());
            System.out.print(", Name: " + pal.getName());
            System.out.print(", Element Type: " + pal.getElementType());
            System.out.println(", Captured Count: " + pal.getCapturedCount());
        }
    }

    // PalApp test class that populates pals from a text file then prints them
    // unsorted then sorted
    public static void testPalApp() {
        PalApp palApp = new PalApp();
        palApp.populatePalsFromTextFile("C:\\Java\\Final update 3\\ListOfPals.txt");

        // Display unsorted pals
        System.out.println("Unsorted Pals:");
        for (Pal pal : palApp.palList.getPals()) {
            System.out.print("Pal ID: " + pal.getPalNumber());
            System.out.print(", Name: " + pal.getName());
            System.out.print(", Element Type: " + pal.getElementType());
            System.out.println(", Captured Count: " + pal.getCapturedCount());
        }

        // Select sorting option
        System.out.println("Select sorting option (ID, Name, Element, CapturedCount):");
        palApp.selectSortOption(new SortingOption("Element"));

        // Display sorted pals
        System.out.println("\nSorted Pals:");
        for (Pal pal : palApp.palList.getPals()) {
            System.out.print("Pal ID: " + pal.getPalNumber());
            System.out.print(", Name: " + pal.getName());
            System.out.print(", Element Type: " + pal.getElementType());
            System.out.println(", Captured Count: " + pal.getCapturedCount());
        }
    }

    // SortingOption test class that creates a new sorting option then prints it
    public static void testSortingOption() {
        SortingOption sortingOption = new SortingOption("OptionName");
        System.out.println("Option Name: " + sortingOption.getOptionName());
    }
}
