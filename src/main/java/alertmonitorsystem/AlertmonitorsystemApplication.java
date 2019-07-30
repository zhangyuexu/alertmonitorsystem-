package alertmonitorsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ServletComponentScan
//@EnableScheduling
@EnableAsync
@EnableCaching
@MapperScan("alertmonitorsystem.mapper")
public class AlertmonitorsystemApplication extends SpringBootServletInitializer implements CommandLineRunner {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AlertmonitorsystemApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(AlertmonitorsystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等初始化操作<<<<<<<<<<<<<");
	}
}
