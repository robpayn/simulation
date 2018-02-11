package org.payn.simulation.neoch;

import java.io.File;

import org.payn.chsm.io.ModelBuilder;
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
    * Initialize the model
    * 
    * @throws Exception
    */
   public void initializeModel() throws Exception
   {
      ModelBuilder builder = loader.load(workingDir, argMap);
      matrix = (HolonMatrix)builder.buildModel();
      matrix.getProcessor().initializeController();
   }

   @Override
   protected void runModel() throws Exception 
   {
      matrix.getController().executeController();
   }
   
}
