import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lab_12_File_Away {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                // Get the selected file
                java.io.File selectedFile = fileChooser.getSelectedFile();

                // Process the file and generate the summary report
                processFile(selectedFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void processFile(java.io.File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        String line;
        while ((line = reader.readLine()) != null) {
            lineCount++;
            charCount += line.length();

            String[] words = line.split("\\s+"); // Split the line by spaces
            wordCount += words.length;
        }

        reader.close();

        // Print the summary report
        System.out.println("File Name: " + file.getName());
        System.out.println("Number of Lines: " + lineCount);
        System.out.println("Number of Words: " + wordCount);
        System.out.println("Number of Characters: " + charCount);
    }
}
