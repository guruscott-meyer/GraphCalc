/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphcalc;

import java.util.NoSuchElementException;

/**
 *
 * @author admin
 */
public class CalcFunctionFramework extends Object {
    
    protected CalcFunction function;
    protected LabelFunction label;
    protected CalcFunctionFramework framework1, framework2;
    
    public CalcFunctionFramework( CalcFunction newfunc, LabelFunction newlabel ) {
        function = newfunc;
        label = newlabel;
    }
    
    public void setFramework( CalcFunctionFramework newframe, int index ) {
        if( index == 0 ) framework1 = newframe;
        else framework2 = newframe;
    }
    
    public CalcFunctionFramework getFramework( int index ) {
        if( index == 0 ) return framework1;
        else return framework2;
    }
    
    public void replaceFramework( CalcFunctionFramework oldFrame, CalcFunctionFramework newFrame ) throws NoSuchElementException {
        if( framework1 == oldFrame ) framework1 = newFrame;
        else if( framework2 == oldFrame ) framework2 = newFrame;
        else throw new NoSuchElementException();
    }
    
    public void setFunction( CalcFunction newfunc ) {
        function = newfunc;
    }
    
    public CalcFunction getFunction() {
        return function;
    }
    
    public LabelFunction getLabel() {
        return label;
    }
    
    public void setLabel( LabelFunction newlabel ) {
        label = newlabel;
    }
    
    public double getY( double x ) {
        return function.getY( x, 0 );
    }
    
    public String getLabelText() {
        return label.getLabel( "", "" );
    }
    
}
