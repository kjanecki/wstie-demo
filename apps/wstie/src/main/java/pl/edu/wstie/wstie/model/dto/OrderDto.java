package pl.edu.wstie.wstie.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.wstie.wstie.model.enumerated.OrderPaymentStatus;
import pl.edu.wstie.wstie.model.enumerated.OrderStatus;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private Long userId;
    private Date creationDate;
    private OrderStatus status;
    private OrderPaymentStatus paymentStatus;
    private List<ProductDto> products;

}
