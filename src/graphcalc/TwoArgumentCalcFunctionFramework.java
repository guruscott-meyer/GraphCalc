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
public class TwoArgumentCalcFunctionFramework extends CalcFunctionFramework {
    
    public TwoArgumentCalcFunctionFramework( CalcFunction newfunc, LabelFunction newlabel ) {
        super( newfunc, newlabel );
        framework1 = new CalcFunctionFramework( (a,b) -> 0.0, (a,b) -> "0.0" );
        framework2 = new CalcFunctionFramework( (a,b) -> 0.0, (a,b) -> "0.0" );
    }
    
    public double getY( double x ) {
        return function.getY( framework1.getY( x ), framework2.getY( x ));
    }
    
    public String getLabelText() {
        return label.getLabel( framework1.getLabelText(), framework2.getLabelText() );
    }
}
