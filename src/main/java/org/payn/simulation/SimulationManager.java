package org.payn.simulation;

import java.util.ArrayList;

import org.payn.simulation.interfaces.ISimulationManager;

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
    protected ArrayList<Simulator> simList;
    
    /**
     * Construct an instance
     */
    public SimulationManager()
    {
        simList = new ArrayList<Simulator>();
    }
    
    /**
     * Add a simulator to the list to be executed 
     * 
     * @param sim
     *      simulator to be added
     */
    public void addSimulator(Simulator sim)
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
        for (Simulator sim: simList)
        {
            sim.execute();
        }
    }
    

  

}
