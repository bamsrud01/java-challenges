public class Main {

  public static void main(String[] args) {

    Account myAccount = new Account();
    myAccount.setBalance(1000000);
    myAccount.withdrawFunds(3000);
    myAccount.depositFunds(400);

  }

}
//  END OF CLASS

public class BankAccount {

  //  Class variables
  private String accountNumber;
  private double balance;
  private String customerName;
  private String email;
  private String phoneNumber;

  //  Class methods
  public void depositFunds(double funds) {
    this.balance += funds;
    System.out.println("You deposited $" + funds + ".  Your balance is now $" + this.balance + ".");
  }

  public void withdrawFunds(double funds) {
    if (funds > this.balance) {
      System.out.println("You do not have enough funds to withdraw that amount.  Your balance is $" + this.balance + ".");
    } else {
      this.balance -= funds;
      System.out.println("You withdrew $" + funds + ".  Your balance is now $" + this.balance + ".");
    }
  }

  //  Setters for each item
  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  //  Getters for each item
  public String getAccountNumber() {
    return accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  public String getCustomerName() {
    return customerName;
  }

  public String getEmail() {
    return email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

}
