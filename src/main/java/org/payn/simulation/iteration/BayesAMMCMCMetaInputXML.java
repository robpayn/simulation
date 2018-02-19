package org.payn.simulation.iteration;

import org.payn.chsm.io.xmltools.ElementHelper;
import org.w3c.dom.Element;

public class BayesAMMCMCMetaInputXML extends ElementHelper implements BayesAMMCMCMetaInput {

   public BayesAMMCMCMetaInputXML(Element element) 
   {
      super(element);
   }
   
}
