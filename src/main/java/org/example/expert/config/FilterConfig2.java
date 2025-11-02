package org.example.expert.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FilterConfig2 {

    //private final JwtUtil2 jwtUtil2;
    private final JwtUtil jwtUtil;

    @Bean
    public FilterRegistrationBean<Jwtfilter2> jwtFilter2() {
        FilterRegistrationBean<Jwtfilter2> registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new Jwtfilter2(jwtUtil));
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }

}
