import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class bai2 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            
            Element rootElement = doc.createElement("studentList");
            doc.appendChild(rootElement);

            
            addStudent(doc, rootElement, "John", 20, 3.5);
            addStudent(doc, rootElement, "Alice", 22, 3.7);
            addStudent(doc, rootElement, "Bob", 21, 3.2);

            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\path\\to\\directory\\student_list.xml"));

            transformer.transform(source, result);
            System.out.println("XML file has been generated successfully.");

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void addStudent(Document doc, Element rootElement, String name, int age, double gpa) {
        Element student = doc.createElement("student");
        rootElement.appendChild(student);

        // Name element
        Element nameElement = doc.createElement("name");
        nameElement.appendChild(doc.createTextNode(name));
        student.appendChild(nameElement);

        // Age element
        Element ageElement = doc.createElement("age");
        ageElement.appendChild(doc.createTextNode(String.valueOf(age)));
        student.appendChild(ageElement);

        // GPA element
        Element gpaElement = doc.createElement("gpa");
        gpaElement.appendChild(doc.createTextNode(String.valueOf(gpa)));
        student.appendChild(gpaElement);
    }
}
