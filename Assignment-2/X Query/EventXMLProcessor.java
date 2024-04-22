import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class EventXMLProcessor {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            File xmlFile = new File("events.xml");

            Document document = builder.parse(xmlFile);
            Element root = document.getDocumentElement();
            NodeList eventList = root.getElementsByTagName("event");

            for (int i = 0; i < eventList.getLength(); i++) {
                Node eventNode = eventList.item(i);
                if (eventNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eventElement = (Element) eventNode;
                    String category = eventElement.getAttribute("category");
                    String title = eventElement.getElementsByTagName("title").item(0).getTextContent();
                    String organizer = eventElement.getElementsByTagName("organizer").item(0).getTextContent();
                    String date = eventElement.getElementsByTagName("date").item(0).getTextContent();
                    String location = eventElement.getElementsByTagName("location").item(0).getTextContent();
                    String price = eventElement.getElementsByTagName("price").item(0).getTextContent();

                    System.out.println("Category: " + category);
                    System.out.println("Title: " + title);
                    System.out.println("Organizer: " + organizer);
                    System.out.println("Date: " + date);
                    System.out.println("Location: " + location);
                    System.out.println("Price: " + price);
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
