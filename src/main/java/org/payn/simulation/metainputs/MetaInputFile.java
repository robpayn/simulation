package org.payn.simulation.metainputs;

import java.io.File;

import org.payn.simulation.MetaInput;

/**
 * Meta-input contained in a file
 * 
 * @author robpayn
 *
 */
public abstract class MetaInputFile implements MetaInput {

   /**
    * File with meta-input data
    */
   protected File metaInputFile;

   /**
    * Construct a new instance based on a working directory and 
    * a path to the file from the workin directory
    * 
    * @param workingDir
    *       working directory
    * @param path
    *       path to file
    * @throws Exception
    *       if error in opening file
    */
   public MetaInputFile(File workingDir, String path) throws Exception 
   {
      metaInputFile = new File(workingDir.getAbsolutePath() + path);
      if (!metaInputFile.exists() || metaInputFile.isDirectory()) 
      {
         throw new Exception(String.format(
               "%s is an invalid meta-input file.", 
               metaInputFile.getAbsolutePath()
               ));
      }
   }

}
