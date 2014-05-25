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
    
    private CalcFunctionFramework framework1, framework2;
    
    public TwoArgumentCalcFunctionFramework( CalcFunction newfunc, LabelFunction newlabel ) {
        super( newfunc, newlabel );
        framework1 = new CalcFunctionFramework( (a,b) -> 0.0, (a,b) -> "0.0" );
        framework2 = new CalcFunctionFramework( (a,b) -> 0.0, (a,b) -> "0.0" );
    }
    
    public void setFramework( CalcFunctionFramework newframe, int index ) {
        if( index == 0 ) framework1 = newframe;
        else framework2 = newframe;
    }
    
    public CalcFunctionFramework getFramework( int index ) {
        if( index == 0 ) return framework1;
        else return framework2;
    }
    
    public double getY( double x ) {
        return function.getY( framework1.getY( x ), framework2.getY( x ));
    }
    
    public String getLabelText() {
        return label.getLabel( framework1.getLabelText(), framework2.getLabelText() );
    }
}
