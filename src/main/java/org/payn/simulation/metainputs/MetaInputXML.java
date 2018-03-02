package org.payn.simulation.metainputs;

import java.io.File;

import org.payn.chsm.io.xmltools.ElementHelper;
import org.payn.chsm.io.xmltools.ElementHelperLoader;
import org.payn.chsm.io.xmltools.XMLDocument;
import org.payn.simulation.InputProcessor;
import org.payn.simulation.Simulator;
import org.payn.simulation.iteration.BayesAMMCMC;
import org.payn.simulation.iteration.BayesAMMCMCMetaInput;
import org.payn.simulation.iteration.BayesAMMCMCMetaInputXML;

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
    * Name for the element of a supported processor
    */
   public static final String OPTION_BAYES_AMMCMC = "bayesammcmc";
   
   /**
    * XML document containing the meta-input
    */
   protected DT document;
   
   /**
    * Get the document representing metainput
    * 
    * @return
    *       document
    */
   public DT getDocument()
   {
      return document;
   }
   
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
    * Create a new input processor based on the provided XML element
    * 
    * @param simulator
    *       simulator to which the processor should be added
    * @param element
    *       element with processor configuration metainput
    * @return
    *       created processor
    * @throws Exception
    *       if error in creating processor
    */
   public InputProcessor createInputProcessor(
         Simulator simulator, ElementHelperLoader element) 
         throws Exception
   {
      InputProcessor inputProc = null;
      switch (element.getType())
      {
         case OPTION_BAYES_AMMCMC:
            BayesAMMCMCMetaInput metaInput = 
                  new BayesAMMCMCMetaInputXML(element.getElement());
            BayesAMMCMC proc = new BayesAMMCMC(metaInput, simulator);
            simulator.addIterOutputProcess(proc);
            inputProc = proc;
            break;
      }
      return inputProc;
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
