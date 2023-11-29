package py.com.jmbr.mcs.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import py.com.jmbr.java.commons.context.RequestContextInitializer;

@Configuration
@EnableWebMvc
public class AppMvcConfig  implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestContextInitializer());
        WebMvcConfigurer.super.addInterceptors(registry);
    }



    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/","/swagger-ui.html");
    }
}
