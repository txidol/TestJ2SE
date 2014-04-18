package di.java7.listing_3_9;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import di.java7.AgentFinder;

/**
 * Code for listing 3_9
 */
public class HollywoodService {

  @SuppressWarnings("unused")
private AgentFinder finder = null;

  @Inject
  public HollywoodService(@Named("primary") AgentFinder finder) {
    this.finder = finder;
  }
}
