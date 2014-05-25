/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphcalc;

/**
 *
 * @author admin
 */
public class CalcFunctionFramework extends Object {
    
    protected CalcFunction function;
    protected LabelFunction label;
    
    public CalcFunctionFramework( CalcFunction newfunc, LabelFunction newlabel ) {
        function = newfunc;
        label = newlabel;
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
