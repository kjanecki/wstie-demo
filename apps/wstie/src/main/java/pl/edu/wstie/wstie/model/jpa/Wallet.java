package pl.edu.wstie.wstie.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wallet")
public class Wallet {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id", updatable = false, insertable = false)
    private Long userId;

    @Column(name = "funds")
    private Double funds;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
