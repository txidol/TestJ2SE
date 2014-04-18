package di.java7;

import java.util.ArrayList;
import java.util.List;

/**
 * Code for listing 3_1
 */
public class SpreadsheetAgentFinder implements AgentFinder {

  /** The type of spreadsheet we are dealing with */
  private String type;

  /** The location of the spreadsheet */
  @SuppressWarnings("unused")
  private String path;

  /**
   * This method returns an empty list of agents for compilation sake
   * 
   * @return An empty list of Agents
   */
  @Override
  public List<Agent> findAllAgents() {
    List<Agent> agents = new ArrayList<>();
    // Lots of POI based implementation would go here
    Agent a = new Agent();
    a.setType(type);
    agents.add(a);
    return agents;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setPath(String path) {
    this.path = path;
  }

}