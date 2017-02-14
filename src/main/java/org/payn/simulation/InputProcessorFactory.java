package org.payn.simulation;

import org.payn.simulation.interfaces.IInputProcessor;
import org.payn.simulation.interfaces.IInputProcessorFactory;
import org.payn.simulation.interfaces.ISimulator;
import org.payn.simulation.metainputs.DoubleMetaInput;
import org.w3c.dom.Element;

/**
 * Abstract definition of the input processor factory
 * 
 * @author robpayn
 *
 */
public abstract class InputProcessorFactory implements IInputProcessorFactory {
    
    /**
     * The simulator using this factory
     */
    protected ISimulator simulator;
    
    /**
     * Set the simulator
     */
    @Override
    public void setSimulator(ISimulator simulator)
    {
        this.simulator = simulator;
    }
    
    /**
     * Getter 
     * 
     * @return
     */
    @Override
    public ISimulator getSimulator()
    {
       return simulator;
    }
    
    /**
     * Add a double to parameter input processor to the simulator
     */
    @Override
    public abstract void addDoubleToParamProc(DoubleMetaInput input, Element element);

}
