import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import javax.swing.JFileChooser;

public class ShortLister {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));


            chooser.setCurrentDirectory(workingDirectory);

            chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                public boolean accept(File f) {
                    return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");
                }

                public String getDescription() {
                    return "Text Files (*.txt)";
                }
            });

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                int wordLengthThreshold = 5;

                InputStream in = Files.newInputStream(selectedFile.toPath());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                int line = 0;
                StringBuilder shortWordsRow = new StringBuilder();
                while (reader.ready()) {
                    line++;
                    String[] words = reader.readLine().split("\\s+");
                    for (String word : words) {
                        if (word.length() <= wordLengthThreshold) {
                            shortWordsRow.append(word).append(" ");
                        }
                    }
                }

                reader.close();

                System.out.println(shortWordsRow.toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
