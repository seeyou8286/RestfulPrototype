package my.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Chen Chao on 9/1/2015.
 */
public class ObjectToJson {

    public static void main(String... args) throws JsonProcessingException {
        InnerObject innerObject= new ObjectToJson().new InnerObject();

//        innerObject.setName("James");
        innerObject.setAge(31);

        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writeValueAsString(innerObject));

    }


     public class InnerObject{
         @JsonInclude(JsonInclude.Include.NON_EMPTY)
         public String name;
         public Integer age;

         public void setName(String name) {
             this.name = name;
         }

         public void setAge(Integer age) {
             this.age = age;
         }
     }

}
