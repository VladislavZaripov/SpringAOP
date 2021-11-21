package configuration;

import org.springframework.stereotype.Component;

@Component("agent")
public class Agent implements AgentInt{

    public String execute(String agentArgument) {
        System.out.print("Agent");
        return "agentValue";
    }
}