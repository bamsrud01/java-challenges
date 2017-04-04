//  Import ArrayList utility
import java.util.ArrayList;

/*  Main Class  */

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("Super Bank");
        bank.addBranch("Minneapolis");
        bank.addCustomer("Minneapolis", "Barrett", 1000000.00);
        bank.addCustomer("Minneapolis", "Evynne", 924000.00);
        bank.addCustomer("Minneapolis", "Donald Duck", 20.25);

        bank.addBranch("The Moon");
        bank.addCustomer("The Moon", "Marvin", 500.00);

        bank.addCustomerTransaction("Minneapolis", "Barrett", 45.00);
        bank.addCustomerTransaction("Minneapolis", "Barrett", 20.00);
        bank.addCustomerTransaction("Minneapolis", "Evynne", 505.72);

        bank.listCustomers("Minneapolis", true);
    }
}


/*  Customer Class  */

public class Customer {

    //  Fields for Customer class
    private String name;
    private ArrayList<Double> transactions;

    //  Constructor - note the primitive type for double
    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        addTransaction(initialAmount);
    }

    public void addTransaction(double amount) {
        this.transactions.add(amount);
    }

    //  Getters
    public String getName() {
        return name;
    }
    public ArrayList<Double> getTransactions() {
        return transactions;
    }


/*  Branch Class  */

public class Branch {

    //  Fields for Branch class
    private String name;
    private ArrayList<Customer> customers;

    //  Constructor
    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    //  Getters
    public String getName() {
        return name;
    }
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    //  Method to create a new customer, boolean to ensure customer does not already exist
    public boolean newCustomer(String customerName, double initialAmount) {
        if(findCustomer(customerName) == null) {
            this.customers.add(new Customer(customerName, initialAmount));
            return true;
        }
        return false;
    }

    //  Method to add a customer transaction
    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName);
        if(existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    //  Method to find customers in the existing array list
    private Customer findCustomer(String customerName) {
        for(int i=0; i<this.customers.size(); i++) {
            Customer checkedCustomer = this.customers.get(i);
            if (checkedCustomer.getName().equals(customerName)) {
                return checkedCustomer;
            }
        }
        return null;
    }

}


/*  Bank Class  */

public class Bank {

    //  Fields for Bank class
    private String name;
    private ArrayList<Branch> branches;

    //  Constructor
    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    //  Method to add a branch
    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    //  Method to add a customer
    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    //  Method to create a customer transaction
    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    //  Method to find a branch
    private Branch findBranch(String branchName) {
        for (int i=0; i<this.branches.size(); i++) {
            Branch checkedBranch = this.branches.get(i);
            if (checkedBranch.getName().equals(branchName)) {
                return checkedBranch;
            }
        }
        return null;
    }

    //  Method to list all customers
    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customers for branch " + branch.getName() + ";");
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i=0; i<branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer:" + branchCustomer.getName() + "[" + (i+1) + "]");
                if (showTransactions) {
                    System.out.println("Transactions:");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j=0; j<transactions.size(); j++) {
                        System.out.println("[" + (j+1) + "] Amount: " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

}
