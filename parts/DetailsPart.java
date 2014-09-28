// Kommentar zum Testen
package my.example.todo.parts;

import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Font;
//import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
//import org.eclipse.swt.widgets.Display;


import javax.annotation.PostConstruct;


//import org.eclipse.gef4.common.*;
//import org.eclipse.gef4.geometry.*;
//import org.eclipse.gef4.geometry.planar.*;
//import org.eclipse.gef4.graph.*;
//import org.eclipse.gef4.layout.*;
//import org.eclipse.gef4.graphics
//import org.eclipse.gef4.mvc.*; Braucht org.eclipse.platform - und das kollidiert mit org.eclipse.e4

//import org.eclipse.draw2d.Figure;
//import org.eclipse.draw2d.FreeformLayer;
//import org.eclipse.draw2d.FreeformLayout;
//import org.eclipse.draw2d.GridLayout;
//import org.eclipse.draw2d.IFigure;
//import org.eclipse.draw2d.MarginBorder;
//import org.eclipse.gef.editparts.AbstractGraphicalEditPart;



public class DetailsPart {

	@Inject
	DetailsPart(Composite parent) 
	{
		// assuming that dependency injection works 
		// parent will never be null
		System.out.println("Woh! Got a Composite via DI.");
		  
		// does it have a layout manager?
		System.out.println("Layout: " + parent.getLayout().getClass());
    }

	@PostConstruct
	public void createControls(final Composite parent) 
	{
	    System.out.println(this.getClass().getSimpleName()  + " @PostConstruct method called.");
	    parent.setLayout(new GridLayout(2, false));
	    final Display display = parent.getDisplay();
    	//Layout layout = parent.getLayout();
	    //Shell shell = display.getActiveShell();
    	
	    //final Canvas canvas = new Canvas(parent, SWT.NONE);
	    final Font font = new Font(display,"Wiegel Kurrent",14,SWT.BOLD | SWT.ITALIC); 
	    
	    
    	parent.addPaintListener(new PaintListener() {
    		@Override
    		public void paintControl(PaintEvent event) {
    			Rectangle rect = parent.getClientArea();
                int width = rect.width; 
                int height = rect.height; 
                //GC gc = event.gc;

    			event.gc.drawOval(0, 0, width - 1, height - 1);
               
                event.gc.drawLine(0,0,width, height); 
                
                event.gc.setLineWidth(3); 
                event.gc.drawOval(10,140,40,40); 
                event.gc.setLineWidth(1); 
                event.gc.setLineStyle(SWT.LINE_DOT); 
                event.gc.setForeground(display.getSystemColor(SWT.COLOR_BLUE)); 
                event.gc.drawRectangle(100,10,60,40);
                
                
                event.gc.drawText("Hello World",10,80); 
                event.gc.setBackground(display.getSystemColor(SWT.INHERIT_DEFAULT)); 
                event.gc.setForeground(display.getSystemColor(SWT.COLOR_BLUE)); 
                event.gc.setFont(font); 
                event.gc.drawText("Hello\tThere\nWide\tWorld",10,200); 
    		}
    	});
        //font.dispose();      
	} 	
}

