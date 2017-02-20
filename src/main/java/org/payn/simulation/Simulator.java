package org.payn.simulation;

/**
 * Controls a single simulation based on setting up model input,
 * executing the model, and interpreting model output
 * 
 * @author robpayn
 *
 */
public interface Simulator {

    /**
     * Add an input processor to be executed before running the model
     * 
     * @param inputProc
     *      input processor to be added
     */
    public void addInputProc(InputProcessor inputProc);

    /**
     * Add an output processor to be executed after running the model
     * 
     * @param outputProc
     *      output processor to be added
     */
    public void addOutputProc(OutputProcessor outputProc);

    /**
     * Execute the simulation
    * @throws Exception 
     */
    public void execute() throws Exception;

    /**
     * Getter for the input processor factory
     * 
     * @return
     *      input processor factory
     */
    public abstract InputProcessorFactory getInputProcessorFactory();

    /**
     * Getter for the output processor factory
     * 
     * @return
     *      output processor factory
     */
    public abstract OutputProcessorFactory getOutputProcessorFactory();

}
