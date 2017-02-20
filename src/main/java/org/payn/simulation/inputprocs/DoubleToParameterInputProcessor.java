package org.payn.simulation.inputprocs;

import org.payn.simulation.InputProcessorAbstract;
import org.payn.simulation.Simulator;
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
public abstract class DoubleToParameterInputProcessor<ST extends Simulator> 
        extends InputProcessorAbstract<DoubleMetaInput, ST> {
    
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
