/*  Main Class  */
public class Main {

    public static void main(String[] args) {

        //  All Printer information is properly encapsulated
        Printer printer = new Printer(50, true);
        System.out.println("Initial page count: " + printer.getPagesPrinted());
        int pagesPrinted = printer.printPages(4);
        System.out.println("Printing pages: " + pagesPrinted);
        System.out.println("Total pages printed: " + printer.getPagesPrinted());
        pagesPrinted = printer.printPages(2);
        System.out.println("Printing pages: " + pagesPrinted);
        System.out.println("Total pages printed: " + printer.getPagesPrinted());
    }
}

/*  Printer Class  */
public class Printer {

    private int tonerLevel;
    private int pagesPrinted;
    private boolean twoSides;

    //  Constructor
    public Printer(int tonerLevel, boolean twoSides) {
        if (tonerLevel > -1 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        } else {
            this.tonerLevel = -1;   //  Indicates an error
        }
        this.twoSides = twoSides;
        this.pagesPrinted = 0;      //  Initialized to 0
    }

    public int addToner(int tonerAmount) {
        if (tonerAmount > 0 && tonerAmount <= 100) {
            if (this.tonerLevel + tonerAmount > 100) {
                return -1;  //  Error
            }
            this.tonerLevel += tonerAmount;
            return this.tonerLevel;
        } else {
            return -1;
        }
    }

    public int printPages(int pages) {
        int pagesToPrint = pages;
        if (this.twoSides) {
            pagesToPrint /= 2;
            System.out.println("Printing double-sided");
        }
        this.pagesPrinted += pagesToPrint;
        return pagesToPrint;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
