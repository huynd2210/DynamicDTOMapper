package mapper;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DynamicDTOMapper {
  private DynamicDTOMapper() {
  }

  public static <T> T map(Map<String, Object> source, Class<T> targetClass)
          throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    T target = targetClass.getDeclaredConstructor().newInstance();
    Field[] classFields = targetClass.getDeclaredFields();
    // Get all methods from target class and convert to lowercase for case-insensitive comparison
    List<String> declaredMethodNames =
            Arrays.stream(targetClass.getDeclaredMethods())
                    .map(Method::getName)
                    .map(String::toLowerCase).collect(Collectors.toList());
    //set field values
    for (Field classField : classFields) {
      String setterMethod = "set" + StringUtils.capitalize(classField.getName());
      if (source.containsKey(classField.getName())
              && declaredMethodNames.contains(setterMethod.toLowerCase())) {
        //call setter method
        Method tmp = targetClass.getDeclaredMethod(setterMethod, source.get(classField.getName()).getClass());
        tmp.invoke(target, source.get(classField.getName()));

      }
    }
    return target;
  }
}