package pl.edu.wstie.wstie.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "name")
    private String name;

    @Column(name = "registration_date")
    private Date registrationDate;

    @OneToOne(targetEntity = Wallet.class, mappedBy = "user")
    private Wallet wallet;

    @OneToMany(targetEntity = Order.class)
    private List<Order> orders;

}
