package GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class PdfViewPage {
    protected Shell shell;

    public void open() {
        Display display = Display.getDefault();
        createContents();
        shell.open();
        shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    /**
     * Create contents of the window.
     */
    protected void createContents() {
        shell = new Shell();
        shell.setSize(800, 600);
        shell.setText("PDF View");

        Browser browser = new Browser(shell, SWT.NONE);
        browser.setUrl("http://kafemud.bilkent.edu.tr/kumanya_menusu.pdf");

        browser.setBounds(10, 10, 764, 541);

    }

    public static void main(String[] args) {
        try {
            PdfViewPage window = new PdfViewPage();
            window.open();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}