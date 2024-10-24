package bank;
/**
 * @author Kevin Porras
 * @author Alex Sedeno-Gonzalez
 * 
 * 
 * @version
 * 
 * Date: October 23, 2024
 * Course: Advance Object Oriented Programming
 * Instructor: Gurijala, Bhanukiran
 * Project Part 1
 * 
 * The `Person` class represents a person with basic information such as name, identification, contact details, 
 * and date of birth. This class is intended to be an abstract class and serves as a base for more specific 
 * person types.
 */
public abstract class Person {
    private String firstName;
    private String lastName;
    private String id;
    private String phoneNumber;
    private String DOB;
    private String address;

    /**
     * Constructs a `Person` object with the specified details.
     *
     * @param firstName   The first name of the person.
     * @param lastName    The last name of the person.
     * @param id          The identification number or string of the person.
     * @param phoneNumber The phone number of the person.
     * @param DOB         The date of birth of the person.
     * @param address     The address of the person.
     */

    Person(String firstName, String lastName, String id, String phoneNumber, String DOB, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id =id;
        this.phoneNumber= phoneNumber;
        this.DOB = DOB;
        this.address = address;
    }

    /**
     * Returns the first name of the person.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Returns the last name of the person.
     *
     * @return The last name.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Returns the identification number or string of the person.
     *
     * @return The ID.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Returns the phone number of the person.
     *
     * @return The phone number.
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Returns the date of birth of the person.
     *
     * @return The date of birth.
     */
    public String getDOB() {
        return this.DOB;
    }

    /**
     * Returns the address of the person.
     *
     * @return The address.
     */
    public String getAddress() {
        return this.address;
    }
}