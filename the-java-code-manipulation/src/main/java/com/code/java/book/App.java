package com.code.java.book;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {

  public static void main(String[] args)
      throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
    Class<?> bookClass = Class.forName("com.code.java.book.Book");
    // bookClass.newInstance(); deprecated 권장하지 않는

    Constructor<?> constructor = bookClass.getConstructor(String.class);
    Book book = (Book) constructor.newInstance("Book");
    System.out.println(book);

    Field field = Book.class.getDeclaredField("B");
    field.setAccessible(true);
    System.out.println(field.get(book));
    field.set(book, "BBBBBB");
    System.out.println(field.get(book));

    Method c = Book.class.getDeclaredMethod("c");
    c.setAccessible(true);
    c.invoke(book);
  }

}
