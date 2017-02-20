package org.payn.simulation;

/**
 * Factory for creating input processors
 * 
 * @author robpayn
 */
public interface InputProcessorFactory {

    /**
     * Set the simulator
     * 
     * @param simulator
     *      simulator
     */
    public abstract void setSimulator(Simulator simulator);

    /**
     * Getter 
     * 
     * @return
     *      simulator interface
     */
    public abstract Simulator getSimulator();


}
