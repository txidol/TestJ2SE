package di.java7;

import com.google.inject.Guice;
import com.google.inject.Injector;

import di.java7.AgentFinderModule;

import java.util.List;

/**
 * Code for listing 3_8
 */
public class HollywoodServiceClient {

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new AgentFinderModule());
    HollywoodServiceGuice hollywoodService = injector
        .getInstance(HollywoodServiceGuice.class);
    @SuppressWarnings("unused")
	List<Agent> agents = hollywoodService.getFriendlyAgents();
    // Do stuff with agents.
  }

}
