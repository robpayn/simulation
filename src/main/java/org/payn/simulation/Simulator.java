package org.payn.simulation;

import java.util.HashMap;

/**
 * Controls a single simulation based on setting up model input,
 * executing the model, and interpreting model output
 * 
 * @author robpayn
 *
 */
public interface Simulator {

   /**
    * Get the argument map
    * 
    * @return
    *      argument map
    */
   HashMap<String, String> getArgMap();

   /**
     * Add an input processor to be executed before running the model
     * 
     * @param inputProc
     *      input processor to be added
     */
   void addInputProcess(InputProcessor inputProc);

   /**
    * Add an iteration input processor to be executed before 
    * running at iteration of the model
    * 
    * @param inputProc
    *      input processor to be added
    */
   void addIterInputProcess(InputProcessor inputProc);

   /**
    * Add an output processor to be executed after running the model
    * 
    * @param outputProc
    *      output processor to be added
    */
   void addOutputProcess(OutputProcessor outputProc);

   /**
    * Add an iteration output processor to be executed after running 
    * at iteration of the model
    * 
    * @param outputProc
    *      output processor to be added
    */
   void addIterOutputProcess(OutputProcessor outputProc);

    /**
    * Execute the simulation
    * 
    * @throws Exception 
    */
   void execute() throws Exception;

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
