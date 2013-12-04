package di.java7;

import com.google.inject.AbstractModule;

/**
 * Code for listing 3_7 - AgentFinder interface
 */
public class AgentFinderModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(AgentFinder.class).to(WebServiceAgentFinder.class);
  }

}