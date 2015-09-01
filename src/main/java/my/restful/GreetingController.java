package my.restful;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.MediaType;
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


    @ResponseBody
    @RequestMapping(value="/json", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Greeting getDescription(@RequestBody Greeting stats){
        System.out.println("Got it from RequestBody");
        try {
            Thread.sleep(10 * 1000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return stats;
    }


    @ResponseBody
    @RequestMapping("/plainjson")
    public Greeting getDescription(){
        System.out.print("Got it");
        return new Greeting(1,"asdf");
    }

//    @ResponseBody
//    @RequestMapping(value="/put", RequestType="")
//    public Greeting getDescription(){
//        System.out.print("Got it");
//        return new Greeting(1,"asdf");
//    }
}
