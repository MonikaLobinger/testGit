// Immer werden die Kommentare vergessen
package my.test.notes.handlers;

import java.util.Date;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

import my.test.notes.model.ITodoService;
import my.test.notes.model.Todo;
import my.test.notes.wizards.TodoWizard;

/** Und noch ein Kommentar **/
public class NewTodoHandler
{
@Execute
public void execute(Shell shell, ITodoService todoService)
{
    Todo todo = new Todo();
    todo.setDueDate(new Date());
    WizardDialog dialog = new WizardDialog(shell, new TodoWizard(todo));
    if(dialog.open() == WizardDialog.OK) {
        // call service to save Todo object
        todoService.saveTodo(todo);
    }

}
}
