package org.payn.simulation;

/**
 * Input processor for translating meta-input into simulator inputs
 * 
 * @author robpayn
 *
 */
public interface InputProcessor {

   /**
    * Execute the input processor
    * @throws Exception
    */
   public void execute() throws Exception;

}
