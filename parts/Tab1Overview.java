package my.example.todo.parts;

import java.awt.BorderLayout;

//import javax.annotation.PostConstruct;
import javax.inject.Inject;
//import javax.swing.JScrollPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;

public class Tab1Overview {

    @Inject  // Setter Injection
	public Tab1Overview(Composite parent) {
        // Prepare awt container
        Composite swtAwtComponent = new Composite(parent, SWT.EMBEDDED);
        java.awt.Frame frame = SWT_AWT.new_Frame(swtAwtComponent);
        javax.swing.JPanel panel = new javax.swing.JPanel();
        frame.add(panel);
        panel.setLayout(new BorderLayout());
        //JScrollPane scrollPane = new JScrollPane();
        
        // Add the graph scene
        //MyGraphScene scene = new MyGraphScene();
        //scrollPane.setViewportView(scene.createView());
        //panel.add(scrollPane, BorderLayout.CENTER);
        //panel.add(scene.createSatelliteView(), BorderLayout.WEST);
    }
	
}
