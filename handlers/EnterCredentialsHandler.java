package my.test.notes.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;

import my.test.notes.dialogs.PasswordDialog;

/** Und noch ein Kommentar **/
public class EnterCredentialsHandler
{
@Execute
public void execute(Shell shell)
{
    PasswordDialog dialog = new PasswordDialog(shell);

    // get the new values from the dialog
    if(dialog.open() == Window.OK) {
        String user = dialog.getUser();
        String pw = dialog.getPassword();
        System.out.println(user);
        System.out.println(pw);
    }
}
}
