package my.restful;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }


//     controller
//    @ResponseBody
//    @RequestMapping("/json")
//    public Greeting getDescription(@RequestBody Greeting stats){
//        System.out.print("Got it");
//        return stats;
//    }


    @ResponseBody
    @RequestMapping("/json")
    public Greeting getDescription(){
        System.out.print("Got it");
        return new Greeting(1,"asdf");
    }
}
