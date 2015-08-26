package my.restful;

import org.apache.http.protocol.ResponseContent;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Chen Chao on 8/26/2015.
 */
public class SpringTemplateGet {


    public static void main(String ... args){

        postForObject();
    }

    public static void getForOjbect(){
        RestTemplate restTemplate = new RestTemplate();
        Greeting greeting = restTemplate.getForObject("http://localhost:8080/plainjson", Greeting.class);
        System.out.print(greeting);
    }


    public static void postForObject(){
        RestTemplate restTemplate = new RestTemplate();
        Greeting greeting = restTemplate.postForObject("http://localhost:8080/json", new Greeting(1, "test"), Greeting.class);
        System.out.print(greeting);
    }



}
