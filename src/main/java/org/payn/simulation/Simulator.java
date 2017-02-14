package org.payn.simulation;

import java.util.ArrayList;

import org.payn.simulation.interfaces.IInputProcessor;
import org.payn.simulation.interfaces.IInputProcessorFactory;
import org.payn.simulation.interfaces.IOutputProcessor;
import org.payn.simulation.interfaces.IOutputProcessorFactory;
import org.payn.simulation.interfaces.ISimulator;

/**
 * Abstract implementation of a simulator
 * 
 * @author robpayn
 *
 */
public abstract class Simulator implements ISimulator {
    
    /**
     * Factory for input processors
     */
    protected IInputProcessorFactory inputProcessorFactory;
    
    /**
     * Factory for output processors
     */
    protected IOutputProcessorFactory outputProcessorFactory;
    
    /**
     * List of input processors
     */
    protected ArrayList<IInputProcessor> inputProcList;
    
    /**
     * List of output processors
     */
    protected ArrayList<IOutputProcessor> outputProcList;
    
    /**
     * Construct a new instance with the given input and output processor
     * factories
     * 
     * @param inputProcessorFactory
     *      input processor factory
     * @param outputProcessorFactory
     *      output processor factory
     */
    public Simulator()
    {
        this.inputProcessorFactory = createInputProcessorFactory();
        inputProcessorFactory.setSimulator(this);
        this.outputProcessorFactory = createOutputProcessorFactory();
        outputProcessorFactory.setSimulator(this);
        inputProcList = new ArrayList<IInputProcessor>();
        outputProcList = new ArrayList<IOutputProcessor>();
    }
    
   /**
     * Add an input processor
     */
    @Override
    public void addInputProc(IInputProcessor inputProc)
    {
        inputProcList.add(inputProc);
    }

    /**
     * Add an output processor
     */
    @Override
    public void addOutputProc(IOutputProcessor outputProc)
    {
        outputProcList.add(outputProc);
    }

    /**
     * Execute the input processors, run the model, and execute the output processors
    * @throws Exception 
     */
    @Override
    public void execute() throws Exception
    {
        for (IInputProcessor inputProc: inputProcList)
        {
            inputProc.execute();
        }
        runModel();
        for (IOutputProcessor outputProc: outputProcList)
        {
            outputProc.execute();
        }
    }

    /**
     * Getter for the input processor factory
     * 
     * @return
     *      input processor factory
     */
    @Override
    public IInputProcessorFactory getInputProcessorFactory()
    {
        return inputProcessorFactory;
    }

    /**
     * Getter for the output processor factory
     * 
     * @return
     *      output processor factory
     */
    @Override
    public IOutputProcessorFactory getOutputProcessorFactory()
    {
        return outputProcessorFactory;
    }
    
    /**
     * Create the input processor factory
     * 
     * @return
     *      input processor factory
     */
    protected abstract IInputProcessorFactory createInputProcessorFactory();

    /**
     * Create the output processor factory
     * 
     * @return
     *      output processor factory
     */
    protected abstract IOutputProcessorFactory createOutputProcessorFactory();

    /**
     * Run the associated model
    * @throws Exception 
     */
    protected abstract void runModel() throws Exception;
    
}
