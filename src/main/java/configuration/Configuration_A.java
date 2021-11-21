package configuration;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Configuration_A {

    AgentInt proxy;
    public void setProxy(AgentInt agent){
        this.proxy = agent;
    }


    public void execute(){
        System.out.print("\nConfiguration_A - advice: ");

        GenericXmlApplicationContext gctx = new GenericXmlApplicationContext();
        gctx.load(new ClassPathResource("configuration_A.xml"));
        gctx.refresh();

        Configuration_A configuration_a = gctx.getBean("configuration_a", Configuration_A.class);
        configuration_a.proxy.execute("agentArgument");

    }
}