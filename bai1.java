import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class bai1 {

    public static void main(String[] args) {
        String directoryPath = ""; 
        File directory = new File(directoryPath);
        StringBuilder xmlBuilder = new StringBuilder();
        generateXML(directory, xmlBuilder);
        writeXMLToFile(xmlBuilder.toString(), "directory_structure.xml");
    }

    public static void generateXML(File directory, StringBuilder xmlBuilder) {
        xmlBuilder.append("<directory name=\"").append(directory.getName()).append("\">\n");
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        generateXML(file, xmlBuilder);
                    } else {
                        xmlBuilder.append("<file>").append(file.getName()).append("</file>\n");
                    }
                }
            }
        }
        xmlBuilder.append("</directory>\n");
    }

    public static void writeXMLToFile(String xmlContent, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(xmlContent);
            fileWriter.close();
            System.out.println("XML file has been generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
