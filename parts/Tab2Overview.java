package my.example.todo.parts;

//import java.awt.BorderLayout;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.swt.SWT;
//import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.e4.ui.services.EMenuService;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.di.PersistState;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
//import org.eclipse.e4.ui.workbench.IModelResourceHandler;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.jface.viewers.TableViewer;
//import org.eclipse.swt.widgets.Text;

public class Tab2Overview {

	
	@Inject // Construction injection
	public Tab2Overview(Composite parent)
	{
		System.out.println("Tab2Overview constructed");
	}
	
	@PostConstruct
	public void createControls(Composite parent,  IWorkbench workbench, EMenuService menuService) 
	{
		System.out.println("Tab2Overview post Construct");
		TableViewer viewer = new TableViewer(parent, SWT.FULL_SELECTION | SWT.MULTI);		
		
		 // register context menu on the table
	    menuService.registerContextMenu(viewer.getControl(), "my.example.todo.popupmenu.table");		
	}	
	
    @PreDestroy
    public void preDestroy() 
    {
        System.out.println("Tab2Overview pre Destroy");
    }
    
	@Inject
	@Optional
	public void receiveActivePart(@Named(IServiceConstants.ACTIVE_PART) MPart activePart) {
	  if (activePart != null) {
	  System.out.println("Active part changed " + activePart.getLabel());
	  }
	} 	
	
    @Focus
    public void onFocus() 
    {
        System.out.println(this.getClass().getSimpleName()  + " onFocus method called");
    }
    
    @Persist
    public void save(){
        //save the context of the part
    }
    
    @PersistState
    public void retteAlles()
    {
        // A method marked with @PersistState is called before an object is disposed and 
        // before the method marked with @PreDestroy is called. The purpose of this method 
        // is to persist the latest state of an element if required. If the method is a view, 
        // the latest input by the user could be stored for convenience.
    }

	
}
