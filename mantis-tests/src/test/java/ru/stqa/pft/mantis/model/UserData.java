package ru.stqa.pft.mantis.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@XStreamAlias("contact")
@Entity
@Table(name= "mantis_user_table")
public class UserData {
    @Id
    @Column(name ="id")
    private Integer id=Integer.MAX_VALUE;
    @Column(name="username")
    @Type(type="string")
    String username;
    @Column(name="email")
   @Type(type="string")
    String email;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
