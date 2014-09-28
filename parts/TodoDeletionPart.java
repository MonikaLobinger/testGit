package my.example.todo.parts;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import my.example.todo.model.ITodoService;
import my.example.todo.model.Todo;

public class TodoDeletionPart {
  @Inject
  private ITodoService todoService;
  private ComboViewer viewer;

  @PostConstruct
  public void createControls(Composite parent) {
    parent.setLayout(new GridLayout(2, false));
    viewer = new ComboViewer(parent, SWT.READ_ONLY);
    viewer.setLabelProvider(new LabelProvider() {
      @Override
      public String getText(Object element) {
        Todo todo = (Todo) element;
        return todo.getSummary();
      }
    });
    viewer.setContentProvider(ArrayContentProvider.getInstance());

    List<Todo> todos = todoService.getTodos();
    updateViewer(todos);

    Button button = new Button(parent, SWT.PUSH);
    button.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
          ISelection selection = viewer.getSelection();
          IStructuredSelection sel = (IStructuredSelection) selection;
          if (sel.size() > 0) {
            Todo firstElement = (Todo) sel.getFirstElement();
            todoService.deleteTodo(firstElement.getId());
            updateViewer(todoService.getTodos());
          }

        }
      });
      button.setText("Delete selected");
    }

    private void updateViewer(List<Todo> todos) {
      viewer.setInput(todos);
      if (todos.size() > 0) {
        viewer.setSelection(new StructuredSelection(todos.get(0)));
      }
    }

    @Focus
    public void focus() {
      viewer.getControl().setFocus();
    }
  }       