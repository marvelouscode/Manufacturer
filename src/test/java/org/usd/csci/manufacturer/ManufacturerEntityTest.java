/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usd.csci.manufacturer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.validation.Validator; // Importing the java Validator class
import javax.validation.ValidatorFactory; // Importing the java ValidatorFactory class

/**
 *
 * This class will test most of the methods located in ManufacturerEntity class
 * in order to ensure the code works as intended. We will specifically test the
 * following classes by providing both valid and invalid values - Name() -
 * State() - Phone() - Fax() - Email() - compareTo() - equals() - toString()
 *
 * @author Joseph Mammo
 */
public class ManufacturerEntityTest {

    // comment ...
    static private Validator validator;
    static private ManufacturerEntity manufacturer;

    /**
     *
     */
    public ManufacturerEntityTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * SetUp method -- instantiates the validator, and manufacturer classes.
     */
    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        manufacturer = new ManufacturerEntity();
        manufacturer.setManufacturerId(100);
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    // ----------------------------------------------------------------- //
    /**
     * This method tests the ManufacturerId method located in ManufacturerEntity
     * class using a valid id.
     */
    @Test
    public void testManufacturerID() {
        System.out.println("Test Valid manufacturer id");
        int manufacturerID = 19985678;
        manufacturer.setManufacturerId(manufacturerID);
        Set<ConstraintViolation<ManufacturerEntity>> errors = validator.validateProperty(manufacturer, "manufacturerId");
        assertTrue(errors.isEmpty());
    }

    /**
     * This method tests the ManufacturerId method located in ManufacturerEntity
     * class using a invalid id. (NEEDS CORRECTION)
     */
  /*  @Test
    public void testInvalidManufacturerID() {
        System.out.println("Test invalid manufacturer id");
        int manufacturerID = 0;
        manufacturer.setManufacturerId(manufacturerID);
        Set<ConstraintViolation<ManufacturerEntity>> errors = validator.validateProperty(manufacturer, "manufacturerId");
        // Printing error messages
        for (ConstraintViolation<ManufacturerEntity> anError : errors) {
            System.out.println("Error: " + anError.getMessage());
        }
        assertFalse(errors.isEmpty());
    }*/

    /**
     * This method tests the AddressLine1 method located in ManufacturerEntity
     * class using a valid address.
     */
    @Test
    public void testAddressLine1() {
        System.out.println("Test valid address 1");
        String addressline1 = "2001 S Summit Ave";
        manufacturer.setAddressline1(addressline1);
        Set<ConstraintViolation<ManufacturerEntity>> errors = validator.validateProperty(manufacturer, "addressline1");
        assertTrue(errors.isEmpty());
    }

    /**
     * This method tests the AddressLine1 method located in ManufacturerEntity
     * class using a invalid address.
     */
    @Test
    public void testInvalidAddressLine1() {
        System.out.println("Test valid address 1");
        String addressline1 = "2001 S Summit Ave In South Dakota";
        manufacturer.setAddressline1(addressline1);
        Set<ConstraintViolation<ManufacturerEntity>> errors = validator.validateProperty(manufacturer, "addressline1");
        // Printing error messages
        for (ConstraintViolation<ManufacturerEntity> anError : errors) {
            System.out.println("Error: " + anError.getMessage());
        }
        assertFalse(errors.isEmpty());
    }

    /**
     * This method tests the AddressLine2 method located in ManufacturerEntity
     * class using a valid address.
     */
    @Test
    public void testAddressLine2() {
        System.out.println("Test valid address 2");
        String addressline2 = "2001 S Summit Ave";
        manufacturer.setAddressline2(addressline2);
        Set<ConstraintViolation<ManufacturerEntity>> errors = validator.validateProperty(manufacturer, "addressline2");
        assertTrue(errors.isEmpty());
    }

    /**
     * This method tests the AddressLine2 method located in ManufacturerEntity
     * class using a invalid address.
     */
    @Test
    public void testInvalidAddressLine2() {
        System.out.println("Test valid address 2");
        String addressline2 = "2001 S Summit Ave IN Vermillion SD";
        manufacturer.setAddressline2(addressline2);
        Set<ConstraintViolation<ManufacturerEntity>> errors = validator.validateProperty(manufacturer, "addressline2");
        // Printing error messages
        for (ConstraintViolation<ManufacturerEntity> anError : errors) {
            System.out.println("Error: " + anError.getMessage());
        }
        assertFalse(errors.isEmpty());
    }

    /**
     * This method test tests the Name method located in ManufacturerEntity
     * class using a valid name.
     */
    @Test
    public void testName() {
        System.out.println("Test valid name");
        String name = "Apple software";
        manufacturer.setName(name);
        Set<ConstraintViolation<ManufacturerEntity>> errors = validator.validateProperty(manufacturer, "name");
        assertTrue(errors.isEmpty());
    }

    /**
     * This method tests the Name method located in ManufacturerEntity class
     * using an invalid name
     */
    @Test
    public void testInvalidName() {
        System.out.println("Test invalid name");
        String name = "apple software development company";
        manufacturer.setName(name);
        Set<ConstraintViolation<ManufacturerEntity>> errors = validator.validateProperty(manufacturer, "name");
        // Printing error messages
        for (ConstraintViolation<ManufacturerEntity> anError : errors) {
            System.out.println("Error: " + anError.getMessage());
        }
        assertFalse(errors.isEmpty());
    }

    /**
     * This method tests the State method located in ManufacturerEntity class
     * using a valid state
     */
    @Test
    public void testState() {
        System.out.println("Test valid state");
        String state = "SD";
        manufacturer.setState(state);
        Set<ConstraintViolation<ManufacturerEntity>> errors = validator.validateProperty(manufacturer, "state");
        assertTrue(errors.isEmpty());
    }

    /**
     * This method tests the State method located in ManufacturerEntity class
     * using an invalid state
     */
    @Test
    public void testInvalidState() {
        System.out.println("Test invalid state");
        String state = "S D";
        manufacturer.setState(state);
        Set<ConstraintViolation<ManufacturerEntity>> errors = validator.validateProperty(manufacturer, "state");

        // Printing error messages
        for (ConstraintViolation<ManufacturerEntity> anError : errors) {
            System.out.println("Error: " + anError.getMessage());
        }
        assertFalse(errors.isEmpty());
    }
//    
//    @Test
//    public void testbirthDate() throws ParseException{
//        System.out.println("Test birthdate");
//        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
//        Date bdate = formatter.parse("05/26/15");
//
//        manufacturer.setBirthDate(bdate);
//        Set<ConstraintViolation<ManufacturerEntity>> errors = validator.validateProperty(manufacturer, "birthDate");
//        assertTrue(errors.isEmpty());
//    }
//    
//      @Test
//    public void testInvalidBirthDate() throws ParseException {
//         System.out.println("Test invalid birthdate");
//        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
//        Date bdate = formatter.parse("05/26/17");
//        manufacturer.setBirthDate(bdate);
//        Set<ConstraintViolation<ManufacturerEntity>> errors = validator.validateProperty(manufacturer, "birthDate");
//
//        // Printing error messages
//        for (ConstraintViolation<ManufacturerEntity> anError : errors) {
//            System.out.println("Error: " + anError.getMessage());
//        }
//        assertFalse(errors.isEmpty());
//    }
    /**
     * This method tests the Zip method located in ManufacturerEntity class
     * using an valid zip
     */
    @Test
    public void testZipCode() {
        System.out.println("Test valid zipCode");
        String zip = "57069";
        manufacturer.setZip(zip);
        Set<ConstraintViolation<ManufacturerEntity>> errors = validator.validateProperty(manufacturer, "zip");
        assertTrue(errors.isEmpty());
    }

    /**
     * This method tests the Zip method located in ManufacturerEntity class
     * using an invalid zip
     */
    @Test
    public void testInvalidZipCode() {
        System.out.println("Test invalid zipCode");
        String zip = "5766556";
        manufacturer.setZip(zip);
        Set<ConstraintViolation<ManufacturerEntity>> errors = validator.validateProperty(manufacturer, "zip");

        // Printing error messages
        for (ConstraintViolation<ManufacturerEntity> anError : errors) {
            System.out.println("Error: " + anError.getMessage());
        }
        assertFalse(errors.isEmpty());
    }

    /**
     * This method tests the Phone method located in ManufacturerEntity class
     * using a valid phone
     */
    @Test
    public void testPhone() {
        System.out.println("Test valid phone number");
        String phone = "605-202-1117";
        manufacturer.setPhone(phone);
        Set<ConstraintViolation<ManufacturerEntity>> errors = validator.validateProperty(manufacturer, "phone");
        assertTrue(errors.isEmpty());

    }

    /**
     * This method tests the Phone method located in ManufacturerEntity class
     * using an invalid phone
     */
    @Test
    public void testInvalidPhone() {
        System.out.println("Test invalid phone number");
        String phone = "605-202-11173";
        manufacturer.setPhone(phone);
        Set<ConstraintViolation<ManufacturerEntity>> errors = validator.validateProperty(manufacturer, "phone");
        // Printing error messages
        for (ConstraintViolation<ManufacturerEntity> anError : errors) {
            System.out.println("Error: " + anError.getMessage());
        }
        assertFalse(errors.isEmpty());

    }

    /**
     * This method tests the Fax method located in ManufacturerEntity class
     * using a valid fax
     */
    @Test
    public void testFax() {
        System.out.println("Test valid fax number");
        String fax = "605-202-1117";
        manufacturer.setFax(fax);
        Set<ConstraintViolation<ManufacturerEntity>> errors = validator.validateProperty(manufacturer, "fax");
        assertTrue(errors.isEmpty());

    }

    /**
     * This method tests the Fax method located in ManufacturerEntity class
     * using an invalid fax
     */
    @Test
    public void testInvalidFax() {
        System.out.println("Test invalid fax number");
        String fax = "605-202-11173";
        manufacturer.setFax(fax);
        Set<ConstraintViolation<ManufacturerEntity>> errors = validator.validateProperty(manufacturer, "fax");
        // Printing error messages
        for (ConstraintViolation<ManufacturerEntity> anError : errors) {
            System.out.println("Error: " + anError.getMessage());
        }
        assertFalse(errors.isEmpty());

    }

    /**
     * This method tests the Email method located in ManufacturerEntity class
     * using a valid email
     */
    @Test
    public void testEmail() {
        System.out.println("Test valid email address");
        String email = "joseph@gmail.com";
        manufacturer.setEmail(email);
        Set<ConstraintViolation<ManufacturerEntity>> errors = validator.validateProperty(manufacturer, "email");
        assertTrue(errors.isEmpty());
    }

    /**
     * This method tests the Email method located in ManufacturerEntity class
     * using an invalid email
     */
    @Test
    public void testInvalidEmail() {
        System.out.println("Test invalid email address");
        String email = "Josimarvwl14@gmail.com";
        manufacturer.setEmail(email);
        Set<ConstraintViolation<ManufacturerEntity>> errors = validator.validateProperty(manufacturer, "email");
        // Printing error messages
        for (ConstraintViolation<ManufacturerEntity> anError : errors) {
            System.out.println("Error: " + anError.getMessage());
        }
        assertFalse(errors.isEmpty());
    }

    /**
     * Test of toString method, of class ManufacturerEntity.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String name = "Apple software";
        manufacturer.setName(name);
        String result = manufacturer.toString();
        assertEquals(name, result);
    }

    /**
     * Test of compareTo method, of class ManufacturerEntity by checking if
     * names are equal.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        ManufacturerEntity other = new ManufacturerEntity();
        other.setName("Joseph");
        ManufacturerEntity instance = new ManufacturerEntity();
        instance.setName("Joseph");
        int expResult = 0;
        int result = instance.compareTo(other);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class ManufacturerEntity by checking if one
     * name is less than the second name.
     */
    @Test
    public void testCompareToLess() {
        System.out.println("compareTo");
        ManufacturerEntity other = new ManufacturerEntity();
        other.setName("Joseph");
        ManufacturerEntity instance = new ManufacturerEntity();
        instance.setName("Josep");
        int expResult = -1;
        int result = instance.compareTo(other);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class ManufacturerEntity by checking if one
     * name is greater than the second one.
     */
    @Test
    public void testCompareToGreater() {
        System.out.println("compareTo");
        ManufacturerEntity other = new ManufacturerEntity();
        other.setName("Josep");
        ManufacturerEntity instance = new ManufacturerEntity();
        instance.setName("Joseph");
        int expResult = 1;
        int result = instance.compareTo(other);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ManufacturerEntity.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        ManufacturerEntity other = new ManufacturerEntity();
        other.setName("Apple");
        ManufacturerEntity instance = new ManufacturerEntity();
        instance.setName("Apple");
        boolean result = instance.equals(other);
        assertTrue(result);
    }

    /**
     * Test of equals method, of class ManufacturerEntity.
     */
    @Test
    public void testInvalidEquals() {
        System.out.println("equals");
        ManufacturerEntity other = new ManufacturerEntity();
        other.setName("Windows");
        ManufacturerEntity instance = new ManufacturerEntity();
        instance.setName("Apple");
        boolean result = instance.equals(other);
        assertFalse(result);
    }

    //-------------------------------------------------------------------//
//   /**
//     * Test of getManufacturerId method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testGetManufacturerId() {
//        System.out.println("getManufacturerId");
//        ManufacturerEntity instance = new ManufacturerEntity();
//        Integer expResult = null;
//        Integer result = instance.getManufacturerId();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setManufacturerId method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testSetManufacturerId() {
//        System.out.println("setManufacturerId");
//        Integer manufacturerId = null;
//        ManufacturerEntity instance = new ManufacturerEntity();
//        instance.setManufacturerId(manufacturerId);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getName method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testGetName() {
//        System.out.println("getName");
//        ManufacturerEntity instance = new ManufacturerEntity();
//        String expResult = "";
//        String result = instance.getName();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setName method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testSetName() {
//        System.out.println("setName");
//        String name = "";
//        ManufacturerEntity instance = new ManufacturerEntity();
//        instance.setName(name);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAddressline1 method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testGetAddressline1() {
//        System.out.println("getAddressline1");
//        ManufacturerEntity instance = new ManufacturerEntity();
//        String expResult = "";
//        String result = instance.getAddressline1();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setAddressline1 method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testSetAddressline1() {
//        System.out.println("setAddressline1");
//        String addressline1 = "";
//        ManufacturerEntity instance = new ManufacturerEntity();
//        instance.setAddressline1(addressline1);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAddressline2 method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testGetAddressline2() {
//        System.out.println("getAddressline2");
//        ManufacturerEntity instance = new ManufacturerEntity();
//        String expResult = "";
//        String result = instance.getAddressline2();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setAddressline2 method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testSetAddressline2() {
//        System.out.println("setAddressline2");
//        String addressline2 = "";
//        ManufacturerEntity instance = new ManufacturerEntity();
//        instance.setAddressline2(addressline2);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCity method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testGetCity() {
//        System.out.println("getCity");
//        ManufacturerEntity instance = new ManufacturerEntity();
//        String expResult = "";
//        String result = instance.getCity();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setCity method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testSetCity() {
//        System.out.println("setCity");
//        String city = "";
//        ManufacturerEntity instance = new ManufacturerEntity();
//        instance.setCity(city);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getState method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testGetState() {
//        System.out.println("getState");
//        ManufacturerEntity instance = new ManufacturerEntity();
//        String expResult = "";
//        String result = instance.getState();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setState method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testSetState() {
//        System.out.println("setState");
//        String state = "";
//        ManufacturerEntity instance = new ManufacturerEntity();
//        instance.setState(state);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getZip method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testGetZip() {
//        System.out.println("getZip");
//        ManufacturerEntity instance = new ManufacturerEntity();
//        String expResult = "";
//        String result = instance.getZip();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setZip method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testSetZip() {
//        System.out.println("setZip");
//        String zip = "";
//        ManufacturerEntity instance = new ManufacturerEntity();
//        instance.setZip(zip);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPhone method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testGetPhone() {
//        System.out.println("getPhone");
//        ManufacturerEntity instance = new ManufacturerEntity();
//        String expResult = "";
//        String result = instance.getPhone();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPhone method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testSetPhone() {
//        System.out.println("setPhone");
//        String phone = "";
//        ManufacturerEntity instance = new ManufacturerEntity();
//        instance.setPhone(phone);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFax method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testGetFax() {
//        System.out.println("getFax");
//        ManufacturerEntity instance = new ManufacturerEntity();
//        String expResult = "";
//        String result = instance.getFax();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setFax method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testSetFax() {
//        System.out.println("setFax");
//        String fax = "";
//        ManufacturerEntity instance = new ManufacturerEntity();
//        instance.setFax(fax);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEmail method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testGetEmail() {
//        System.out.println("getEmail");
//        ManufacturerEntity instance = new ManufacturerEntity();
//        String expResult = "";
//        String result = instance.getEmail();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setEmail method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testSetEmail() {
//        System.out.println("setEmail");
//        String email = "";
//        ManufacturerEntity instance = new ManufacturerEntity();
//        instance.setEmail(email);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getRep method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testGetRep() {
//        System.out.println("getRep");
//        ManufacturerEntity instance = new ManufacturerEntity();
//        String expResult = "";
//        String result = instance.getRep();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setRep method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testSetRep() {
//        System.out.println("setRep");
//        String rep = "";
//        ManufacturerEntity instance = new ManufacturerEntity();
//        instance.setRep(rep);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//
//    /**
//     * Test of hashCode method, of class ManufacturerEntity.
//     */
//    @Test
//    public void testHashCode() {
//        System.out.println("hashCode");
//        ManufacturerEntity instance = new ManufacturerEntity();
//        int expResult = 0;
//        int result = instance.hashCode();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
