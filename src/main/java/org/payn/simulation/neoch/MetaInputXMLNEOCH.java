package org.payn.simulation.neoch;

import java.io.File;

import org.payn.chsm.io.xmltools.ElementHelper;
import org.payn.chsm.io.xmltools.DocumentModelConfig;
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
    * Time element with information about simulation time
    */
   private ElementHelper timeElement;

   /**
    * Element with information about model control
    */
   private ElementHelper controlElement;

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
      return getTimeElement().getAttributeDouble("timeInterval");
   }
   
   /**
    * Get the last iteration attribute
    * 
    * @return
    *       last iteration
    */
   public Long getAttributeLastIteration()
   {
      return getTimeElement().getAttributeLong("lastIteration");
   }

   /**
    * Get the time XML element
    * 
    * @return
    *       time element
    */
   public ElementHelper getTimeElement()
   {
      if (timeElement == null)
      {
         timeElement = new ElementHelper(
               document.getRootElementHelper().getFirstChildElement("time")
               );
      }
      return timeElement;
   }
   
   public ElementHelper getControlElement()
   {
      if (controlElement == null)
      {
         controlElement = new ElementHelper(
               document.getRootElementHelper().getFirstChildElement("control")
               );
      }
      return controlElement;
   }
   
   /**
    * Is the flag set for writing the matrix file?
    * 
    * @return
    *       true if matrix file should be written
    */
   public Boolean isMatrixFileWritten()
   {
      return getControlElement().getAttributeBoolean("writeMatrixFile");
   }

}
