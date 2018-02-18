package org.payn.simulation.neoch;

import java.io.File;
import java.util.LinkedHashMap;

import org.payn.chsm.HolonStateValue;
import org.payn.chsm.io.ModelLoader;
import org.payn.chsm.io.reporters.Reporter;
import org.payn.simulation.SimulatorAbstract;

/**
 * Simulator using a NEOCH model
 * 
 * @author robpayn
 *
 */
public abstract class SimulatorCHSM extends SimulatorAbstract {
   
   /**
    * NEOCH model matrix
    */
   protected HolonStateValue model;
   
   /**
    * The model loader
    */
   protected ModelLoader loader;

   /**
    * Get the model loader
    * 
    * @return
    *       model loader
    */
   public ModelLoader getLoader()
   {
      return loader;
   }

   /**
    * The reporters from the model
    */
   private LinkedHashMap<String, Reporter> reporters;
   
   /**
    * Getter
    * 
    * @return
    *       model reporters
    */
   public LinkedHashMap<String, Reporter> getReporters()
   {
      return reporters;
   }

   /**
    * Constructor 
    * 
    * @param args
    * @param workingDir
    * @param loader 
    * @throws Exception
    */
   public SimulatorCHSM(File workingDir, String[] args, ModelLoader loader) 
         throws Exception 
   {
      super(workingDir, args);
      this.loader = loader;
   }

   /**
    * Initialize the model based on the provided matrix
    * 
    * @param model
    *       matrix for the model
    * @throws Exception
    *       if error in initializing the controller for the matrix
    */
   public void initializeModel(HolonStateValue model) throws Exception
   {
      this.model = model;
      model.getProcessor().initializeController();
   }
   
   @Override
   protected void runModel() throws Exception 
   {
      model.getProcessor().executeController();
      reporters = model.getProcessor().getReporters();
   }
   
}
