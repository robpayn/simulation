package org.payn.simulation.inputprocs;

import org.payn.simulation.InputProcessor;
import org.payn.simulation.interfaces.ISimulator;
import org.payn.simulation.metainputs.DoubleMetaInput;

/**
 * Abstraction of an input processor that converts a vector of
 * double precision floating point values to model parameters
 * 
 * @author robpayn
 *
 * @param <ST>
 *      The type of the simulator using this input processor
 */
public abstract class DoubleToParameterInputProcessor<ST extends ISimulator> 
        extends InputProcessor<DoubleMetaInput, ST> {
    
    /**
     * Construct an instance associated with the provided simulator
     * 
     * @param input 
     *      meta input used by this input processor
     * @param sim
     *      simulator using this input processor
     */
    public DoubleToParameterInputProcessor(DoubleMetaInput input, ST sim)
    {
        super(input, sim);
    }

}
