package Logic;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfReader {

    //properties
    String fileName = "C:\\Users\\Amir Aliyev\\Downloads\\kumanya_menusu.pdf"; // provide the path to pdf file
    PDDocument document = null;
    String pdfText;

    public String give() throws IOException {

        document = PDDocument.load( new File(fileName));
        PDFTextStripper stripper = new PDFTextStripper();
        pdfText = stripper.getText(document).toString();
        System.out.println( "Text in the area:" + pdfText);

        return pdfText;
    }
}
