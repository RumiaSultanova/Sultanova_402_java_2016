package ru.itis.inf.store;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.itis.inf.store.service.StoreService;
import ru.itis.inf.store.service.StoreServiceImpl;

/**
 * Created by rumia on 09.03.16.
 */
@Configuration
@EnableAspectJAutoProxy
//@EnableWebMvc
@ComponentScan("ru.itis.inf.store")
public class WebAppContext
//        extends WebMvcConfigurerAdapter
{

    @Bean
    public StoreService storeServiceMock(){
        return Mockito.mock(StoreService.class);
    }

    @Bean
    public StoreService storeServiceImpl(){
        return new StoreServiceImpl();
    }

/*
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
*/

}
