package my.example.todo.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import my.example.todo.model.Todo;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;
//import org.eclipse.swt.events.SelectionAdapter;
//import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Text;

public class DetailsPart2
{
    private Text txtSummary;
    private Text txtDescription;
    private DateTime dateTime;
    private Button btnDone;
    
    private Todo todo;
    
    @PostConstruct
    public void createControls(Composite parent) 
    {
      parent.setLayout(new GridLayout(2, false));

      Label lblSummary = new Label(parent, SWT.NONE);
      lblSummary.setText("Summary");

      txtSummary = new Text(parent, SWT.BORDER);
      txtSummary.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
          false, 1, 1));

      Label lblDescription = new Label(parent, SWT.NONE);
      lblDescription.setText("Description");

      txtDescription = new Text(parent, SWT.BORDER| SWT.MULTI| SWT.V_SCROLL);
      txtDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
          true, 1, 1));

      Label lblNewLabel = new Label(parent, SWT.NONE);
      lblNewLabel.setText("Due Date");

      dateTime = new DateTime(parent, SWT.BORDER);
      dateTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
          1, 1));
      new Label(parent, SWT.NONE);

      btnDone = new Button(parent, SWT.CHECK);
      btnDone.setText("Done");
      
      updateUserInterface(todo);
    }
    
    @Inject
    public void setTodo(@Optional 
        @Named(IServiceConstants.ACTIVE_SELECTION) Todo todo) {
      if (todo != null) {
        // remember todo as field
        this.todo = todo;
      } 
      // update the user interface
      updateUserInterface(todo);
    }
    
    // allows to disable/ enable the user interface fields
    // if no todo is set
   private void enableUserInterface(boolean enabled) {
     if (txtSummary != null && !txtSummary.isDisposed()) {
       txtSummary.setEnabled(enabled);
       txtDescription.setEnabled(enabled);
       dateTime.setEnabled(enabled);
       btnDone.setEnabled(enabled);
     }
   }
   
   private void updateUserInterface(Todo todo) {
       // if Todo is null disable user interface
       // and leave method
       if (todo == null) {
         enableUserInterface(false);
         return;
       } 

       // check if the user interface is available
       // assume you have a field called "summary"
       // for a widget
       if (txtSummary != null && !txtSummary.isDisposed()) {
         enableUserInterface(true);
         txtSummary.setText(todo.getSummary());
         // more code to fill the widgets with data from your Todo object
         // more code
         // ....
         // ....
       }
   }
       
   @Focus 
    public void onFocus() {
      // The following assumes that you have a Text field
      // called summary
        txtSummary.setFocus();
    }     
}
