package com.jcourse.vlsnk.annotation;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface InArgument {
    Arguments value();
}
