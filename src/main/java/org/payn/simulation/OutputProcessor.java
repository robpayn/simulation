package org.payn.simulation;

import org.payn.simulation.interfaces.IMetaOutput;
import org.payn.simulation.interfaces.IOutputProcessor;
import org.payn.simulation.interfaces.ISimulator;

/**
 * Abstract class to give the desired output. 
 * @author Renee
 *
 */


public abstract class OutputProcessor<MOT extends IMetaOutput, ST extends ISimulator> implements IOutputProcessor {

    
    protected MOT metaOutput;
    
    protected ST sim;
    
    public OutputProcessor(MOT metaOutput, ST sim)
    {
        this.metaOutput = metaOutput;
        this.sim = sim;
        sim.addOutputProc(this);
    }

}
