package com.wisdom.weixin.interceptor;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * Created by zbm84 on 2017/5/24.
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Mapping
@Documented
public @interface LoginAnnotations {
}
