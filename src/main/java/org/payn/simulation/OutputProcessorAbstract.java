package org.payn.simulation;

/**
 * Abstract class to give the desired output. 
 * @author Renee
 *
 */


public abstract class OutputProcessorAbstract<MOT extends MetaOutput, ST extends Simulator> implements OutputProcessor {

    
    protected MOT metaOutput;
    
    protected ST sim;
    
    public OutputProcessorAbstract(MOT metaOutput, ST sim)
    {
        this.metaOutput = metaOutput;
        this.sim = sim;
        sim.addOutputProcess(this);
    }

}
