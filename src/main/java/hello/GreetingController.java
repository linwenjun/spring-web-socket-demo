package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import java.security.Principal;

@Controller
public class GreetingController {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message, Principal principal) throws Exception {
        String username = principal.getName();
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + username + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}
