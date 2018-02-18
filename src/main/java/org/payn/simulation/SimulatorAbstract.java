package org.payn.simulation;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Abstract implementation of a simulator
 * 
 * @author robpayn
 *
 */
public abstract class SimulatorAbstract implements Simulator {
    
    /**
     * Factory for input processors
     */
    protected InputProcessorFactory inputProcessorFactory;
    
    /**
     * Factory for output processors
     */
    protected OutputProcessorFactory outputProcessorFactory;
    
    /**
     * List of input processors
     */
    protected ArrayList<InputProcessor> inputProcList;
    
    /**
     * List of iteration input processors
     */
    protected ArrayList<InputProcessor> iterInputProcList;

    /**
     * List of output processors
     */
    protected ArrayList<OutputProcessor> outputProcList;

    /**
     * List of iteration output processors
     */
    protected ArrayList<OutputProcessor> iterOutputProcList;

    /**
     * Hashmap of command line arguments
     */
    protected HashMap<String, String> argMap;

    @Override
    public HashMap<String, String> getArgMap() 
    {
       return argMap;
    }

    /**
     * Working directory
     */
    protected File workingDir;
    
    /**
     * Get the working directory
     * 
     * @return
     *      working directory as a file object
     */
    public File getWorkingDir()
    {
       return workingDir;
    }
    
    protected boolean isIteration = false;
    
    protected void setIteration(boolean isIteration)
    {
       this.isIteration = isIteration;
    }
    
    protected boolean isIteration()
    {
       return isIteration;
    }
    
    /**
     * Construct a new instance with the given input and output processor
     * factories
    * @param args
    *       array of command line arguments 
    * @param workingDir 
     *      working director as a File object
     * @param inputProcessorFactory
     *      input processor factory
     * @param outputProcessorFactory
     *      output processor factory
    * @throws Exception 
     */
    public SimulatorAbstract(File workingDir, String[] args) throws Exception
    {
       HashMap<String,String> argMap = new HashMap<String,String>();
       for (int i = 0; i < args.length; i++)
       {
          String[] arg = args[i].split("=");
          if (arg.length != 2)
          {
             throw new Exception(String.format(
                   "'%s' is a malformed command line argument.",
                   args[i]
                   ));
          }
          argMap.put(arg[0], arg[1]);
       }
       this.argMap = argMap;
       this.workingDir = workingDir;
       this.inputProcessorFactory = createInputProcessorFactory();
       this.outputProcessorFactory = createOutputProcessorFactory();
       inputProcList = new ArrayList<InputProcessor>();
       outputProcList = new ArrayList<OutputProcessor>();
    }
    
   /**
     * Add an input processor
     */
    @Override
    public void addInputProcess(InputProcessor inputProc)
    {
        inputProcList.add(inputProc);
    }

    /**
     * Add an output processor
     */
    @Override
    public void addOutputProcess(OutputProcessor outputProc)
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
        for (InputProcessor inputProc: inputProcList)
        {
            inputProc.processInput();
        }
        if (isIteration)
        {
           while(isIteration)
           {
              for (InputProcessor iterInputProc: iterInputProcList)
              {
                 iterInputProc.processInput();
              }
              runModel();
              for (OutputProcessor iterOutputProc: iterOutputProcList)
              {
                 iterOutputProc.processOutput();
              }
           }
        }
        else
        {
           runModel();
        }
        for (OutputProcessor outputProc: outputProcList)
        {
            outputProc.processOutput();
        }
        System.out.println("");
        System.out.println("Simulation complete.");
    }

    /**
     * Getter for the input processor factory
     * 
     * @return
     *      input processor factory
     */
    @Override
    public InputProcessorFactory getInputProcessorFactory()
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
    public OutputProcessorFactory getOutputProcessorFactory()
    {
        return outputProcessorFactory;
    }
    
    /**
     * Create the input processor factory
     * 
     * @return
     *      input processor factory
     */
    protected abstract InputProcessorFactory createInputProcessorFactory();

    /**
     * Create the output processor factory
     * 
     * @return
     *      output processor factory
     */
    protected abstract OutputProcessorFactory createOutputProcessorFactory();

    /**
     * Run the associated model
    * @throws Exception 
     */
    protected abstract void runModel() throws Exception;
    
}
