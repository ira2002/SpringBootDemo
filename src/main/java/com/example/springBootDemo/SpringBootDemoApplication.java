package com.example.springBootDemo;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * SpringBoot 内置tomcat 启动入口
 * 	注：本类所在的位置很重要，在启动时会自动扫描当前同级目录下的包及其子包的注解类，应该放在与controller、service、dao等包同目录下
 *  使用外置tomcat部署：
 * 	1、在启动类中继承SpringBootServletInitializer并实现configure方法：
 * 		这个类的作用与在web.xml中配置负责初始化Spring应用上下文的监听器作用类似，只不过在这里不需要编写额外的XML文件了。
 * 	2、pom.xml修改tomcat相关的配置,屏蔽tomcat
	3,外部tomcat默认静态资源目录为/webapp/	
	4,打包war的时候，过滤tomcat依赖，需要添加<scope>provided</scope>
 * 	
 * @author	chdaba
 * @version	1.0.0
 * @date	2018年12月25日 上午11:28:32
 */
//@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />然后在访问数据库的Service方法上添加注解 @Transactional 便可。
@SpringBootApplication
public class SpringBootDemoApplication extends SpringBootServletInitializer {
	 private static final Logger logger = Logger.getLogger(SpringBootDemoApplication.class);

	/**
	 * 内置tomcat 启动入口
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
		logger.debug("启动成功!");
		
	}
	
	/**
	 * 外部tomcat需要重写该方法, 替代web.xml配置文件效果
	 */
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootDemoApplication.class);
    }
}
