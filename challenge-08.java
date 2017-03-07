/*  Main Class  */
public class Main {

    public static void main(String[] args) {

        Wall wall1 = new Wall("West");
        Wall wall2 = new Wall("North");
        Wall wall3 = new Wall("East");
        Wall wall4 = new Wall("South");

        Ceiling ceiling = new Ceiling(12, "red");

        Bed bed = new Bed("Modern", 4, 3, 2, 1);

        Lamp lamp = new Lamp("Classic", false, 75);

        Bedroom bedroom = new Bedroom("Barret's room", wall1, wall2, wall3, wall4, ceiling, bed, lamp);
        //  Two ways to access objects with composition.  First by using a method that accesses objects privately
        bedroom.makeBed();
        //  Second by returning an object, then calling it.
        bedroom.getLamp().turnOn();
    }
}

/*  Bedroom Class  */
public class Bedroom {

    //  Fields for Bedroom
    private String name;
    private Wall wall1;
    private Wall wall2;
    private Wall wall3;
    private Wall wall4;
    private Ceiling ceiling;
    private Bed bed;
    private Lamp lamp;

    //  Constructor
    public Bedroom(String name, Wall wall1, Wall wall2, Wall wall3, Wall wall4, Ceiling ceiling, Bed bed, Lamp lamp) {
        this.name = name;
        this.wall1 = wall1;
        this.wall2 = wall2;
        this.wall3 = wall3;
        this.wall4 = wall4;
        this.ceiling = ceiling;
        this.bed = bed;
        this.lamp = lamp;
    }

    //  Getter for lamp, others unnecessary
    public Lamp getLamp() {
        return this.lamp;
    }
    public void makeBed() {
        System.out.println("Bedroom: Making bed");
        bed.make();
    }
}

/*  Wall Class  */
public class Wall {

    private String direction;

    //  Constructor
    public Wall(String direction) {
        this.direction = direction;
    }

    //  Getter
    public String getDirection() {
        return direction;
    }
}

/*  Ceiling Class  */
public class Ceiling {

    private int height;
    private String paintedColor;

    //  Constructor
    public Ceiling(int height, String paintedColor) {
        this.height = height;
        this.paintedColor = paintedColor;
    }

    //  Getters
    public int getHeight() {
        return height;
    }
    public String getPaintedColor() {
        return paintedColor;
    }
}

/*  Bed Class  */
public class Bed {

    private String style;
    private int pillows;
    private int height;
    private int sheets;
    private int quilt;

    //  Constructor
    public Bed(String style, int pillows, int height, int sheets, int quilt) {
        this.style = style;
        this.pillows = pillows;
        this.height = height;
        this.sheets = sheets;
        this.quilt = quilt;
    }

    //  Getters
    public String getStyle() {
        return style;
    }
    public int getPillows() {
        return pillows;
    }
    public int getHeight() {
        return height;
    }
    public int getSheets() {
        return sheets;
    }
    public int getQuilt() {
        return quilt;
    }

    public void make() {
        System.out.println("Bed: Making");
    }
}

/*  Lamp Class  */
public class Lamp {

    private String style;
    private boolean battery;
    private int globeRating;

    //  Constructor
    public Lamp(String style, boolean battery, int globeRating) {
        this.style = style;
        this.battery = battery;
        this.globeRating = globeRating;
    }

    public void turnOn() {
        System.out.println("Lamp: Turning on");
    }

    //  Getters
    public String getStyle() {
        return style;
    }
    public boolean isBattery() {
        return battery;
    }
    public int getGlobeRating() {
        return globeRating;
    }
}
