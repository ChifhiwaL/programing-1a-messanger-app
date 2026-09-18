package poepart1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * JUnit 4 tests for LOGIN class
 * Tests username, password, and phone number validation
 * @author RC_Student_lab
 */
public class LOGINTest {
    
    private LOGIN loginInstance;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;
    
    public LOGINTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("=== Starting LOGIN Class Tests ===");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("=== LOGIN Class Tests Completed ===");
    }
    
    @Before
    public void setUp() {
        loginInstance = new LOGIN();
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    
    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    
    
    
     // Test checkUserName with CORRECT username entries
     
    @Test
    public void testCheckUserName_CorrectEntries() {
        System.out.println("Testing CORRECT username entries");
        
        // Valid usernames: contain underscore and <= 5 characters
        assertTrue("'kyl_1' should be valid", loginInstance.checkUserName("kyl_1"));
        
    }

    
     // Test checkUserName with INCORRECT username entries
     
    @Test
    public void testCheckUserName_IncorrectEntries() {
        System.out.println("Testing INCORRECT username entries");
        
        // Invalid: no underscore
        assertFalse("'kyle1' should be invalid (no underscore)", 
                   loginInstance.checkUserName("kyle1"));
        assertFalse("'user' should be invalid (no underscore)", 
                   loginInstance.checkUserName("user"));
        assertFalse("'admin' should be invalid (no underscore)", 
                   loginInstance.checkUserName("admin"));
        
        // Invalid: more than 5 characters
        assertFalse("'kyle_12' should be invalid (6 characters)", 
                   loginInstance.checkUserName("kyle_12"));
        assertFalse("'user_name' should be invalid (9 characters)", 
                   loginInstance.checkUserName("user_name"));
        assertFalse("'admin_user' should be invalid (10 characters)", 
                   loginInstance.checkUserName("admin_user"));
        
        // Invalid: both no underscore AND too long
        assertFalse("'username' should be invalid (no underscore + too long)", 
                   loginInstance.checkUserName("username"));
        assertFalse("'administrator' should be invalid (no underscore + too long)", 
                   loginInstance.checkUserName("administrator"));
        
        // Edge cases
        assertFalse("Empty string should be invalid", 
                   loginInstance.checkUserName(""));
    }

    
    
    
     // Test checkPasswordComplexity with CORRECT password entries
     
    @Test
    public void testCheckPasswordComplexity_CorrectEntries() {
        System.out.println("Testing CORRECT password entries");
        
        // Valid passwords: >= 8 chars, uppercase, number, special character
        assertTrue("'Password1!' should be valid", 
                  loginInstance.checkPasswordComplexity("Password1!"));
        assertTrue("'MyPass123#' should be valid", 
                  loginInstance.checkPasswordComplexity("MyPass123#"));
        assertTrue("'Hello123@World' should be valid", 
                  loginInstance.checkPasswordComplexity("Hello123@World"));
        assertTrue("'A1b2C3d4!' should be valid", 
                  loginInstance.checkPasswordComplexity("A1b2C3d4!"));
        assertTrue("'SecurePass99$' should be valid", 
                  loginInstance.checkPasswordComplexity("SecurePass99$"));
        assertTrue("'Test123&Pass' should be valid", 
                  loginInstance.checkPasswordComplexity("Test123&Pass"));
        assertTrue("'Complex9*Word' should be valid", 
                  loginInstance.checkPasswordComplexity("Complex9*Word"));
    }

    
     //Test checkPasswordComplexity with INCORRECT password entries
     
    @Test
    public void testCheckPasswordComplexity_IncorrectEntries() {
        System.out.println("Testing INCORRECT password entries");
        
        // Invalid: too short (less than 8 characters)
        assertFalse("'Pass1!' should be invalid (too short)", 
                   loginInstance.checkPasswordComplexity("Pass1!"));
        assertFalse("'Abc123#' should be invalid (7 characters)", 
                   loginInstance.checkPasswordComplexity("Abc123#"));
        assertFalse("'Test1@' should be invalid (6 characters)", 
                   loginInstance.checkPasswordComplexity("Test1@"));
        
        // Invalid: missing uppercase letter
        assertFalse("'password1!' should be invalid (no uppercase)", 
                   loginInstance.checkPasswordComplexity("password1!"));
        assertFalse("'mypass123#' should be invalid (no uppercase)", 
                   loginInstance.checkPasswordComplexity("mypass123#"));
        assertFalse("'hello123@world' should be invalid (no uppercase)", 
                   loginInstance.checkPasswordComplexity("hello123@world"));
        
        // Invalid: missing number
        assertFalse("'Password!' should be invalid (no number)", 
                   loginInstance.checkPasswordComplexity("Password!"));
        assertFalse("'MyPassword#' should be invalid (no number)", 
                   loginInstance.checkPasswordComplexity("MyPassword#"));
        assertFalse("'HelloWorld@' should be invalid (no number)", 
                   loginInstance.checkPasswordComplexity("HelloWorld@"));
        
        // Invalid: missing special character
        assertFalse("'Password1' should be invalid (no special char)", 
                   loginInstance.checkPasswordComplexity("Password1"));
        assertFalse("'MyPassword123' should be invalid (no special char)", 
                   loginInstance.checkPasswordComplexity("MyPassword123"));
        assertFalse("'HelloWorld123' should be invalid (no special char)", 
                   loginInstance.checkPasswordComplexity("HelloWorld123"));
        
        // Invalid: missing multiple requirements
        assertFalse("'password' should be invalid (missing uppercase, number, special)", 
                   loginInstance.checkPasswordComplexity("password"));
        assertFalse("'PASSWORD' should be invalid (missing number, special)", 
                   loginInstance.checkPasswordComplexity("PASSWORD"));
        assertFalse("'Password' should be invalid (missing number, special)", 
                   loginInstance.checkPasswordComplexity("Password"));
        assertFalse("'123456789' should be invalid (missing uppercase, special)", 
                   loginInstance.checkPasswordComplexity("123456789"));
        
        // Edge cases
        assertFalse("Empty string should be invalid", 
                   loginInstance.checkPasswordComplexity(""));
    }

    
    
    
     // Test checkContactNumber with CORRECT phone number entries
     
    @Test
    public void testCheckContactNumber_CorrectEntries() {
        System.out.println("Testing CORRECT phone number entries");
        System.setOut(standardOut); // Reset to see console output
        
        // Valid South African phone numbers: +27 followed by 9 digits
        assertTrue("'+27123456789' should be valid", 
                  loginInstance.checkContactNumber("+27123456789"));
        assertTrue("'+27987654321' should be valid", 
                  loginInstance.checkContactNumber("+27987654321"));
        assertTrue("'+27000000000' should be valid", 
                  loginInstance.checkContactNumber("+27000000000"));
        assertTrue("'+27111222333' should be valid", 
                  loginInstance.checkContactNumber("+27111222333"));
        assertTrue("'+27999888777' should be valid", 
                  loginInstance.checkContactNumber("+27999888777"));
        assertTrue("'+27555666444' should be valid", 
                  loginInstance.checkContactNumber("+27555666444"));
    }

    
     // Test checkContactNumber with INCORRECT phone number entries
     
    @Test
    public void testCheckContactNumber_IncorrectEntries() {
        System.out.println("Testing INCORRECT phone number entries");
        System.setOut(standardOut); // Reset to see console output
        
        // Invalid: null value
        assertFalse("null should be invalid", 
                   loginInstance.checkContactNumber(null));
        
        // Invalid: wrong country code
        assertFalse("'+26123456789' should be invalid (wrong country code)", 
                   loginInstance.checkContactNumber("+26123456789"));
        assertFalse("'+28123456789' should be invalid (wrong country code)", 
                   loginInstance.checkContactNumber("+28123456789"));
        assertFalse("'+1234567890' should be invalid (wrong country code)", 
                   loginInstance.checkContactNumber("+1234567890"));
        
        // Invalid: missing + symbol
        assertFalse("'27123456789' should be invalid (missing +)", 
                   loginInstance.checkContactNumber("27123456789"));
        assertFalse("'271234567890' should be invalid (missing +)", 
                   loginInstance.checkContactNumber("271234567890"));
        
        // Invalid: wrong length (too short)
        assertFalse("'+2712345678' should be invalid (too short - 11 chars)", 
                   loginInstance.checkContactNumber("+2712345678"));
        assertFalse("'+271234567' should be invalid (too short - 10 chars)", 
                   loginInstance.checkContactNumber("+271234567"));
        assertFalse("'+27123456' should be invalid (too short - 9 chars)", 
                   loginInstance.checkContactNumber("+27123456"));
        
        // Invalid: wrong length (too long)
        assertFalse("'+271234567890' should be invalid (too long - 13 chars)", 
                   loginInstance.checkContactNumber("+271234567890"));
        assertFalse("'+2712345678901' should be invalid (too long - 14 chars)", 
                   loginInstance.checkContactNumber("+2712345678901"));
        
        // Invalid: contains non-digit characters after +27
        assertFalse("'+27abc456789' should be invalid (contains letters)", 
                   loginInstance.checkContactNumber("+27abc456789"));
        assertFalse("'+2712345678a' should be invalid (contains letter at end)", 
                   loginInstance.checkContactNumber("+2712345678a"));
        assertFalse("'+27123-45-678' should be invalid (contains hyphens)", 
                   loginInstance.checkContactNumber("+27123-45-678"));
        assertFalse("'+27 123 456 789' should be invalid (contains spaces)", 
                   loginInstance.checkContactNumber("+27 123 456 789"));
        assertFalse("'+27123.456.789' should be invalid (contains dots)", 
                   loginInstance.checkContactNumber("+27123.456.789"));
        
        // Edge cases
        assertFalse("Empty string should be invalid", 
                   loginInstance.checkContactNumber(""));
        assertFalse("Only '+27' should be invalid", 
                   loginInstance.checkContactNumber("+27"));
        assertFalse("'+' alone should be invalid", 
                   loginInstance.checkContactNumber("+"));
    }

    
    
    
     // Test registerUser with correct username and password
     
    @Test
    public void testRegisterUser_CorrectEntries() {
        System.out.println("Testing registerUser with CORRECT entries");
        
        String validUsername = "kyl_1";
        String validPassword = "Password1!";
        
        String result = loginInstance.registerUser(validPassword, validUsername);
        
        assertTrue("Result should contain username success message", 
                  result.contains("Username successfully captured"));
        assertTrue("Result should contain password success message", 
                  result.contains("Password successfully captured"));
        assertFalse("Result should not contain error messages", 
                   result.contains("not correctly formatted"));
    }

    
     // Test registerUser with incorrect username and password
     
    @Test
    public void testRegisterUser_IncorrectEntries() {
        System.out.println("Testing registerUser with INCORRECT entries");
        
        String invalidUsername = "invalidusername"; // no underscore, too long
        String invalidPassword = "weak"; // too short, missing requirements
        
        String result = loginInstance.registerUser(invalidPassword, invalidUsername);
        
        assertTrue("Result should contain username error message", 
                  result.contains("Username is not correctly formatted"));
        assertTrue("Result should contain password error message", 
                  result.contains("Password is not correctly formatted"));
        assertFalse("Result should not contain success messages", 
                   result.contains("successfully captured"));
    }

    // ========== RETURN LOGIN STATUS TESTS ==========
    
    /**
     * Test returnLoginStatus with successful login
     */
    @Test
    public void testReturnLoginStatus_Success() {
        System.out.println("Testing login status - SUCCESS");
        
        String result = loginInstance.returnLoginStatus(true, "John", "Doe");
        String expected = "Welcome, John Doe, it is great to see you again.";
        
        assertEquals("Should return welcome message for successful login", expected, result);
    }

    
     //Test returnLoginStatus with failed login
     
    @Test
    public void testReturnLoginStatus_Failure() {
        System.out.println("Testing login status - FAILURE");
        
        String result = loginInstance.returnLoginStatus(false, "John", "Doe");
        String expected = "Username and/or password incorrect, please try again.";
        
        assertEquals("Should return error message for failed login", expected, result);
    }

    
    
    
     // Test username boundary cases
     
    @Test
    public void testUserName_BoundaryCases() {
        System.out.println("Testing username BOUNDARY cases");
        
        // Exactly 5 characters with underscore - should be valid
        assertTrue("'test_' should be valid (exactly 5 chars with underscore)", 
                  loginInstance.checkUserName("test_"));
        assertTrue("'a_bcd' should be valid (exactly 5 chars with underscore)", 
                  loginInstance.checkUserName("a_bcd"));
        
        // 6 characters with underscore - should be invalid
        assertFalse("'test_1' should be invalid (6 characters)", 
                   loginInstance.checkUserName("test_1"));
        
        // Single character with underscore
        assertTrue("'_' should be valid (single underscore)", 
                  loginInstance.checkUserName("_"));
        
        // Two characters with underscore
        assertTrue("'a_' should be valid (2 characters with underscore)", 
                  loginInstance.checkUserName("a_"));
        assertTrue("'_a' should be valid (2 characters with underscore)", 
                  loginInstance.checkUserName("_a"));
    }

    
     // Test password boundary cases
     
    @Test
    public void testPassword_BoundaryCases() {
        System.out.println("Testing password BOUNDARY cases");
        
        // Exactly 8 characters with all requirements - should be valid
        assertTrue("'Pass123!' should be valid (exactly 8 chars)", 
                  loginInstance.checkPasswordComplexity("Pass123!"));
        assertTrue("'Abc123#$' should be valid (exactly 8 chars)", 
                  loginInstance.checkPasswordComplexity("Abc123#$"));
        
        // 7 characters with all other requirements - should be invalid
        assertFalse("'Pass12!' should be invalid (7 characters)", 
                   loginInstance.checkPasswordComplexity("Pass12!"));
        
        // Very long password with all requirements - should be valid
        assertTrue("Long password should be valid", 
                  loginInstance.checkPasswordComplexity("ThisIsAVeryLongPassword123!@#"));
    }

    
     // Test phone number boundary cases
     
    @Test
    public void testPhoneNumber_BoundaryCases() {
        System.out.println("Testing phone number BOUNDARY cases");
        System.setOut(standardOut); // Reset to see console output
        
        // Exactly 12 characters (+27 + 9 digits) - should be valid
        assertTrue("'+27123456789' should be valid (exactly 12 chars)", 
                  loginInstance.checkContactNumber("+27123456789"));
        
        // 11 characters (+27 + 8 digits) - should be invalid
        assertFalse("'+2712345678' should be invalid (11 characters)", 
                   loginInstance.checkContactNumber("+2712345678"));
        
        // 13 characters (+27 + 10 digits) - should be invalid
        assertFalse("'+271234567890' should be invalid (13 characters)", 
                   loginInstance.checkContactNumber("+271234567890"));
        
        // Edge case with all zeros
        assertTrue("'+27000000000' should be valid (all zeros)", 
                  loginInstance.checkContactNumber("+27000000000"));
        
        // Edge case with all nines
        assertTrue("'+27999999999' should be valid (all nines)", 
                  loginInstance.checkContactNumber("+27999999999"));
    }

    /**
     * Test of checkUserName method, of class LOGIN.
     */
    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        String userName = "";
        LOGIN instance = new LOGIN();
        boolean expResult = false;
        boolean result = instance.checkUserName(userName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPasswordComplexity method, of class LOGIN.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "";
        LOGIN instance = new LOGIN();
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerUser method, of class LOGIN.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String pass = "";
        String name = "";
        LOGIN instance = new LOGIN();
        String expResult = "";
        String result = instance.registerUser(pass, name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkContactNumber method, of class LOGIN.
     */
    @Test
    public void testCheckContactNumber() {
        System.out.println("checkContactNumber");
        String contactNumber = "";
        LOGIN instance = new LOGIN();
        boolean expResult = false;
        boolean result = instance.checkContactNumber(contactNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginUser method, of class LOGIN.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        boolean checkName = false;
        boolean checkPassword = false;
        String passwrd = "";
        String userName = "";
        LOGIN instance = new LOGIN();
        boolean expResult = false;
        boolean result = instance.loginUser(checkName, checkPassword, passwrd, userName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnLoginStatus method, of class LOGIN.
     */
    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        boolean regStatus = false;
        String Firstname = "";
        String Lastname = "";
        LOGIN instance = new LOGIN();
        String expResult = "";
        String result = instance.returnLoginStatus(regStatus, Firstname, Lastname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}