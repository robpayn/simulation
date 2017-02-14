package org.payn.simulation.metainputs;

import java.util.ArrayList;

import org.payn.simulation.MetaInput;

public class DoubleMetaInput extends MetaInput {
    
    private ArrayList<Double> vector;
    
    public DoubleMetaInput()
    {
        this.vector = new ArrayList<Double>();
    }

    public ArrayList<Double> getVector()
    {
        return vector;
    }

}
