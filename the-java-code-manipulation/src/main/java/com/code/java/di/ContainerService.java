package com.code.java.di;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

  // 제네릭 메서드, 메서드 파라미터로 넘겨주는 객체 타입이 들어왔을 때, 해당 클래스 타입의 인스턴스를 리턴하고 싶을 때, 사용함
  public static <T> T getObject(Class<T> classType) {
    T instance = createInstance(classType);
    Arrays.stream(classType.getDeclaredFields()).forEach(f -> {
      if (f.getAnnotation(Inject.class) != null) {
        Object fieldInstance = createInstance(f.getType());
        f.setAccessible(true);
        try {
          f.set(instance, fieldInstance);
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    });
    return instance;
  }

  private static <T> T createInstance(Class<T> classType) {
    try {
      return classType.getConstructor(null).newInstance();
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }
}
