package component.entities;

import javax.persistence.*;

@Entity
@Table(name = "details")
public class Details {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="city")
    private String city;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="email")
    private String email;

    @OneToOne(mappedBy = "empDetails", cascade = CascadeType.ALL)
    private Employee employee;


    public Details(String city, String phoneNumber, String email) {
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Details() {
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
