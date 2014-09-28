package my.test.notes.handlers;

import org.eclipse.e4.core.di.annotations.Execute;

/** Und noch ein Kommentar **/
public class TestHandler
{
@Execute
public void execute() {
  System.out.println((this.getClass().getSimpleName() + " called"));
}
}
