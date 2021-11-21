package pointcuts;

public class Agent {

    @AdviceRequired
    public String execute(String agentArgument){
        System.out.print("Agent");
        return "agentValue";
    }
}