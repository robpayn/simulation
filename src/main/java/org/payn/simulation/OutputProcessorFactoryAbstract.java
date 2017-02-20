package org.payn.simulation;

/**
 * Abstract implementation of the output processor factory
 * 
 * @author robpayn
 *
 */
public abstract class OutputProcessorFactoryAbstract implements OutputProcessorFactory {
    
    /**
     * Simulator associated with this factory
     */
    protected Simulator simulator;
    
    @Override
    public void setSimulator(Simulator simulator)
    {
        this.simulator = simulator;
    }
    
    @Override
    public Simulator getSimulator()
    {
       return simulator;
    }
    
    /**
     * Construct a new instance for the provided simulator
     * 
     * @param simulator
     *      simulator object
     */
    public OutputProcessorFactoryAbstract(Simulator simulator)
    {
       this.simulator = simulator;
    }

}
