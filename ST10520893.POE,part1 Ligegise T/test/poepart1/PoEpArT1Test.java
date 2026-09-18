package poepart1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit 4 tests for PoEpArT1 Registration class
 * Tests all getter/setter methods and validation integration
 * @author RC_Student_lab
 */
public class PoEpArT1Test {
    
    public PoEpArT1Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("=== Starting PoEpArT1 Registration Tests ===");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("=== PoEpArT1 Registration Tests Completed ===");
    }
    
    @Before
    public void setUp() {
        // Reset all static fields before each test to ensure test isolation
        PoEpArT1.setUserName(null);
        PoEpArT1.setPassword(null);
        PoEpArT1.setFirstname(null);
        PoEpArT1.setLastname(null);
        PoEpArT1.setContactNumber(null);
    }
    
    @After
    public void tearDown() {
        // Clean up after each test if needed
    }

    //USERNAME TESTS
    
    // Test setUserName and getUserName with CORRECT entries
    
    @Test
    public void testUserName_CorrectEntries() {
        System.out.println("Testing USERNAME - CORRECT entries");
        
        // Test valid usernames (will be validated by LOGIN class)
        String[] validUsernames = {"kyl_1"};
        
        for (String username : validUsernames) {
            PoEpArT1.setUserName(username);
            assertEquals("Username '" + username + "' should be set and retrieved correctly", 
                        username, PoEpArT1.getUserName());
        }
    }

    
     // Test setUserName and getUserName with INCORRECT entries
    
    @Test
    public void testUserName_IncorrectEntries() {
        System.out.println("Testing USERNAME - INCORRECT entries");
        
        // Test invalid usernames (these will fail LOGIN validation but setter should still work)
        String[] invalidUsernames = {
            "kyle1"
        };
        
        for (String username : invalidUsernames) {
            PoEpArT1.setUserName(username);
            assertEquals("Username '" + username + "' should be set even if invalid", 
                        username, PoEpArT1.getUserName());
        }
    }

    
    
     //Test setPassword and getPassword with CORRECT entries
     
    @Test
    public void testPassword_CorrectEntries() {
        System.out.println("Testing PASSWORD - CORRECT entries");
        
        // Test valid passwords (will pass LOGIN validation)
        String[] validPasswords = {
            "Password1!"
        };
        
        for (String password : validPasswords) {
            PoEpArT1.setPassword(password);
            assertEquals("Password '" + password + "' should be set and retrieved correctly", 
                        password, PoEpArT1.getPassword());
        }
    }

    
     // Test setPassword and getPassword with INCORRECT entries
     
    @Test
    public void testPassword_IncorrectEntries() {
        System.out.println("Testing PASSWORD - INCORRECT entries");
        
        // Test invalid passwords (these will fail LOGIN validation but setter should still work)
        String[] invalidPasswords = {
            "Pass1!"
        };
        
        for (String password : invalidPasswords) {
            PoEpArT1.setPassword(password);
            assertEquals("Password '" + password + "' should be set even if invalid", 
                        password, PoEpArT1.getPassword());
        }
    }

    
    
     // Test setContactNumber and getContactNumber with CORRECT entries
     
    @Test
    public void testContactNumber_CorrectEntries() {
        System.out.println("Testing CONTACT NUMBER - CORRECT entries");
        
        // Test valid South African phone numbers
        String[] validContacts = {
            "+27123456789",
            
        };
        
        for (String contact : validContacts) {
            PoEpArT1.setContactNumber(contact);
            assertEquals("Contact number '" + contact + "' should be set and retrieved correctly", 
                        contact, PoEpArT1.getContactNumber());
        }
    }

    
     //Test setContactNumber and getContactNumber with INCORRECT entries
     
    @Test
    public void testContactNumber_IncorrectEntries() {
        System.out.println("Testing CONTACT NUMBER - INCORRECT entries");
        
        // Test invalid phone numbers (these will fail LOGIN validation but setter should still work)
        String[] invalidContacts = {
            "+26123456789",    // wrong country code
            "27123456789",     // missing +
            "+2712345678",     // too short
            "+271234567890",   // too long
            "+27abc456789",    // contains letters
            "+27123-456-789",  // contains hyphens
            "+27 123 456 789", // contains spaces
            ""                 // empty string
        };
        
        for (String contact : invalidContacts) {
            PoEpArT1.setContactNumber(contact);
            assertEquals("Contact number '" + contact + "' should be set even if invalid", 
                        contact, PoEpArT1.getContactNumber());
        }
    }

    
    
    
     //Test setFirstname and getFirstname with various entries
     
    @Test
    public void testFirstname_VariousEntries() {
        System.out.println("Testing FIRSTNAME - various entries");
        
        String[] firstnames = {
            "John",
            "Jane",
            "Alice",
            "Bob",
            "Mary-Ann",        // with hyphen
            "Jean-Pierre",     // with hyphen
            "O'Connor",        // with apostrophe
            "李",               // non-English character
            "",                // empty string
            "A",               // single character
            "VeryLongFirstNameWithManyCharacters" // very long name
        };
        
        for (String firstname : firstnames) {
            PoEpArT1.setFirstname(firstname);
            assertEquals("Firstname '" + firstname + "' should be set and retrieved correctly", 
                        firstname, PoEpArT1.getFirstname());
        }
    }

    // ========== LASTNAME TESTS ==========
    
    /**
     * Test setLastname and getLastname with various entries
     */
    @Test
    public void testLastname_VariousEntries() {
        System.out.println("Testing LASTNAME - various entries");
        
        String[] lastnames = {
            "Doe",
            
        };
        
        for (String lastname : lastnames) {
            PoEpArT1.setLastname(lastname);
            assertEquals("Lastname '" + lastname + "' should be set and retrieved correctly", 
                        lastname, PoEpArT1.getLastname());
        }
    }

    
    
    
     // Test all setters and getters with null values
     
    @Test
    public void testAllFields_NullValues() {
        System.out.println("Testing ALL FIELDS - null values");
        
        // Test username
        PoEpArT1.setUserName(null);
        assertNull("Username should be null when set to null", PoEpArT1.getUserName());
        
        // Test password
        PoEpArT1.setPassword(null);
        assertNull("Password should be null when set to null", PoEpArT1.getPassword());
        
        // Test firstname
        PoEpArT1.setFirstname(null);
        assertNull("Firstname should be null when set to null", PoEpArT1.getFirstname());
        
        // Test lastname
        PoEpArT1.setLastname(null);
        assertNull("Lastname should be null when set to null", PoEpArT1.getLastname());
        
        // Test contact number
        PoEpArT1.setContactNumber(null);
        assertNull("Contact number should be null when set to null", PoEpArT1.getContactNumber());
    }

  
    
    
     // Test all setters and getters with empty strings
     
    @Test
    public void testAllFields_EmptyStrings() {
        System.out.println("Testing ALL FIELDS - empty strings");
        
        // Test username
        PoEpArT1.setUserName("");
        assertEquals("Username should handle empty strings", "", PoEpArT1.getUserName());
        
        // Test password
        PoEpArT1.setPassword("");
        assertEquals("Password should handle empty strings", "", PoEpArT1.getPassword());
        
        // Test firstname
        PoEpArT1.setFirstname("");
        assertEquals("Firstname should handle empty strings", "", PoEpArT1.getFirstname());
        
        // Test lastname
        PoEpArT1.setLastname("");
        assertEquals("Lastname should handle empty strings", "", PoEpArT1.getLastname());
        
        // Test contact number
        PoEpArT1.setContactNumber("");
        assertEquals("Contact number should handle empty strings", "", PoEpArT1.getContactNumber());
    }

    
    
     // Test setting and getting multiple values together - CORRECT scenario
     
    @Test
    public void testIntegration_CorrectEntries() {
        System.out.println("Testing INTEGRATION - all correct entries");
        
        // Set all valid values
        String validUsername = "kyl_1";
        String validPassword = "Password1!";
        String validFirstname = "John";
        String validLastname = "Doe";
        String validContact = "+27123456789";
        
        PoEpArT1.setUserName(validUsername);
        PoEpArT1.setPassword(validPassword);
        PoEpArT1.setFirstname(validFirstname);
        PoEpArT1.setLastname(validLastname);
        PoEpArT1.setContactNumber(validContact);
        
        // Verify all values are stored correctly
        assertEquals("Username should be stored correctly", validUsername, PoEpArT1.getUserName());
        assertEquals("Password should be stored correctly", validPassword, PoEpArT1.getPassword());
        assertEquals("Firstname should be stored correctly", validFirstname, PoEpArT1.getFirstname());
        assertEquals("Lastname should be stored correctly", validLastname, PoEpArT1.getLastname());
        assertEquals("Contact number should be stored correctly", validContact, PoEpArT1.getContactNumber());
    }

    /**
     * Test setting and getting multiple values together - INCORRECT scenario
     */
    @Test
    public void testIntegration_IncorrectEntries() {
        System.out.println("Testing INTEGRATION - all incorrect entries");
        
        // Set all invalid values (for validation purposes, but setters should still work)
        String invalidUsername = "invalidusername"; // no underscore + too long
        String invalidPassword = "weak";             // too short + missing requirements
        String invalidFirstname = "";               // empty string
        String invalidLastname = "";                // empty string
        String invalidContact = "1234567890";       // wrong format
        
        PoEpArT1.setUserName(invalidUsername);
        PoEpArT1.setPassword(invalidPassword);
        PoEpArT1.setFirstname(invalidFirstname);
        PoEpArT1.setLastname(invalidLastname);
        PoEpArT1.setContactNumber(invalidContact);
        
        // Verify all values are stored correctly (even though they're invalid)
        assertEquals("Invalid username should still be stored", invalidUsername, PoEpArT1.getUserName());
        assertEquals("Invalid password should still be stored", invalidPassword, PoEpArT1.getPassword());
        assertEquals("Empty firstname should be stored", invalidFirstname, PoEpArT1.getFirstname());
        assertEquals("Empty lastname should be stored", invalidLastname, PoEpArT1.getLastname());
        assertEquals("Invalid contact should still be stored", invalidContact, PoEpArT1.getContactNumber());
    }

    /**
     * Test setting and getting multiple values together - MIXED scenario
     */
    @Test
    public void testIntegration_MixedEntries() {
        System.out.println("Testing INTEGRATION - mixed correct/incorrect entries");
        
        // Mix of valid and invalid values
        String validUsername = "user_";              // valid
        String invalidPassword = "pass";             // invalid (too short)
        String validFirstname = "Alice";             // valid
        String validLastname = "Smith";              // valid
        String invalidContact = "+26123456789";      // invalid (wrong country code)
        
        PoEpArT1.setUserName(validUsername);
        PoEpArT1.setPassword(invalidPassword);
        PoEpArT1.setFirstname(validFirstname);
        PoEpArT1.setLastname(validLastname);
        PoEpArT1.setContactNumber(invalidContact);
        
        // Verify all values are stored correctly
        assertEquals("Valid username should be stored", validUsername, PoEpArT1.getUserName());
        assertEquals("Invalid password should still be stored", invalidPassword, PoEpArT1.getPassword());
        assertEquals("Valid firstname should be stored", validFirstname, PoEpArT1.getFirstname());
        assertEquals("Valid lastname should be stored", validLastname, PoEpArT1.getLastname());
        assertEquals("Invalid contact should still be stored", invalidContact, PoEpArT1.getContactNumber());
    }

   
    
    
     //Test integration with LOGIN class validation - CORRECT entries
     
    @Test
    public void testValidationIntegration_CorrectEntries() {
        System.out.println("Testing VALIDATION INTEGRATION - correct entries");
        
        LOGIN loginValidator = new LOGIN();
        
        // Set valid credentials
        String validUsername = "kyl_1";
        String validPassword = "Password1!";
        String validContact = "+27123456789";
        
        PoEpArT1.setUserName(validUsername);
        PoEpArT1.setPassword(validPassword);
        PoEpArT1.setContactNumber(validContact);
        
        // Test that stored values pass validation
        assertTrue("Stored username should pass validation", 
                  loginValidator.checkUserName(PoEpArT1.getUserName()));
        assertTrue("Stored password should pass validation", 
                  loginValidator.checkPasswordComplexity(PoEpArT1.getPassword()));
        assertTrue("Stored contact should pass validation", 
                  loginValidator.checkContactNumber(PoEpArT1.getContactNumber()));
    }

    
     // Test integration with LOGIN class validation - INCORRECT entries
     
    @Test
    public void testValidationIntegration_IncorrectEntries() {
        System.out.println("Testing VALIDATION INTEGRATION - incorrect entries");
        
        LOGIN loginValidator = new LOGIN();
        
        // Set invalid credentials
        String invalidUsername = "toolongusername";  // no underscore + too long
        String invalidPassword = "weak";             // too short + missing requirements
        String invalidContact = "1234567890";        // wrong format
        
        PoEpArT1.setUserName(invalidUsername);
        PoEpArT1.setPassword(invalidPassword);
        PoEpArT1.setContactNumber(invalidContact);
        
        // Test that stored values fail validation
        assertFalse("Stored username should fail validation", 
                   loginValidator.checkUserName(PoEpArT1.getUserName()));
        assertFalse("Stored password should fail validation", 
                   loginValidator.checkPasswordComplexity(PoEpArT1.getPassword()));
        assertFalse("Stored contact should fail validation", 
                   loginValidator.checkContactNumber(PoEpArT1.getContactNumber()));
    }

  
    
    
     // Test username boundary cases specific to storage/retrieval
     
    @Test
    public void testUserName_BoundaryStorage() {
        System.out.println("Testing USERNAME storage - boundary cases");
        
        // Test exactly 5 characters
        PoEpArT1.setUserName("test_");
        assertEquals("5-character username should be stored", "test_", PoEpArT1.getUserName());
        
        // Test exactly 6 characters (invalid but should still store)
        PoEpArT1.setUserName("test_1");
        assertEquals("6-character username should be stored", "test_1", PoEpArT1.getUserName());
        
        // Test single character
        PoEpArT1.setUserName("_");
        assertEquals("Single character username should be stored", "_", PoEpArT1.getUserName());
    }

    
     // Test password boundary cases specific to storage/retrieval
     
    @Test
    public void testPassword_BoundaryStorage() {
        System.out.println("Testing PASSWORD storage - boundary cases");
        
        // Test exactly 8 characters
        PoEpArT1.setPassword("Pass123!");
        assertEquals("8-character password should be stored", "Pass123!", PoEpArT1.getPassword());
        
        // Test exactly 7 characters (invalid but should still store)
        PoEpArT1.setPassword("Pass12!");
        assertEquals("7-character password should be stored", "Pass12!", PoEpArT1.getPassword());
        
        // Test very long password
        String longPassword = "ThisIsAVeryLongPasswordWithManyCharacters123!@#$%^&*()";
        PoEpArT1.setPassword(longPassword);
        assertEquals("Very long password should be stored", longPassword, PoEpArT1.getPassword());
    }

    
     // Test contact number boundary cases specific to storage/retrieval
     
    @Test
    public void testContactNumber_BoundaryStorage() {
        System.out.println("Testing CONTACT NUMBER storage - boundary cases");
        
        // Test exactly 12 characters (valid format)
        PoEpArT1.setContactNumber("+27123456789");
        assertEquals("12-character contact should be stored", "+27123456789", PoEpArT1.getContactNumber());
        
        // Test 11 characters (invalid but should still store)
        PoEpArT1.setContactNumber("+2712345678");
        assertEquals("11-character contact should be stored", "+2712345678", PoEpArT1.getContactNumber());
        
        // Test 13 characters (invalid but should still store)
        PoEpArT1.setContactNumber("+271234567890");
        assertEquals("13-character contact should be stored", "+271234567890", PoEpArT1.getContactNumber());
    }

        
    
     // Test handling of special characters in all fields
    
     
    @Test
    public void testSpecialCharacters_AllFields() {
        System.out.println("Testing SPECIAL CHARACTERS in all fields");
        
        // Test username with various special characters
        String specialUsername = "!@#_$";
        PoEpArT1.setUserName(specialUsername);
        assertEquals("Username with special chars should be stored", specialUsername, PoEpArT1.getUserName());
        
        // Test password with various special characters
        String specialPassword = "Pass123!@#$%^&*()";
        PoEpArT1.setPassword(specialPassword);
        assertEquals("Password with special chars should be stored", specialPassword, PoEpArT1.getPassword());
        
        // Test names with special characters
        String specialFirstname = "Mary-Ann O'Connor";
        String specialLastname = "van der Berg-Smith";
        PoEpArT1.setFirstname(specialFirstname);
        PoEpArT1.setLastname(specialLastname);
        assertEquals("Firstname with special chars should be stored", specialFirstname, PoEpArT1.getFirstname());
        assertEquals("Lastname with special chars should be stored", specialLastname, PoEpArT1.getLastname());
        
        // Test contact with invalid special characters
        String specialContact = "+27-123-456-789";
        PoEpArT1.setContactNumber(specialContact);
        assertEquals("Contact with special chars should be stored", specialContact, PoEpArT1.getContactNumber());
    }

    
    
    
     // Test handling of unicode and international characters
     
    @Test
    public void testUnicodeCharacters_AllFields() {
        System.out.println("Testing UNICODE CHARACTERS in all fields");
        
        // Test with various unicode characters
        String unicodeFirstname = "José";           // Spanish
        String unicodeLastname = "Müller";          // German
        String unicodeUsername = "user_李";          // Chinese character
        String unicodePassword = "Пароль123!";      // Cyrillic
        
        PoEpArT1.setFirstname(unicodeFirstname);
        PoEpArT1.setLastname(unicodeLastname);
        PoEpArT1.setUserName(unicodeUsername);
        PoEpArT1.setPassword(unicodePassword);
        
        assertEquals("Unicode firstname should be stored", unicodeFirstname, PoEpArT1.getFirstname());
        assertEquals("Unicode lastname should be stored", unicodeLastname, PoEpArT1.getLastname());
        assertEquals("Unicode username should be stored", unicodeUsername, PoEpArT1.getUserName());
        assertEquals("Unicode password should be stored", unicodePassword, PoEpArT1.getPassword());
    }

   
    
    
     // Final comprehensive test with realistic user data
     
    @Test
    public void testComprehensive_RealisticUserData() {
        System.out.println("Testing COMPREHENSIVE - realistic user data");
        
        // Scenario 1: Valid business user
        PoEpArT1.setFirstname("John");
        PoEpArT1.setLastname("Smith");
        PoEpArT1.setUserName("john_");
        PoEpArT1.setPassword("SecurePass123!");
        PoEpArT1.setContactNumber("+27823456789");
        
        assertEquals("Business user firstname", "John", PoEpArT1.getFirstname());
        assertEquals("Business user lastname", "Smith", PoEpArT1.getLastname());
        assertEquals("Business user username", "john_", PoEpArT1.getUserName());
        assertEquals("Business user password", "SecurePass123!", PoEpArT1.getPassword());
        assertEquals("Business user contact", "+27823456789", PoEpArT1.getContactNumber());
        
        // Scenario 2: International user
        PoEpArT1.setFirstname("María");
        PoEpArT1.setLastname("García");
        PoEpArT1.setUserName("mar_g");
        PoEpArT1.setPassword("MiClave456#");
        PoEpArT1.setContactNumber("+27876543210");
        
        assertEquals("International user firstname", "María", PoEpArT1.getFirstname());
        assertEquals("International user lastname", "García", PoEpArT1.getLastname());
        assertEquals("International user username", "mar_g", PoEpArT1.getUserName());
        assertEquals("International user password", "MiClave456#", PoEpArT1.getPassword());
        assertEquals("International user contact", "+27876543210", PoEpArT1.getContactNumber());
        
        // Scenario 3: User with complex names
        PoEpArT1.setFirstname("Jean-Pierre");
        PoEpArT1.setLastname("van der Merwe-Jones");
        PoEpArT1.setUserName("jp_vd");
        PoEpArT1.setPassword("Complex789$");
        PoEpArT1.setContactNumber("+27712345678");
        
        assertEquals("Complex firstname", "Jean-Pierre", PoEpArT1.getFirstname());
        assertEquals("Complex lastname", "van der Merwe-Jones", PoEpArT1.getLastname());
        assertEquals("Complex username", "jp_vd", PoEpArT1.getUserName());
        assertEquals("Complex password", "Complex789$", PoEpArT1.getPassword());
        assertEquals("Complex contact", "+27712345678", PoEpArT1.getContactNumber());
    }
}