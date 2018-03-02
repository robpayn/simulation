package org.payn.simulation.neoch;

import java.io.File;

import org.payn.chsm.io.ModelBuilder;
import org.payn.chsm.io.ModelBuilderXML;
import org.payn.chsm.io.ModelLoaderXML;
import org.payn.chsm.io.xmltools.ElementBehavior;
import org.payn.chsm.io.xmltools.ElementHelperLoader;
import org.payn.chsm.resources.Behavior;
import org.payn.chsm.resources.Resource;
import org.payn.chsm.resources.time.BehaviorTimeStepper;
import org.payn.chsm.resources.time.ResourceTime;
import org.payn.neoch.HolonMatrix;
import org.payn.neoch.io.xmltools.DocumentHolonMatrix;
import org.payn.simulation.InputProcessorAbstract;

/**
 * Abstract implementation of an input processor that creates a
 * NEOCH model from meta input
 * 
 * @author robpayn
 *
 * @param <MIT>
 *      meta input type
 * @param <ST> 
 *      simulator type
 */
public abstract class InputProcessorXMLNEOCHBuilder<MIT extends MetaInputXMLNEOCH, ST extends SimulatorCHSM> 
      extends InputProcessorAbstract<MIT, ST> {

   /**
    * Holon XML document
    */
   protected DocumentHolonMatrix documentHolon;

   /**
    * Construct a new instance with the given meta input and simulator
    * 
    * @param metaInput
    * @param sim
    */
   public InputProcessorXMLNEOCHBuilder(MIT metaInput, ST sim) 
   {
      super(metaInput, sim);
   }

   @Override
   public void processInput() throws Exception 
   {
      ElementHelperLoader iterationElement = metaInput.getElementIteration();
      if (iterationElement != null && iterationElement.isActive())
      {
         System.out.println(String.format(
               "Iteration is active: creating the %s type input processor",
               iterationElement.getType()
               ));
         metaInput.createInputProcessor(simulator, iterationElement);
      }
      else
      {
         ModelLoaderXML loader = (ModelLoaderXML)simulator.getLoader();
         HolonMatrix matrix = null;
         if (!metaInput.isBuildActive())
         {
            System.out.println("Input processor is inactive, attempting to run existing model...");
            ModelBuilder builder = loader.load(
                  simulator.getWorkingDir(), 
                  simulator.getArgMap()
                  );
            matrix = (HolonMatrix)builder.buildModel();
         }
         else
         {
            System.out.println("Building the NEOCH XML files...");
   
            File holonFile = metaInput.getHolonFile();
            documentHolon = new DocumentHolonMatrix(holonFile.getName());
            
            Resource resourceTime = new ResourceTime();
            resourceTime.initialize("time");
            Behavior behaviorTime = resourceTime.getBehavior(
                  ResourceTime.BEHAVIOR_TIME
                  );
            ElementBehavior elementTime =
                  documentHolon.getRootHolonElement().createBehaviorElement(behaviorTime);
            elementTime.createInitValueElement(
                  BehaviorTimeStepper.ITERATION_INTERVAL,
                  metaInput.getAttributeTimeInterval().toString(), 
                  null
                  );
            elementTime.createInitValueElement(
                  BehaviorTimeStepper.LAST_ITERATION,
                  metaInput.getAttributeLastIteration().toString(), 
                  null
                  );
            
            configureResources();
            
            System.out.println("Building the matrix from the metainput...");
   
            configureModel();
            
            // Write the model input files
            if (metaInput.isMatrixFileWritten())
            {
               holonFile.getParentFile().mkdirs();
               documentHolon.write(holonFile.getParentFile());
            }
            ModelBuilderXML builder = (ModelBuilderXML)loader.load(
                  simulator.getWorkingDir(), 
                  simulator.getArgMap(), 
                  metaInput.getDocument()
                  );
            matrix = (HolonMatrix)builder.buildModel(
                  metaInput.getDocument(), 
                  documentHolon
                  );
         }
         simulator.initializeModel(matrix);
      }

   }

   /**
    * Configure the model
    * 
    * @throws Exception
    *       if error in model configuration
    */
   protected abstract void configureModel() throws Exception;
   
   /**
    * Configure the resources used in the model
    * 
    * @throws Exception
    *       if error in loading resources
    */
   protected abstract void configureResources() throws Exception;

}
