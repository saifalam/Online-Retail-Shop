/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package retailshop;

/**
 *
 * @author rahat
 */
public class Login {

    private int uid;
    private String firstName;
    private String lastName;
    private String email;
    private String type;
    private String password;
    private String address;
    private String contact;

    public int getUid() {
        return uid;
    }

    public void setUid(int cid) {
        this.uid = cid;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
}
