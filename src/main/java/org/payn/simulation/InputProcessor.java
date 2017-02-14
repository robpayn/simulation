package org.payn.simulation;

import org.payn.simulation.interfaces.IInputProcessor;
import org.payn.simulation.interfaces.IMetaInput;
import org.payn.simulation.interfaces.ISimulator;


/**
 * The Input Processor knows how to translate meta inputs into actual model inputs.
 * @author Renee
 *
 */

public abstract class InputProcessor<MIT extends IMetaInput, ST extends ISimulator> implements IInputProcessor {

    
    protected MIT metaInput;
    
    protected ST sim;
    
    public InputProcessor(MIT metaInput, ST sim)
    {
        this.metaInput = metaInput;
        this.sim = sim;
        sim.addInputProc(this); //adding this to simulator. 
    }

   
   
    

    
    
}
