package pl.edu.wstie.wstie.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wstie.wstie.model.dto.OrderDto;
import pl.edu.wstie.wstie.model.dto.ProductDto;
import pl.edu.wstie.wstie.model.enumerated.OrderStatus;
import pl.edu.wstie.wstie.model.jpa.Order;
import pl.edu.wstie.wstie.model.jpa.OrderProduct;
import pl.edu.wstie.wstie.model.jpa.Product;
import pl.edu.wstie.wstie.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public List<OrderDto> getOrderByUserId(Long userId) {
        return repository.findAllByUserId(userId).stream()
                .filter(order -> order.getStatus() == OrderStatus.COMPLETED)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public OrderDto mapToDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .creationDate(order.getCreationDate())
                .paymentStatus(order.getPaymentStatus())
                .userId(order.getUserId())
                .status(order.getStatus())
                .products(order.getOrderProducts().stream().map(this::mapToDto).collect(Collectors.toList()))
                .build();
    }

    public ProductDto mapToDto(OrderProduct orderProduct) {
        return ProductDto.builder()
                .id(orderProduct.getProduct().getId())
                .name(orderProduct.getProduct().getName())
                .price(orderProduct.getProduct().getPrice())
                .purchasePrice(orderProduct.getPurchasePrice())
                .build();
    }


}
