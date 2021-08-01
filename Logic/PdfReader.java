package Logic;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfReader {

    //properties
    PDDocument document;
    String text;
    URL bilmenu;

    public String give() throws IOException {
        bilmenu = new URL("http://kafemud.bilkent.edu.tr/kumanya_menusu.pdf");
        PDDocument document = PDDocument.load(bilmenu.openStream());
        if (!document.isEncrypted()) {
            PDFTextStripper stripper = new PDFTextStripper();
            text = stripper.getText(document);
            System.out.println("Text:" + text);
        }
        document.close();
        return text;
    }
}
