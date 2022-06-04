/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dql.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Acer
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement //de quan li giao tac(session) 
@ComponentScan(basePackages = {
    "com.dql.repository",
    "com.dql.service"
}) //chi dinh 1 so bean
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationSuccessHandler dangNhapThanhCong;
    @Autowired
    private LogoutSuccessHandler dangXuatThanhCong;

    //phương thức băm mật khẩu
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Cung cấp thông tin chứng thực
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    //Phân quyền 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //lien ket voi form 
        http.formLogin().loginPage("/dangNhap")
                .usernameParameter("taiKhoan")
                .passwordParameter("matKhau");

        //dang nhap thanh cong thi
        //dang nhap that bai thi
        http.formLogin()
                //thanh cong ve trang chu
                .defaultSuccessUrl("/")
                //that bai o yen day
                .failureUrl("/dangNhap?error");
        
        
        http.formLogin().successHandler(this.dangNhapThanhCong);
        
        //logout
        http.logout().logoutSuccessUrl("/dangNhap");
        http.logout().logoutSuccessHandler(this.dangXuatThanhCong);

        //kiem tra co quyen để truy cập k
        http.exceptionHandling()
                .accessDeniedPage("/dangNhap?accessDenied");

        //cấu hình quyền 
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/nhanVien/**").access("hasAnyRole('ROLE_MANAGE', 'ROLE_ADMIN')");

        http.csrf().disable();
    }

    //nap truoc de khi no quet cac cau hinh k bi loi
    //cau hinh de ket noi voi cloudinary
    @Bean
    public Cloudinary cloudinary() {
        Cloudinary c = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "xxxs1mplexxx",
                "api_key", "929613542259299",
                "api_secret", "4Uo-2dgKzAMvs0BR6zLvjJuSvJA",
                "secure", true));
        return c;
    }
    
    //tao doi tuong
    @Bean
    public AuthenticationSuccessHandler dangNhapThanhCong(){
        return new XuLyDangNhapThanhCong();
    }
    
    @Bean
    public LogoutSuccessHandler dangXuatThanhCong(){
        return new XuLyDangXuat();
    }
}
