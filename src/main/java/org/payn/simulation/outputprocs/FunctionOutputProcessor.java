package org.payn.simulation.outputprocs;

import java.util.ArrayList;

import org.payn.simulation.OutputProcessorAbstract;
import org.payn.simulation.Simulator;
import org.payn.simulation.metaoutputs.DoubleMetaOutput;

/**
 * Abstraction of an output processor for translating model output
 * to a univariate function output
 * 
 * @author robpayn
 *
 * @param <ST>
 *      type of simulator associated with output processor
 */
public abstract class FunctionOutputProcessor<ST extends Simulator> 
        extends OutputProcessorAbstract<DoubleMetaOutput, ST> {
    
    /**
     * Vector of values of independent variable
     */
    protected ArrayList<Double> independentVals;

    /**
     * Create an instance of the output processor
     * 
     * @param metaOutput
     *      meta output associated with the output processor
     * @param sim
     *      simulator associated with the output processor
     * @param independentVals
     *      independent values at which the prediction should be determined
     */
    public FunctionOutputProcessor(DoubleMetaOutput metaOutput, ST sim, 
            ArrayList<Double> independentVals)
    {
        super(metaOutput, sim);
        this.independentVals = independentVals;
        //got rid of sim.addproc call because already doing that in super constructor!
    }

}
