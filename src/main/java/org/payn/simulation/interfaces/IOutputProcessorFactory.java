package org.payn.simulation.interfaces;

import org.payn.simulation.metaoutputs.DoubleMetaOutput;
import org.w3c.dom.Element;

/**
 * Factory for creating output processors
 * 
 * @author robpayn
 *      type of simulator associated with output processor
 */
public interface IOutputProcessorFactory {
    
    /**
     * Add an output processor that translates univariate
     * function results from a simulator into a double meta output
     * 
     * @param output
     *      double meta output
     * @param element 
     *      XML element containing information needed to build output processor
     * @throws Exception
     *      if error in creating output processor
     */
    public abstract void addFunctionOutputProc(DoubleMetaOutput output, Element element) 
            throws Exception;

    /**
     * Set the simulator associated with this factory
     * 
     * @param simulator
     *      simulator
     */
    public abstract void setSimulator(ISimulator simulator);

}
