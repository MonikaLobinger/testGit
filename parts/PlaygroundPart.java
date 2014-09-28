// Kommentar zum Testen
package my.example.todo.parts;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class PlaygroundPart {
    private Text text;  // Das ruft keinen Konstruktor auf
    private Browser browser; // Das ruft keinen Konstruktor auf

    @PostConstruct
    public void createControls(Composite parent) 
    {
    	parent.setLayout(new GridLayout(2, false));

    	text = new Text(parent, SWT.BORDER);
    	text.setMessage("Enter City");
    	text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

    	Button button = new Button(parent, SWT.PUSH);
    	button.setText("Search");
    	button.addSelectionListener(new SelectionAdapter() {
    		
    		@Override
    		public void widgetSelected(SelectionEvent e) {
    			browser.setUrl("https://www.google.de/search?q=" + text.getText());
    		}
        } );

    	browser = new Browser(parent, SWT.NONE);
    	browser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
    	browser.setUrl("http://www.oskopia.de");
    }

    @Focus
    private void setFocus() 
    {
    	System.out.println(this.getClass().getSimpleName()  + " setFocus method called");
        text.setFocus();
    } 
  
} 