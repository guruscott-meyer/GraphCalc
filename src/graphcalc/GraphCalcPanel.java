/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphcalc;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.beans.*;

/**
 *
 * @author Scott Meyer
 */
public class GraphCalcPanel extends JPanel implements MouseInputListener, PropertyChangeListener{
    
    static final int SCALE_MULT = 2;
    static final int LABEL_OFFSET = 30;
    static final int NUM_MARKS  = 10;
    static final int MARK_LENGTH = 10;
    //static final Integer RESOLUTION = 100;
    
    private static CalcFunction function;
    private static double scale;
    private static Point origin;
    private static boolean graphing;
    private static Color color;
    
    private static Point oldLocation;
    
    public GraphCalcPanel() {
        
        super();
               
        scale = 10.0;
        origin = new Point( 0, getHeight() );
        graphing = false;
        oldLocation = new Point( 0, 0 );
        color = Color.RED;
        
        this.setOpaque( true );
        this.setBackground( Color.white );
        
        init();
    }
    
    private void init() {
        addMouseListener( this );
        addMouseMotionListener( this );
        addPropertyChangeListener( this );
    }
    
    public void setFunction( CalcFunction newFunc )
         {
         function = newFunc;
         }
    
    public CalcFunction getFunction()
         {
         return function;
         }
    
    public void setGraphing( boolean newgraphing )
         {
         boolean oldGraphing = graphing;
	 graphing = newgraphing;
         firePropertyChange( "graphing", oldGraphing, graphing );
	 }

    public boolean isGraphing()
         {
	 return graphing;
	 }
    
    public void setScale( double newScale ) {
        double oldScale = scale;
        scale = newScale;
        firePropertyChange( "scale", oldScale, scale );
    }
    
    public double getScale() {
        return scale;
    }
       
    public void setOrigin( Point newOrigin ) {
        Point oldOrigin = origin;
        origin = newOrigin;
        firePropertyChange( "origin", oldOrigin, origin );
    }
    
    public Point getOrigin() {
        return origin;
    }
    
    public void resetOrigin() {
        setOrigin( new Point( 0, 0 ) );
    }
    
    public void setColor( Color newColor ) {
        color = newColor;
    }
    
    public Color getColor() {
        return color;
    }
   
    @Override
    public void paint( Graphics g )
         {
	 //g.setColor( Color.blue );
	 g.clearRect( 0, 0, getWidth(), getHeight() );
	 g.setColor( Color.black );
	 g.setFont( g.getFont().deriveFont( (float) 10 ) );
         
	 g.translate( origin.x, origin.y );
         
         //First, the coordinate plane grid lines
         g.drawLine( 0, - origin.y, 0, getHeight() - origin.y );  //y axis line
         g.drawLine( getWidth() - origin.x, getHeight(), 0 - origin.x, getHeight() ); //x axis line

         //Marks on the grid lines
         //x axis marks
	 for( int i = -origin.x + origin.x % ( getWidth() / NUM_MARKS ); i < getWidth() - origin.x; i += getWidth() / NUM_MARKS ) {
	    g.drawLine( i, getHeight() + MARK_LENGTH, i, getHeight() - MARK_LENGTH );
            //System.out.println( origin.x % 10 );
         }
         //y axis marks
	 for( int i = -origin.y + origin.y % ( getHeight() / NUM_MARKS ); i < getHeight() - origin.y; i += getHeight() / NUM_MARKS )
	    g.drawLine( MARK_LENGTH, i, -MARK_LENGTH, i );

         //Labels to indicate scale
	 g.drawString( String.valueOf( scale ), 
		      getWidth() - String.valueOf( scale ).length() - origin.x - LABEL_OFFSET,
		      getHeight() );

         g.drawString( String.valueOf( scale ), 0, 
		      LABEL_OFFSET - origin.y );

         //draw the graph
         if( graphing && function != null ) {
             g.setColor( color );
                for( int j = -origin.x; j < getWidth() - origin.x; j++ )
                    g.drawLine(j, getHeight() - new Double(function.getY(new Integer( j ).doubleValue() / new Integer( getWidth() ).doubleValue() * scale ) * getHeight() / scale ).intValue(),
                            j + 1, getHeight() - new Double(function.getY(new Integer( j + 1 ).doubleValue() / new Integer( getWidth() ).doubleValue() * scale ) * getHeight() / scale ).intValue());
                }
         }
    
    @Override
    public void propertyChange( PropertyChangeEvent e )  {
        repaint();
    }
    
    @Override
    public void mouseDragged( MouseEvent e ) {
        Point newLocation = e.getLocationOnScreen();
        origin.translate( newLocation.x - oldLocation.x, newLocation.y - oldLocation.y );
        repaint();
        oldLocation = newLocation;
    }
    
    @Override
    public void mouseMoved( MouseEvent e ) {
        
    }
    
    @Override
    public void mouseClicked( MouseEvent e ) {
        
    }
    
    @Override
    public void mousePressed( MouseEvent e ) {
        //System.out.println( "now in mousePressed method" );
        oldLocation = e.getLocationOnScreen();
    }
    
    @Override
    public void mouseReleased( MouseEvent e ) {
        
    }
    
    @Override
    public void mouseEntered( MouseEvent e ) {
        
    }
    
    @Override
    public void mouseExited( MouseEvent e ) {
        
    }

}
