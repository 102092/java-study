package com.inflearn.thejava;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author han
 */
@Retention(RetentionPolicy.RUNTIME) //언제까지 어노테이션을 유지시킬 수 있는 지 정할 수 있음.
@Target(ElementType.TYPE_USE)
public @interface ChickenContainer {

    Chicken[] value();// 자기 자신이 감싸고 있을 애노테션을 배열로 정의해놓으면 된다.
}
