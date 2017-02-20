package org.payn.simulation;

/**
 * Factory for creating output processors
 * 
 * @author robpayn
 *      type of simulator associated with output processor
 */
public interface OutputProcessorFactory {
    
    /**
     * Set the simulator associated with this factory
     * 
     * @param simulator
     *      simulator
     */
    public abstract void setSimulator(Simulator simulator);
    
    /**
     * Get the simulator for this factory
     * 
     * @return
     *      simulator object
     */
    public abstract Simulator getSimulator();

}
