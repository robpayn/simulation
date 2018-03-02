package org.payn.simulation.neoch;

import java.io.File;

import org.payn.chsm.io.xmltools.DocumentModelConfig;
import org.payn.chsm.io.xmltools.ElementHelper;
import org.payn.chsm.io.xmltools.ElementHelperLoader;
import org.payn.neoch.io.xmltools.ElementXMLInputMatrix;
import org.payn.simulation.metainputs.MetaInputXML;

/**
 * Abstract meta input for a NEOCH model builder
 * 
 * @author robpayn
 *
 */
public abstract class MetaInputXMLNEOCH extends MetaInputXML<DocumentModelConfig> {

   /**
    * Input element for the model input
    */
   private ElementXMLInputMatrix xmlInputElement;
   
   /**
    * Element for the time controls of the model
    */
   private ElementHelper elementTime;

   /**
    * Element for the iteration controls
    */
   private ElementHelperLoader elementIteration;
   
   /**
    * Construct a new instance that uses the provided working directory,
    * path to the configuration file, and the name of the XML element
    * with the configuration information
    * 
    * @param workingDir
    * @param path
    * @param elementName
    * @throws Exception
    */
   public MetaInputXMLNEOCH(File workingDir, String path,
         String elementName) throws Exception 
   {
      super(workingDir, path, elementName);
      this.xmlInputElement = 
            new ElementXMLInputMatrix(
                  document.getBuilderElement().getXMLInputElement(),
                  workingDir
                  );
   }

   @Override
   protected DocumentModelConfig createDocument(File metaInputFile)
         throws Exception 
   {
      return new DocumentModelConfig(metaInputFile);
   }

   /**
    * Is the flag for building the model active?
    * 
    * @return
    *       true if model should be built, false otherwise
    */
   public Boolean isBuildActive()
   {
      return helper.getAttributeBoolean("build");
   }
   
   /**
    * Is the flag set for writing the matrix file?
    * 
    * @return
    *       true if matrix file should be written
    */
   public Boolean isMatrixFileWritten()
   {
      return helper.getAttributeBoolean("writeMatrixFile");
   }
   
   public Boolean isIterationActive()
   {
      ElementHelper element = helper.getFirstChildElementHelper("iteration");
      if (element.getElement() != null && element.isActive())
      {
         return true;
      }
      else
      {
         return false;
      }
   }

   /**
    * Get the holon file from the NEOCH settings
    * 
    * @return
    *       cell file
    * @throws Exception
    */
   public File getHolonFile() throws Exception 
   {
      return xmlInputElement.getHolonFile();
   }
   
   /**
    * Get the time interval attribute
    * 
    * @return
    *       time interval
    */
   public Double getAttributeTimeInterval()
   {
      return getElementTime().getAttributeDouble("timeInterval");
   }
   
   /**
    * Get the last iteration attribute
    * 
    * @return
    *       last iteration
    */
   public Long getAttributeLastIteration()
   {
      return getElementTime().getAttributeLong("lastIteration");
   }
   
   /**
    * Get the time element
    * 
    * @return
    *       time element helper
    */
   private ElementHelper getElementTime()
   {
      if (elementTime == null)
      {
         elementTime = helper.getFirstChildElementHelper("time");
      }
      return elementTime;
   }
   
   /**
    * Get the iteration element
    * 
    * @return
    *       iteration element helper
    */
   public ElementHelperLoader getElementIteration()
   {
      if (elementIteration == null)
      {
         elementIteration = new ElementHelperLoader(
               helper.getFirstChildElement("iteration"));
      }
      return elementIteration;
   }

}
