package web.backtospring.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

// import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
public class Member {


    @Id
    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String phone;

    @NotEmpty
    private String city;

    @NotEmpty
    private String description;
    
    @Column(nullable = true, length = 64)
    private String photo;

    // private byte[] imagedata;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "MEMBER_ROLES", joinColumns = {
            @JoinColumn(name = "MEMBER_EMAIL", referencedColumnName = "email")}, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_NAME", referencedColumnName = "name") })
    private List<Role> role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    // public byte[] getImagedata() {
    //     return imagedata;
    //  }
    //  public void setImagedata(byte[] imagedata) {
    //     this.imagedata = imagedata;
    //  }

    @Transient
    public String getPhotosImagePath() {
        if (photo == null || email == null) return null;
         
        return "/user-photos/" + email + "/" + photo;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public Member(String email, String firstName, String lastName, String password ,String phone ,String city , String description , String photo, byte[] imagedata) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.city = city;
        this.description = description;
        this.photo = photo;
        // this.imagedata = imagedata;
    }

    public Member() {
    }

	public Member get() {
		return null;
	}
}