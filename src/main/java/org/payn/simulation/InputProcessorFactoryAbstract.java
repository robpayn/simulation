package org.payn.simulation;

import org.payn.simulation.iteration.BayesAMMCMCMetaInput;

/**
 * Abstract definition of the input processor factory
 * 
 * @author robpayn
 *
 */
public abstract class InputProcessorFactoryAbstract implements InputProcessorFactory {
    
   /**
    * The simulator using this factory
    */
   protected Simulator simulator;
   
   /**
    * Create a new instance for the provided simulator
    * 
    * @param simulator
    *       simulator object
    */
   public InputProcessorFactoryAbstract(Simulator simulator) 
   {
      this.simulator = simulator;
   }

   /**
     * Set the simulator that uses the factory
     */
    @Override
    public void setSimulator(Simulator simulator)
    {
        this.simulator = simulator;
    }
    
    /**
     * Get the simulator for this input processor factory
     * 
     * @return
     *      simulator object
     */
    @Override
    public Simulator getSimulator()
    {
       return simulator;
    }
    
    public void addBayesAMMCMC(BayesAMMCMCMetaInput metaInput) throws Exception 
    {
       
    }

}
