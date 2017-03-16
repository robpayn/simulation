package org.payn.simulation.metaoutputs;

import java.util.ArrayList;

import org.payn.simulation.MetaOutput;

public class DoubleMetaOutput implements MetaOutput {

    private ArrayList<Double> vector;
    
    public DoubleMetaOutput()
    {
        vector = new ArrayList<Double>();
    }
    
    public ArrayList<Double> getVector()
    {
        return vector;
    }
    
}
