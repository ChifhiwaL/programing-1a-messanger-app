package poepart1;
import java.util.Scanner;

public class PoEpArT1 
{
    private static String UserName;
    private static String PassWord;
    private static String Firstname;
    private static String Lastname;
    private static String ContactNumber;
    
    public static void setUserName(String username){               
        UserName = username;
    }
    public static String getUserName(){
        return UserName;
    }
    
    public static void setPassword(String password){
        PassWord = password;
    }
    public static String getPassword(){
        return PassWord;
    }
    
    public static void setFirstname(String firstname){
        Firstname = firstname;
    }
    public static String getFirstname(){
        return Firstname;
    }
    
    public static void setContactNumber(String contactNumber){
        ContactNumber = contactNumber;
    }
    public static String getContactNumber(){
        return ContactNumber;
    }
    
    public static void setLastname(String lastname){
        Lastname = lastname;
    }
    public static String getLastname(){
        return Lastname;
    }
    
    public static void main(String[] args)
    {
        LOGIN MyLogin = new LOGIN();
        Scanner input = new Scanner(System.in);
        
        System.out.println(" *** REGISTRATION *** ");
        
        // Get user input
        System.out.print("Please enter your Firstname: ");
        setFirstname(input.nextLine());
        
        System.out.print("Please enter your Lastname: ");
        setLastname(input.nextLine());
        
        System.out.print("Please enter your username: ");
        setUserName(input.nextLine());
        
        System.out.print("Please enter the password: ");
        setPassword(input.nextLine());
        
        // Validate username and password
        boolean isValidUsername = MyLogin.checkUserName(getUserName());
        boolean isValidPassword = MyLogin.checkPasswordComplexity(getPassword());
        
        // Display validation results
        if (isValidUsername) {
            System.out.println("Username successfully captured");
        } else {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
        }
        
        if (isValidPassword) {
            System.out.println("Password successfully captured");
        } else {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
        }
        
        // Register user if both username and password are valid
        if (isValidUsername && isValidPassword) {
            System.out.println(MyLogin.registerUser(getPassword(), getUserName()));
            
            // Attempt login
            boolean loginStatus = MyLogin.loginUser(isValidUsername, isValidPassword, getPassword(), getUserName());
            System.out.println(MyLogin.returnLoginStatus(loginStatus, getFirstname(), getLastname()));
        } else {
            System.out.println("Registration failed. Please fix the validation errors above.");
        }
        
        input.close();
    }
}