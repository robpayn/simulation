package org.payn.simulation.neoch;

import java.io.File;

import org.payn.chsm.io.ModelLoader;
import org.payn.neoch.HolonMatrix;
import org.payn.simulation.SimulatorAbstract;

/**
 * Simulator using a NEOCH model
 * 
 * @author robpayn
 *
 */
public abstract class SimulatorNEOCH extends SimulatorAbstract {
   
   /**
    * NEOCH model matrix
    */
   protected HolonMatrix matrix;
   
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
    * Constructor 
    * 
    * @param args
    * @param workingDir
    * @throws Exception
    */
   public SimulatorNEOCH(File workingDir, String[] args, ModelLoader loader) 
         throws Exception 
   {
      super(workingDir, args);
      this.loader = loader;
   }

   /**
    * Initialize the model based on the provided matrix
    * 
    * @param matrix
    *       matrix for the model
    * @throws Exception
    *       if error in initializing the controller for the matrix
    */
   public void initializeModel(HolonMatrix matrix) throws Exception
   {
      this.matrix = matrix;
      matrix.getController().initializeController();
   }
   
   @Override
   protected void runModel() throws Exception 
   {
      matrix.getController().executeController();
   }
   
}
