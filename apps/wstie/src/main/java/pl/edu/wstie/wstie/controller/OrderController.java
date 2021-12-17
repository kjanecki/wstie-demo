package pl.edu.wstie.wstie.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wstie.wstie.model.dto.OrderDto;
import pl.edu.wstie.wstie.model.enumerated.OrderStatus;
import pl.edu.wstie.wstie.service.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping(path = "order")
    public List<OrderDto> getOrderByUserId(@RequestParam("userId") Long userId) {
        return orderService.getOrderByUserId(userId);
    }

}
