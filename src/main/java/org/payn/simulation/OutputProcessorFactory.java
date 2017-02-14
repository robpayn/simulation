package org.payn.simulation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.payn.simulation.interfaces.IOutputProcessor;
import org.payn.simulation.interfaces.IOutputProcessorFactory;
import org.payn.simulation.interfaces.ISimulator;
import org.payn.simulation.metaoutputs.DoubleMetaOutput;
import org.w3c.dom.Element;

/**
 * Abstract implementation of the output processor factory
 * 
 * @author robpayn
 *
 */
public abstract class OutputProcessorFactory implements IOutputProcessorFactory {
    
    /**
     * Simulator associated with this factory
     */
    protected ISimulator simulator;
    
    /**
     * Set the simulator associated with this factory
     * 
     * @param simulator
     *      simulator
     */
    @Override
    public void setSimulator(ISimulator simulator)
    {
        this.simulator = simulator;
    }

    /**
     * Add an output processor that translates univariate
     * function results from a simulator into a double meta output
     * 
     * @param output
     *      double meta output
     * @param element 
     *      XML element containing information needed to build output processor
     * @throws Exception
     *      if error in reading independent data from file 
     */
    @Override
    public void addFunctionOutputProc(DoubleMetaOutput output, Element element) 
            throws Exception
    {
        ArrayList<Double> independentVals = new ArrayList<Double>();
        Element dataElement = (Element)element.getElementsByTagName("obsdata").item(0);                 // the observed data
        File dataFile = new File(dataElement.getAttribute("filename"));                                 // e.g. "xydata.txt"
        BufferedReader reader = new BufferedReader(new FileReader(dataFile));
        Element independentElement = (Element)dataElement.getElementsByTagName("independent").item(0);  // e.g. xvalues are in column number 0 in the text file
        int independentColNum = Integer.valueOf(independentElement.getAttribute("colnum"));             
        
        while(reader.ready())
        {
            String line = reader.readLine();
            if (line != null && !line.equals(""))
            {
                String[] splitLine = line.split(" ");                                                   //space delimited
                independentVals.add(Double.valueOf(splitLine[independentColNum]));
            }
        }
        
        reader.close();

        createFunctionOutputProc(output, independentVals, element);
    }

    /**
     * Create an output processor that translates univariate
     * function results from a simulator into a double meta output
     * 
     * @param output
     *      double meta output
     * @param independentVals 
     *      independent variable values for determining appropriate meta output
     * @param element 
     *      XML element containing information needed to build output processor
     * @return  
     *      output processor
     */
    public abstract IOutputProcessor createFunctionOutputProc(DoubleMetaOutput output, 
            ArrayList<Double> independentVals, Element element);

}
