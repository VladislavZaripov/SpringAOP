package configuration;

import introductions.Contact;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Configuration_C {

    Contact proxy;
    public void setProxy(Contact agent){
        this.proxy = agent;
    }

    public void execute(){
        System.out.println("\n\nConfiguration_C - introduction: ");

        GenericXmlApplicationContext gctx = new GenericXmlApplicationContext();
        gctx.load(new ClassPathResource("configuration_C.xml"));
        gctx.refresh();

        Configuration_C configuration_c = gctx.getBean("configuration_c", Configuration_C.class);
        configuration_c.proxy.execute();
    }
}