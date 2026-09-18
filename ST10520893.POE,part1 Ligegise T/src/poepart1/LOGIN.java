package poepart1;
import java.util.Scanner;

public class LOGIN {
    
    String passMessage;
    String nameMessage;
   
    public boolean checkUserName(String userName){
        return userName.contains("_") && userName.length() <= 5;
    }
    
    public boolean checkPasswordComplexity(String password){
        boolean passwordOkay = false;
        boolean hasNumber = false;
        boolean hasCap = false;
        boolean hasChar = false;
        char current;
        
        if (password.length() >= 8){ 
            for (int i = 0; i < password.length(); i++){
                current = password.charAt(i);
                if(Character.isDigit(current)){
                    hasNumber = true;
                }
                else if(Character.isUpperCase(current)){
                    hasCap = true;
                }
                else if (!(Character.isLetterOrDigit(current))){
                    hasChar = true;
                }
            }
        }    
            
        if(hasNumber && hasCap && hasChar){
            passwordOkay = true;
        }
        return passwordOkay;
    }
    
    public String registerUser(String pass, String name){
        if (checkPasswordComplexity(pass)){
            passMessage = "Password successfully captured.";
        }
        else{
            passMessage = "Password is not correctly formatted, please ensure that the password contains at least 8 characters, "
            + "a capital letter, a number and a special character.";
        }
        
        if (checkUserName(name)){
            nameMessage = "Username successfully captured.";
        }
        else{
            nameMessage = "Username is not correctly formatted, please ensure that your "
                    + "username contains an underscore and is no more than 5 characters in length.";
        }
        
        return (nameMessage + "\n" + passMessage);
    }
    
    public boolean checkContactNumber(String contactNumber){
        if (contactNumber == null){
            System.out.println("Contact number incorrectly formatted, please check if it starts with +27 and has 9 digits.");
            return false;
        }
        if (contactNumber.startsWith("+27") && contactNumber.length() == 12){
            String digits = contactNumber.substring(3);
            if(digits.matches("\\d{9}")) {
                System.out.println("Contact number successfully captured.");
                return true;
            }
        }
        System.out.println("Contact number incorrectly formatted, please ensure it starts with +27 with 9 digits.");
        return false;
    }
    
    public boolean loginUser(boolean checkName, boolean checkPassword, String passwrd, String userName){
        boolean logged = false;
        
        if(checkName && checkPassword) { 
            Scanner in = new Scanner(System.in);
            System.out.println("");
            System.out.println(" *** LOGIN *** ");            
            System.out.print("Enter the username you used to register: ");
            String username = in.nextLine();
            System.out.print("Enter the password you used to register: ");
            String password = in.nextLine();
            
            if (password.equals(passwrd) && username.equals(userName)){
                logged = true;
            }
            in.close(); 
        }
        return logged;
    }
    
    public String returnLoginStatus(boolean regStatus, String Firstname, String Lastname){
        String message;
        
        if (regStatus){
            message = "Welcome, " + Firstname + " " + Lastname + ", it is great to see you again.";
        }
        else {
            message = "Username and/or password incorrect, please try again.";
        }
        
        return message;
    }
}