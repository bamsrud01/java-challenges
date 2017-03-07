/*  Main Class  */
public class Main {

    public static void main(String[] args) {
        Outlander outlander = new Outlander(36);
        outlander.steer(45);
        outlander.accelerate(30);
        outlander.accelerate(20);
        outlander.accelerate(-45);
    }
}

/*  Vehicle Class  */
public class Vehicle {

    //  Data for the vehicle
    private String name;
    private String size;

    private int currentVelocity;
    private int currentDirection;

    //  Constructor
    public Vehicle(String name, String size) {
        this.name = name;
        this.size = size;

        //  Default values of 0
        this.currentVelocity = 0;
        this.currentDirection = 0;
    }

    public void steer(int direction) {
        currentDirection += direction;
        System.out.println("Vehicle.steer(): Steering at " + currentDirection + " degrees.");
    }

    public void move(int velocity, int direction) {
        currentVelocity = velocity;
        currentDirection = direction;
        System.out.println("Vehicle.move(): Moving at " + currentVelocity + " in direction " + currentDirection);
    }

    public void stop() {
        this.currentVelocity = 0;
    }

    //  Getters
    public String getName() {
        return name;
    }
    public String getSize() {
        return size;
    }
    public int getCurrentVelocity() {
        return currentVelocity;
    }
    public int getCurrentDirection() {
        return currentDirection;
    }

    //  Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public void setCurrentVelocity(int currentVelocity) {
        this.currentVelocity = currentVelocity;
    }
    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }
}

/*  Car Class  */
public class Car extends Vehicle {

    //  Unique fields for Car
    private int wheels;
    private int doors;
    private int gears;
    private boolean isManual;

    private int currentGear;

    //  Constructor
    public Car(String name, String size, int wheels, int doors, int gears, boolean isManual) {
        super(name, size);
        this.wheels = wheels;
        this.doors = doors;
        this.gears = gears;
        this.isManual = isManual;
        //  Assume the current gear is 1 on start
        this.currentGear = 1;
    }

    public void changeGear(int currentGear) {
        this.currentGear = currentGear;
        System.out.println("Car.setCurrentGear(): Changed to " + this.currentGear + " gear.");
    }

    public void changeVelocity(int speed, int direction) {
        //  Call the move method from Vehicle
        move(speed, direction);
        System.out.println("Car.changeVelocity(): Velocity " + speed + " direction " + direction);
    }
}

/*  Outlander Class  */
public class Outlander extends Car {

    //  Class for Outlander type of Car
    private int roadServiceMonths;

    //  Constructor
    public Outlander(int roadServiceMonths) {
        super("Outlander", "4WD", 5, 5, 6, false);
        this.roadServiceMonths = roadServiceMonths;
    }

    public void accelerate(int rate) {
        //  Change the velocity by adding rate (either positive or negative value)
        int newVelocity = getCurrentVelocity() + rate;
        if (newVelocity == 0) {
            stop();
            changeGear(1);
        } else if (newVelocity > 0 && newVelocity <= 10) {
            changeGear(1);
        } else if (newVelocity > 10 && newVelocity <= 20) {
            changeGear(2);
        } else if (newVelocity > 20 && newVelocity <= 30) {
            changeGear(3);
        } else {
            changeGear(4);
        }

        if (newVelocity > 0) {
            changeVelocity(newVelocity, getCurrentDirection());
        }
    }
}
