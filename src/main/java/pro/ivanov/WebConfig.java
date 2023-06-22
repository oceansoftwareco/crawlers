package pro.ivanov;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import org.springframework.web.servlet.view.JstlView;

import java.util.List;

// TODO
// https://github.com/bgjug/jprime/blob/master/src/main/java/site/app/Application.java
@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfig implements WebMvcConfigurer {
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();

		resolver.setSuffix(".jsp");
		resolver.setPrefix("/WEB-INF/");
		resolver.setViewClass(JstlView.class);

		return resolver;
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new PageableHandlerMethodArgumentResolver());
	}
}
