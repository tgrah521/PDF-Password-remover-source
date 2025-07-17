import java.io.File;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;

public class PdfPasswordRemover {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Nutzung: java PdfPasswordRemover input.pdf output.pdf passwort");
            return;
        }

        String inputPath = args[0];
        String outputPath = args[1];
        String password = args[2];

        try {
            File inputFile = new File(inputPath);
            PDDocument document = Loader.loadPDF(inputFile, password);

            document.setAllSecurityToBeRemoved(true);

            document.save(outputPath);
            document.close();

            System.out.println("Erfolgreich entschlüsselt und gespeichert: " + outputPath);
        } catch (Exception e) {
            System.out.println("Fehler beim Entschlüsseln: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
