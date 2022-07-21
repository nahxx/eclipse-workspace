package com.varxyz.jvx330.di.example7;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.varxyz.jvx330.di.example7"})
// 이렇게 적으면 해당 패키지 안에 든 Bean을 자동으로 찾아줌..?
public class AppConfig {

}
