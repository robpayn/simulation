package org.payn.simulation.iteration;

import org.payn.simulation.InputProcessorAbstract;
import org.payn.simulation.MetaInput;
import org.payn.simulation.OutputProcessor;
import org.payn.simulation.Simulator;

public class BayesAMMCMC extends InputProcessorAbstract<BayesAMMCMCMetaInput, Simulator> 
      implements OutputProcessor {

   public BayesAMMCMC(BayesAMMCMCMetaInput metaInput, Simulator simulator) 
   {
      super(metaInput, simulator);
   }

   @Override
   public void processInput() throws Exception 
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void processOutput() 
   {
      // TODO Auto-generated method stub
      
   }

}
