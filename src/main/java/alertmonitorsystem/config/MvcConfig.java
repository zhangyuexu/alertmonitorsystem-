package alertmonitorsystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/white_list/list").setViewName("white_list/list");
		registry.addViewController("/test_result/list").setViewName("test_result/list");
		registry.addViewController("/test_case/list").setViewName("test_case/list");
		registry.addViewController("/error_type/list").setViewName("error_type/list");
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/welcome").setViewName("welcome");
	}

	/**
	 * 拦截器
	 */
	/*@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new HandlerInterceptor() {
			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {

			}
		}).addPathPatterns("/**").excludePathPatterns("/login", "/register", "/user/login", "/user/register",
				"/mystatic/**", "/druid/**");
	}*/
}
