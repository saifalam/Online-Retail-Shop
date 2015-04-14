/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package retailshop;

/**
 *
 * @author rahat
 */
public class CustomerDetails {

    private int id;
    private String firstName;
    private String lastName;
    private String contact;
    private String email;
    private String address;
    private String type;

    public CustomerDetails() {
        id = 0;
        firstName = null;
        lastName = null;
        contact = null;
        email = null;
        address = null;
        type = null;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
