/*  Main Class  */
public class Main {

    public static void main(String[] args) {

        Hamburger hamburger = new Hamburger("Classic", "Patty", "White", 3.99);
        double price = hamburger.itemizeHamburger();

        Hamburger supremeBurger = new Hamburger("Supreme", "patty", "sesame seed", 3.99);
        supremeBurger.addOption1("cheddar cheese", 0.75);
        supremeBurger.addOption2("tomato", 0.35);
        supremeBurger.addOption3("pickles", 0.25);
        supremeBurger.addOption4("lettuce", 0.15);
        System.out.println("Total price is $" + supremeBurger.itemizeHamburger() + ".");

        HealthyBurger healthyBurger = new HealthyBurger("lean beef", 5.50);
        healthyBurger.addHealthyOption1("egg", 0.99);
        healthyBurger.addHealthyOption2("onion", 0.50);
        System.out.println("Total Healthy Burger price is $" + healthyBurger.itemizeHamburger() + ".");

        DeluxeBurger deluxeBurger = new DeluxeBurger();
        deluxeBurger.itemizeHamburger();
    }
}

/*  Hamburger Class  */
public class Hamburger {

    //  Hamburger fields
    private String name;
    private String meat;
    private String bunType;
    private double price;

    //  Additional options
    private String option1Name;
    private double option1Price;
    private String option2Name;
    private double option2Price;
    private String option3Name;
    private double option3Price;
    private String option4Name;
    private double option4Price;

    //  Constructor
    public Hamburger(String name, String meat, String bunType, double price) {
        this.name = name;
        this.meat = meat;
        this.bunType = bunType;
        this.price = price;
    }

    //  Methods to add options
    public void addOption1(String name, double price) {
        option1Name = name;
        option1Price = price;
    }
    public void addOption2(String name, double price) {
        option2Name = name;
        option2Price = price;
    }
    public void addOption3(String name, double price) {
        option3Name = name;
        option3Price = price;
    }
    public void addOption4(String name, double price) {
        option4Name = name;
        option4Price = price;
    }

    //  Method to calculate price
    public double itemizeHamburger() {
        //  Create local variable that takes the value of the price in the constructor
        double hamburgerPrice = this.price;
        System.out.println(this.name + " hamburger on a " + this.bunType + " bun is $" + this.price + ".");
        if (this.option1Name != null) {
            hamburgerPrice += this.option1Price;
            System.out.println("Added " + this.option1Name + " for an extra $" + this.option1Price + ".");
        }
        if (this.option2Name != null) {
            hamburgerPrice += this.option2Price;
            System.out.println("Added " + this.option2Name + " for an extra $" + this.option2Price + ".");
        }
        if (this.option3Name != null) {
            hamburgerPrice += this.option3Price;
            System.out.println("Added " + this.option3Name + " for an extra $" + this.option3Price + ".");
        }
        if (this.option4Name != null) {
            hamburgerPrice += this.option4Price;
            System.out.println("Added " + this.option4Name + " for an extra $" + this.option4Price + ".");
        }
        return hamburgerPrice;
    }
}

/*  Healthy Burger Class  */
public class HealthyBurger extends Hamburger {

    //  Fields for this class
    private String healthyOption1Name;
    private double healthyOption1Price;
    private String healthyOption2Name;
    private double healthyOption2Price;

    //  Constructor
    public HealthyBurger(String meat, double price) {
        super("Healthy", meat, "brown rye", price);
    }

    //  Add options
    public void addHealthyOption1(String name, double price) {
        this.healthyOption1Name = name;
        this.healthyOption1Price = price;
    }
    public void addHealthyOption2(String name, double price) {
        this.healthyOption2Name = name;
        this.healthyOption2Price = price;
    }

    @Override
    public double itemizeHamburger() {
        double hamburgerPrice = super.itemizeHamburger();
        if (this.healthyOption1Name != null) {
            hamburgerPrice += this.healthyOption1Price;
            System.out.println("Added " + this.healthyOption1Name + " for an extra $" + this.healthyOption1Price + ".");
        }
        if (this.healthyOption2Name != null) {
            hamburgerPrice += this.healthyOption2Price;
            System.out.println("Added " + this.healthyOption2Name + " for an extra $" + this.healthyOption2Price + ".");
        }
        return hamburgerPrice;
    }
}

/*  Deluxe Burger Class  */
public class DeluxeBurger extends Hamburger {

    //  Constructor
    public DeluxeBurger() {
        super("Deluxe", "sausage and bacon", "sesame seed", 6.99);
        super.addOption1("fried onions", 0.99);
        super.addOption2("fries", 2.00);
    }

    @Override
    public void addOption1(String name, double price) {
        System.out.println("Cannot add options to deluxe burger");
    }
    @Override
    public void addOption2(String name, double price) {
        System.out.println("Cannot add options to deluxe burger");
    }
    @Override
    public void addOption3(String name, double price) {
        System.out.println("Cannot add options to deluxe burger");
    }
    @Override
    public void addOption4(String name, double price) {
        System.out.println("Cannot add options to deluxe burger");
    }
}
