/*  Main Class  */
public class Main {

    public static void main(String[] args) {
	// write your code here
        Car car = new Car(8, "First Car");
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

        Mitsubishi mitsubishi = new Mitsubishi(6, "Outlander");
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.brake());

        Ford ford = new Ford(6, "Falcon");
        System.out.println(ford.startEngine());
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());

        Holden holden = new Holden(6, "Holden Commodore");
        System.out.println(holden.startEngine());
        System.out.println(holden.accelerate());
        System.out.println(holden.brake());
    }
}

/*  Car Class  */
class Car {

    //  Fields for Car class
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    //  Constructor
    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.wheels = 4;
        this.engine = true;
    }

    //  Getters
    public int getCylinders() { return cylinders; }
    public String getName() { return name; }

    //  Methods
    public String startEngine() {
        return "Car: Start Engine()";
    }
    public String accelerate() {
        return "Car: Accelerate()";
    }
    public String brake() {
        return "Car: Brake()";
    }
}

/*  Mitsubishi Car Class  */
class Mitsubishi extends Car {

    //  Constructor
    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    //  Override methods
    @Override
    public String startEngine() { return "Mitsubishi: Start Engine()"; }
    @Override
    public String accelerate() { return "Mitsubishi: Accelerate()"; }
    @Override
    public String brake() { return "Mitsubishi: Brake()"; }
}

/*  Ford Car Class  */
class Ford extends Car {

    //  Constructor
    public Ford(int cylinders, String name) {
        super(cylinders, name);
    }

    //  Override methods
    @Override
    public String startEngine() {
        return "Ford: Start Engine()";
    }
    @Override
    public String accelerate() {
        return "Ford: Accelerate()";
    }
    @Override
    public String brake() {
        return "Ford: Brake()";
    }
}

/*  Holden Car Class  */
class Holden extends Car {

    //  Constructor
    public Holden(int cylinders, String name) {
        super(cylinders, name);
    }

    //  Override methods
    //  Check out this version of startEngine() method!
    @Override
    public String startEngine() {
        return getClass().getSimpleName() + ": Start Engine()";
    }
    @Override
    public String accelerate() {
        return "Holden: Accelerate()";
    }
    @Override
    public String brake() {
        return "Holden: Brake()";
    }
}
