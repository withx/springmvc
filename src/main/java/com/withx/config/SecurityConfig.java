package com.withx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager users = new InMemoryUserDetailsManager();
        users.createUser(User.withUsername("admin").password("{noop}123").roles("admin").build());
        users.createUser(User.withUsername("root").password("{noop}123").roles("admin").build());
        return users;
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return new WebSecurityCustomizer() {
            @Override
            public void customize(WebSecurity web) {
                web.ignoring().antMatchers("/api-document/**");
                web.ignoring().antMatchers("/pages/**");
                web.ignoring().antMatchers("/js/**");
                web.ignoring().antMatchers("/css/**");
                web.ignoring().antMatchers("/img/**");
                web.ignoring().antMatchers("/plugins/**");
            }
        };
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/swagger-ui/**").authenticated()
                .antMatchers("/**").permitAll()
                .antMatchers("/hello/**").hasRole("ADMIN")      // url에 따른 권한만 허용
                .antMatchers("/books/**").hasRole("MEMBER")     // url에 따른 권한만 허용
                .and()
                .formLogin()
                .usernameParameter("username")                  // 지정하고 싶은 username name 명칭이며, 기본은 username
                .passwordParameter("password")                  // 지정하고 싶은 password name 명칭이며, 기본은 password
                .defaultSuccessUrl("/swagger-ui/index.html")    // 로그인 성공 시 이동페이지
                .permitAll()
                .and()
                .csrf()                                         // csrf 사용
                .ignoringAntMatchers("/h2-console/**")          // csrf 제외 url
                .ignoringAntMatchers("/post/**")                // csrf 제외 url
                .ignoringAntMatchers("/admin/**")               // csrf 제외 url
                .and()
                .csrf().disable();
        return http.build();
    }
        /*
        http
                .csrf().disable()                           // csrf를 사용할지 여부
                .authorizeRequests()                        // HttpServletRequest에 따라접근을 제한
                .antMatchers("/hello/**").hasRole("ADMIN")  // url에 따른 권한만 허용
                .antMatchers("/books/**").hasRole("MEMBER")    // url에 따른 권한만 허용
                .antMatchers("/**").permitAll()             // url에 따른 모두 허용
                .and()
                .formLogin()                                // form 기반 로그인 인증 관련하며 HttpSession 이용
                .loginPage("/login")                        // 지정하고 싶은 로그인 페이지 url
                .usernameParameter("email")                 // 지정하고 싶은 username name 명칭이며, 기본은 username
                .passwordParameter("upwd")                  // 지정하고 싶은 password name 명칭이며, 기본은 password
                .permitAll()                                // 모두 접근 허용
                .and()
                .logout() // 로그아웃
                .logoutRequestMatcher(new AntPathRequestMatcher(("/logout"))) // 지정하고 싶은 로그아웃 url
                .logoutSuccessUrl("/index")                 // 성공 시 이동 페이지
                .invalidateHttpSession(true)                // 세션 초기화
                .deleteCookies("cookies")                 // 특정 쿠키를 제거
                .and()
                .exceptionHandling()                        // 에러 처리
                .accessDeniedPage("/error");                // 에러 시 이동할 페이지
         */
}
