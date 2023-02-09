
/**
 * Write a description of class SysOuPutToTextArea here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;


public class SysOuPutToTextArea extends OutputStream
{   public JTextArea textArea;
     
    public SysOuPutToTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }
     
    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
        textArea.append(String.valueOf((char)b));
        // scrolls the text area to the end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    
}
