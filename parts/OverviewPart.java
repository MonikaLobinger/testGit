package my.example.todo.parts;

// See https://sites.google.com/site/tyroprogramming/java/rcp/nb-visual-library-in-rcp

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
//import javax.inject.Named;

//import my.example.todo.MyGraphScene;
import my.example.todo.model.ITodoService;

//import org.eclipse.e4.core.contexts.IEclipseContext;
//import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
//import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
//import org.eclipse.swt.events.SelectionListener;

//import java.awt.BorderLayout;

//import javax.swing.JScrollPane;

public class OverviewPart {
	@Inject
	public OverviewPart() {
	}
	
	// The re-injection only works on methods and fields which are marked with @Inject. 
	// It will not work on parameters injected into constructors and methods which are marked 
	// with @PostConstruct, as these methods are only executed once.
	  private static final String NUMBER_OF_TODO_ITEMS = "Number of Todo items: ";
	  private Button btnLoadData;
	  private Label lblNumberOfTodo;

	  @PostConstruct
	  public void createControls(Composite parent, final ITodoService todoService) 
	  {
	    parent.setLayout(new GridLayout(2, false));

	    btnLoadData = new Button(parent, SWT.PUSH);
	    btnLoadData.addSelectionListener(new SelectionAdapter() {
	      @Override
	      public void widgetSelected(SelectionEvent e) {
	        lblNumberOfTodo.setText(NUMBER_OF_TODO_ITEMS
	            + todoService.getTodos().size());
	      }
	    });
	    btnLoadData.setText("Load Data");

	    lblNumberOfTodo = new Label(parent, SWT.NONE);
	    lblNumberOfTodo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
	        false, 1, 1));
	    lblNumberOfTodo.setText("Data not available.");

        //ITodoService todoService = TodoServiceFactory.getInstance();
        System.out.println("!!! Number of Todo Objects" + todoService.getTodos().size());
	  }

	  @Focus
	  public void setFocus() 
	  {
	    btnLoadData.setFocus();
	  }     

    
    @PreDestroy
    public void preDestroy(Composite parent)
    {
        // SWT widgets are not automatically garbage collected. 
        // If you release an SWT widget, you have to call its dispose() method. 
        // Fortunately a container, e.g. a Shell, also releases all its children.
        // The automatic release does not work for 
        // Color, Cursor, Display, Font, GC, Image, Printer, Region, Widget and subclasses. 
        // All of these SWT objects need to be manually disposed.        
    }
    
}
