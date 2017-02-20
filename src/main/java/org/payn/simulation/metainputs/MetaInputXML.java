package org.payn.simulation.metainputs;

import java.io.File;

import org.payn.chsm.io.xml.ElementHelper;
import org.payn.chsm.io.xml.XMLDocument;

/**
 * Meta-input contained in an XML file
 * 
 * @author robpayn
 * 
 * @param <DT> 
 *      Type of XMLDocument
 */
public abstract class MetaInputXML<DT extends XMLDocument> extends MetaInputFile {
   
   /**
    * XML document containing the meta-input
    */
   protected DT document;
   
   /**
    * Element helper containing the meta-input
    */
   protected ElementHelper helper;
   
   /**
    * Construct a new instance based on the working directory, 
    * path to the XML file from the working directory,
    * and XML name of the element with the meta-input
    * 
    * @param workingDir
    *       working directory
    * @param path
    *       path to the XML file
    * @param elementName
    *       element with meta-input
    * @throws Exception
    *       if error in opening file
    */
   public MetaInputXML(File workingDir, String path, String elementName) throws Exception 
   {
      super(workingDir, path);
      this.document = createDocument(metaInputFile);
      this.helper = new ElementHelper(
            document.getRootElementHelper().getFirstChildElement(elementName)
            );
   }

   @Override
   public boolean isActive() 
   {
      return helper.isActive();
   }

   /**
    * Create a new XML document
    * 
    * @param metaInputFile
    *       XML file
    * @return
    *       document of the appropriate type
    * @throws Exception
    *       if error in reading file
    */
   protected abstract DT createDocument(File metaInputFile) throws Exception;

}
