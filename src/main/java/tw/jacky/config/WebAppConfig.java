package tw.jacky.config;



import java.util.ArrayList;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


//對應mvc-servlet.xml的java程式組態
@Configuration
//<context:annotation-config/>

@EnableWebMvc
//<mvc:annotation-driven/>

@ComponentScan(basePackages = {"tw" ,"chitou"})
//<context:component-scan base-package="tw.leonchen"/>
public class WebAppConfig implements WebMvcConfigurer {
	
	@Bean
	public MappingJackson2JsonView jsonView() {
		MappingJackson2JsonView myJsonView = new MappingJackson2JsonView();
		myJsonView.setPrettyPrint(true);
		return myJsonView;
	}
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller jaxb2 = new Jaxb2Marshaller();
		jaxb2.setPackagesToScan("tw");
		return jaxb2;
	}
	
	@Bean
	public ContentNegotiatingViewResolver contentViewResolver() {
		ContentNegotiatingViewResolver cnvr1 = new ContentNegotiatingViewResolver();
		ArrayList<View> list = new ArrayList<View>();
		list.add(jsonView());
		cnvr1.setDefaultViews(list);
		return cnvr1;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		addresourcehandler加入的virtual url (security purpose)
//		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resources/images/");
//		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resources/css/");
	}



	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "membersmain.controller");
		
		
//		    <mvc:view-controller path="/happyfun.action" view-name="form"/>
		registry.addViewController("/happyfun.action").setViewName("form");
		
		
//	    <mvc:view-controller path="/resources.show" view-name="resourcesInfo"/> 一樣的概念
		registry.addViewController("/resources.show").setViewName("resourcesInfo");
		
		
	}	



	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
//	<mvc:default-servlet-handler/>
	
	
	
	//module.7
	//透過加入該組態設定虛擬路徑(邏輯名稱)
	//將view元件放在WEB-INF下，使用者就無法直接呼叫
	//internalResourceViewResolver則會設定裡面view的邏輯名稱
	//以後return jsp view就不需要加/和jsp可以直接呼叫檔案名稱
	//加入後就無法直接用.jsp檔run server 必須要開啟server後透過網址列呼叫Servlet 讓它return view給頁面
	//範例裡面把jsp檔丟到WEB-INF/pages裡面設立虛擬路徑
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver irvr1 = new InternalResourceViewResolver();
		//將虛擬路徑設定為:/WEB-INF/pages/後贅詞為.jsp的檔案，不在路徑內的就會找不到
		//所以檔案都要移到pages裡
//		irvr1.setPrefix("/WEB-INF/pages/");
		irvr1.setSuffix(".jsp");
		irvr1.setOrder(6);
		return irvr1;
	}
	//搭配loginSystemController.java
	//更改虛擬路徑後，呼叫loginSystem.jsp的方法改為啟動server->網址輸入http://localhost:8080/SpringMvcProject/loginsystemmain.controller呼叫LoginSystemController.java內的對應方法->return loginSystem

	
	
	
	//類似filter的角色，整體都調整成UTF-8
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver cmr = new CommonsMultipartResolver();
		cmr.setDefaultEncoding("UTF-8");
		return cmr;
	}


}
