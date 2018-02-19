package org.payn.simulation.iteration;

import org.payn.chsm.io.xmltools.ElementHelperLoader;
import org.w3c.dom.Element;

public class BayesAMMCMCMetaInputXML 
extends ElementHelperLoader 
implements BayesAMMCMCMetaInput {

   public BayesAMMCMCMetaInputXML(Element element) 
   {
      super(element);
   }
   
}
