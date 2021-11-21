package configuration;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Configuration_B {

    AgentInt proxy;
    public void setProxy(AgentInt agent){
        this.proxy = agent;
    }

    public void execute(){
        System.out.print("\n\nConfiguration_B - advisor: ");

        GenericXmlApplicationContext gctx = new GenericXmlApplicationContext();
        gctx.load(new ClassPathResource("configuration_B.xml"));
        gctx.refresh();

        Configuration_B configuration_b = gctx.getBean("configuration_b", Configuration_B.class);
        configuration_b.proxy.execute("agentArgument");
    }
}