package pl.edu.wstie.wstie.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.wstie.wstie.model.enumerated.OrderPaymentStatus;
import pl.edu.wstie.wstie.model.enumerated.OrderStatus;
import pl.edu.wstie.wstie.model.enumerated.ProductCategory;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private OrderPaymentStatus paymentStatus;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "order")
    private Set<OrderProduct> orderProducts;
}
