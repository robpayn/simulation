package org.payn.simulation;

/**
 * Meta input for a an input processor that generates the 
 * specific input needed for a simulation
 * 
 * @author robpayn
 *
 */
public interface MetaInput {
   
   /**
    * Determines if the meta-input is activated
    * 
    * @return
    *       true if active, false otherwise
    */
   boolean isActive();
    
}
