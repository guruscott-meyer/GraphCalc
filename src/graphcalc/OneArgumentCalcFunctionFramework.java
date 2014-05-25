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
public class OneArgumentCalcFunctionFramework extends CalcFunctionFramework{
    
    private CalcFunctionFramework framework;
    
    public OneArgumentCalcFunctionFramework( CalcFunction newfunc, LabelFunction newlabel ) {
        super( newfunc, newlabel );
        framework = new CalcFunctionFramework( (a,b) -> 0.0, (a,b) -> "0.0" );
    }
    
    public void setFramework( CalcFunctionFramework newframe ) {
        framework = newframe;
    }
    
    public CalcFunctionFramework getFramework() {
        return framework;
    }
    
    public double getY( double x ) {
        return function.getY( framework.getY( x ), 0 );
    }
    
    public String getLabelText() {
        return label.getLabel( framework.getLabelText(), "" );
    }
}
