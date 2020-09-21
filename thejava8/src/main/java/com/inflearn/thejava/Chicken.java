package com.inflearn.thejava;

import java.lang.annotation.*;

/**
 * @author han
 */

@Retention(RetentionPolicy.RUNTIME) //언제까지 어노테이션을 유지시킬 수 있는 지 정할 수 있음.
@Target(ElementType.TYPE_USE) //제네릭에 한정시킬 수 있도록 targeting을 해준다.
@Repeatable(ChickenContainer.class)
public @interface Chicken {

    String value();

}
