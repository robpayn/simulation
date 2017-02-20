package org.payn.simulation;

/**
 * Abstract implementation of an input processor
 * 
 * @author Renee
 * 
 * @param <MIT> 
 *      rype for the meta-input
 * @param <ST> 
 *      type for the simulator
 *
 */
public abstract class InputProcessorAbstract<MIT extends MetaInput, ST extends Simulator> 
      implements InputProcessor {

   /**
    * Meta-input
    */
   protected MIT metaInput;
   
   /**
    * Simulator
    */
   protected ST sim;
   
   /**
    * Construct an instance with the provided meta-input and simulator
    * 
    * @param metaInput
    *       meta-input for the processor
    * @param sim
    *       simulator using this processor
    */
   public InputProcessorAbstract(MIT metaInput, ST sim)
   {
      this.metaInput = metaInput;
      this.sim = sim;
      sim.addInputProc(this);
   }

   
   
    

    
    
}
