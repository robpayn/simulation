package org.payn.simulation;

import java.util.ArrayList;

import org.payn.simulation.interfaces.ISimulationManager;
import org.payn.simulation.interfaces.ISimulator;

/**
 * Manages the simulations that are necessary to perform a model analysis
 * 
 * @author robpayn
 *
 */
public class SimulationManager implements ISimulationManager {
    
    /**
     * List of simulators necessary to perform an analysis
     */
    protected ArrayList<ISimulator> simList;
    
    /**
     * Construct an instance
     */
    public SimulationManager()
    {
        simList = new ArrayList<ISimulator>();
    }
    
    /**
     * Add a simulator to the list to be executed 
     * 
     * @param sim
     *      simulator to be added
     */
    public void addSimulator(ISimulator sim)
    {
        simList.add(sim);
    }
    
    /**
     * Execute the simulators necessary to perform an analysis
     * 
    * @throws Exception 
     */
    public void execute() throws Exception
    {
        for (ISimulator sim: simList)
        {
            sim.execute();
        }
    }
    

  

}
