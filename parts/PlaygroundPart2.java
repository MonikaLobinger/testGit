package my.example.todo.parts;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import my.example.bundleresourceloader.IBundleResourceLoader;

public class PlaygroundPart2 {
  @PostConstruct
  public void createControls(Composite parent, IBundleResourceLoader loader) {
    Label label = new Label(parent, SWT.NONE);
    // the following code assumes that you have a vogella.png file
    // in a folder called "images" in this plug-in
    label.setImage(loader.loadImage(this.getClass(), "images/MusicDomains.png"));
  }
} 