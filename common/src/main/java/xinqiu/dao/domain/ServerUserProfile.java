package xinqiu.dao.domain;

import xinqiu.enumtype.Gender;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class ServerUserProfile extends BaseModel{

    @Size(max = 32)
    private String firstName;

    @Size(max = 32)
    private String lastName;

    @Size(max = 15)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Size(max = 100)
    private String address;

    @Size(max = 100)
    private String street;

    @Size(max = 100)
    private String city;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private ServerUser serverUser;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ServerUser getServerUser() {
        return serverUser;
    }

    public void setServerUser(ServerUser serverUser) {
        this.serverUser = serverUser;
    }
}
