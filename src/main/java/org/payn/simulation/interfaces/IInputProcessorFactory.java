package org.payn.simulation.interfaces;

import java.io.File;

import org.payn.simulation.metainputs.DoubleMetaInput;
import org.w3c.dom.Element;

/**
 * Factory for creating input processors
 * 
 * @author robpayn
 */
public interface IInputProcessorFactory {

    /**
     * Create an input processor that translates a double meta parameter
     * into simulation parameters
     * 
     * @param input
     *      double meta input
     * @param element 
     *      XML element with information for configuring processor
     */
    public abstract void addDoubleToParamProc(DoubleMetaInput input, Element element);

    /**
     * Create an input processor that will build the model from a configuration file
     * 
     * @param configFile
     *      file with the model configuration
     * @param workingDir
     *      working directory for the model execution
     * @throws Exception
     *      if error in building the model
     */
    public abstract void addBuilderInputProcessor(File configFile, File workingDir) throws Exception;

    /**
     * Set the simulator
     * 
     * @param simulator
     *      simulator
     */
    public abstract void setSimulator(ISimulator simulator);

    /**
     * Getter 
     * 
     * @return
     *      simulator interface
     */
    public abstract ISimulator getSimulator();


}
