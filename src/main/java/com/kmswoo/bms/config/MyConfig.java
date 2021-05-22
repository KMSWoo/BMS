package com.kmswoo.bms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/login","/login.html","/css/**","/fonts/**","/images/**","/js/**","/media/**");
////                .excludePathPatterns("/login","/login.html","/css/**","/static/**");/** "/static/**" is not stable */
//    }

}
