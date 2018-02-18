package org.payn.simulation.iteration;

import org.payn.chsm.io.xmltools.ElementHelper;
import org.w3c.dom.Element;

public class BayesAMMCMCMetaInputXML implements BayesAMMCMCMetaInput {
   
   private ElementHelper element;

   public BayesAMMCMCMetaInputXML(Element element) 
   {
      this.element = new ElementHelper(element);
   }

   @Override
   public boolean isActive() 
   {
      if (element != null)
      {
         return element.isActive();
      }
      else
      {
         return false;
      }
   }

}
