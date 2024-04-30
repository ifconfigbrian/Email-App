import java.util.Scanner;

public class EmailApp {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 12;
    private String alternateEmail;
    private String companySuffix = "batcave.com";

    //constructor to receive firstname and last name
    Scanner sc;
    public EmailApp(){
        sc = new Scanner(System.in);
        System.out.print("Enter employees first name: ");
        this.firstName = sc.nextLine();

        System.out.print("Enter employees last name: ");
        this.lastName = sc.nextLine();

        //call a method asking for department -  return department
        this.department = setDepartment();
 
        //call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //combine elements to generate email
        email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + department + "." + companySuffix;

    }

    //ask for the department
    private String setDepartment(){
        System.out.println("New worker: " + firstName + " " + lastName +
                   ".\nDepartment codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        int depChoice = sc.nextInt();
        if (depChoice == 1) {
            return "sales";   
        } else if (depChoice == 2) {
            return "dev";     
        }else if (depChoice == 3) {
            return "acc";      
        }else {
            return "";
            
        }
        
    }

    //generate random password
     private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz`~!@#$%^&*()';'<>.,-0123456789";
        char[] password = new char[length];
        for(int i = 0; i < length; ++i){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);

        }
        return new String(password);
     }

    //set mailbox capacity
    public void setMailCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //set alternate email
public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    //change password
    public void changePassword(String password){
        this.password = password;
    }
    //get methods
    public int getMailboxCapacity(){return mailboxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword(){return password;}

    //method to show only important info
     public String showInfo(){
        return "DISPLAY NAME: "  + firstName + " " + lastName + "\nCOMPANY EMAIL: " + email
         + "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";

     }


}