package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.SimpleMessageConverter;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
@RequestMapping("/rest")
public class GreetingRestController {

    @Autowired
    private SimpMessagingTemplate template;

    @RequestMapping(value="/hello")
    public String greeting() {
        String message = "Hello, This message from http";
        this.template.convertAndSend("/topic/greetings", new Greeting("Hello!"));
        return "hello";
    }
}
