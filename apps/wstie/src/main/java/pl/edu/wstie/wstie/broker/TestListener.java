package pl.edu.wstie.wstie.broker;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TestListener {

    @RabbitListener(queues = "myQueue")
    public void listen(String in) {
        test(in);
    }

    public void test(String in){
        System.out.println("Message read from myQueue : " + in);

    }
}
