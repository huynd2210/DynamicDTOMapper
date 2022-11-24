package mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class main {
//example usage
//  @PostMapping("/api/user/registerDynamic")
//  public void test(@RequestBody String json)
//          throws JsonProcessingException, InvocationTargetException,
//          NoSuchMethodException, InstantiationException, IllegalAccessException {
//    Map<String, Object> result = new ObjectMapper().readValue(json, Map.class);
//    User user = DynamicDTOMapper.map(result, User.class);
//    System.out.println("json converted to map<string, object>: " + result);
//    System.out.println(user);
//  }

  public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, JsonProcessingException {

    String json = "{\n" +
            " \"email\":\"studi@hs-da.de\",\n" +
            " \"password\":\"secret\",\n" +
            " \"firstName\":\"Thomas\",\n" +
            " \"lastName\":\"Müller\",\n" +
            " \"phone\":\"069-123456\",\n" +
            " \"location\":\"Darmstadt\"\n" +
            "}";
    Map<String, Object> result = new ObjectMapper().readValue(json, Map.class);
    User user = DynamicDTOMapper.map(result, User.class);
    System.out.println("json converted to map<string, object>: " + result);
    System.out.println(user);
  }
}
