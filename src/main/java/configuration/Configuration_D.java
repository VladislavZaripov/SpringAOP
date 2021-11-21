package configuration;

import introductions.Contact;
import introductions.SimpleDefaultIntroductionAdvisor;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

@Configuration
public class Configuration_D {

    @Bean
    public Contact agent() {
        Contact agent = new Contact();
        agent.setName("Vlad");
        return agent;
    }

    @Bean
    public Advisor advisor() {
        return new SimpleDefaultIntroductionAdvisor();
    }

    @Bean
    public ProxyFactoryBean bean() {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(agent());
        proxyFactoryBean.setProxyTargetClass(true);
        proxyFactoryBean.addAdvisor(advisor());
        return proxyFactoryBean;
    }

    public void execute() {
        System.out.println("\nConfiguration_D - introduction + JavaClass: ");

        GenericApplicationContext gctx = new AnnotationConfigApplicationContext(Configuration_D.class);

        Contact agent = gctx.getBean("agent", Contact.class);
        agent.execute();
    }
}