package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


//Questa classe è annotata con l'annotazione @Configuration, per indicare al framework Spring che si tratta di una
//classe di configurazione. L'annotazione @ComponentScan dice a Spring di cercare le classi di configurazione nei
//package config, controller, service.
//In questa classe, creiamo semplicemente un view resolver bean, che specifica il prefisso e il suffisso da utilizzare coi
//view file. Quindi, le View della web app, ossia i file JSP, andranno create nella directory webapp/view.
//Ovviamente, in questa classe possiamo aggiungere tutte le configurazioni di Spring MVC che si desiderano.


@Configuration
@ComponentScan({ "config, controller, service" })
public class WebMvcConfig {
	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/customer/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
