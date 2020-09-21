package com.inflearn.thejava;

import java.util.Arrays;

/**
 * @author han
 */
@Chicken("양념")
@Chicken("후라이드") //중복해서 에노테이션을 선언할 수 있고,
public class App {

    public static void main(String[] args) {
        Chicken[] annotationsByType = App.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(annotationsByType).forEach(c -> System.out.println(c.value()));
        ChickenContainer annotation = App.class.getAnnotation(ChickenContainer.class);
        Chicken[] value = annotation.value();
        Arrays.stream(value).forEach(chicken -> System.out.println(chicken.value()));
    }
}
