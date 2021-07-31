package Logic;

import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class ScrollPane extends JScrollPane{

    //properties

    //constructors
    public ScrollPane(JPanel panel) {
        super(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }
}
