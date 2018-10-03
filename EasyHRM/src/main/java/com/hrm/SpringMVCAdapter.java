package com.hrm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hrm.interceptor.AuthorizedInterceptor;

/**
 * 自定义拦截器
 * @author Mr.Z
 *
 */
@SpringBootConfiguration
public class SpringMVCAdapter implements WebMvcConfigurer {
	
	@Autowired
	private AuthorizedInterceptor authorized;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("拦截器执行");
		registry.addInterceptor(authorized).addPathPatterns("/*");
	}
	
}
