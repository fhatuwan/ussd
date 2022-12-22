import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ussd {
    public static void main(String[] args)
    {
        BankAccount obj1=new BankAccount("Fhatuwani","GF001");
        obj1.showMenu();

    }

}

class  User{
    String Name;
    int Id;
    String password;

    User(String Name,int Id,String password){
        this.Name = Name;
        this.Id = Id;
        this.password = password;
    }
}

class BankAccount {
    Double balance;
    Double Transaction;
    String customerName;
    String customerId;
    double amountI;
    List<User> customerList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    BankAccount(String cName, String cId) {
        customerName = cName;
        customerId = cId;
    }


    void deposit(Double amount) {
        if (amount <= 0) {
            balance = balance + amount;
            Transaction = amount;
        }
    }

    void withdraw(Double amount) {
        if (amount <= 0) {
            balance = balance - amount;
            Transaction = amount;
        }
    }

    void getTransaction() {
        if (Transaction > 0) {
            System.out.println(("deposited :" + Transaction));
        } else if (Transaction < 0) {
            System.out.println("withdraw :" + Math.abs(Transaction));
        } else {
            System.out.println("no transaction occured ");
        }
    }

    void showMenu() {
        char option = '\0';
        System.out.println("\n");
        System.out.println("1. Create new user");
        System.out.println("2. Login");
        int choice = Integer.parseInt(scanner.nextLine());
        if(choice == 1){
            createCustomer();
            login();
        }else if(choice == 2) {

            User customer= login();
             if(customer != null){
                 System.out.println("Customer found");
             }else{
                 System.out.println("Customer not found");
             }
        }else{
            System.exit(1);
        }


        System.out.println("Welcome " + customerName);
        System.out.println("Your custumer id is : " + customerId);
        System.out.println("\n");
       /*  System.out.println("A.check balance");
        System.out.println("B.Deposit");
        System.out.println("C.Withdraw");
        System.out.println("D.Transaction");
        System.out.println("E.Exit");*/
        System.out.println("\nEnter the Option"); 
         
        do {
            options();
           // System.out.println("\nEnter the Option");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option)
            {
                case 'A': {
                    System.out.println("Your Balance is :" + balance);
                    System.out.println("\n");
                    break;
                }
                case 'B':{
                    System.out.println("Enter the amount you want to deposit");
                    Double amount=scanner.nextDouble();
                    deposit(amount);
                    balance = balance + amount;
                    System.out.println("R" + getBalance());                   
                    System.out.println("\n");
                    break;
                }
                case 'C': {
                    System.out.println("Enter the amount you want to withdraw");
                    Double amount2=scanner.nextDouble();
                    withdraw(amount2);
                    balance = balance - amount2;
                    System.out.println("R" + getBalance()); 
                    System.out.println("\n");
                    break;
                }
                case 'D': {
                    getTransaction();
                    System.out.println("\n");
                    break;
                }
                case 'E': {
                    System.out.println("****************************************************");
                    break;
                }
                default: {
                    System.out.println("invalid option.Please enter again");
                    break;
                }

            }


        }while (option!='E');

            System.out.println("Thanks for using our services!!!");
            



    }

    void options()
    {
        System.out.println("A.check balance");
        System.out.println("B.Deposit");
        System.out.println("C.Withdraw");
        System.out.println("D.Transaction");
        System.out.println("E.Exit");
        System.out.println("\nEnter the Option");
    }

    

    private void createCustomer() {
        String username = getName();
        String password = getPassword();
        setBalance(0);
        int id = getId();
        customerList.add(new User(username,id,password));
        System.out.println("Customer with username = "+ username +"  and id = "+ id +" has been created");
    }

    private  String getName(){
        System.out.println("Enter username");
        return scanner.nextLine();
    }
    private  String getPassword(){
        System.out.println("Enter password");
        return scanner.nextLine();
    }

    public double getBalance()
    {
         return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    private  int getId(){
        Random rand = new Random();
        return rand.nextInt(1000000);
    }



    private User login() {
        String username = getName();
        String password = getPassword();
        System.out.println(getBalance()); 
        for(int i=0;i< customerList.size();i++){
            if(customerList.get(i).Name == username && customerList.get(i).password == password){
                return customerList.get(i);
            }
        }
        return  null;
    }


}