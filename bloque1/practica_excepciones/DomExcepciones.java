import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomExcepciones {

    public static void main(String[] args) {

        String fichero   = "equipos.xml";        // PRUEBAS 1, 2 y 7
        String etiqueta  = "nombre";             // PRUEBA 3
        String atributo  = "ciudad";             // PRUEBA 4
        String expresion = "/equipos/equipo";    // PRUEBAS 5 y 6

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(fichero));
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList equipos = (NodeList) xPath.compile(expresion).evaluate(doc, XPathConstants.NODESET);

            for (int i = 0; i < equipos.getLength(); i++) {
                Element equipo = (Element) equipos.item(i);
                String nombre = equipo.getElementsByTagName(etiqueta).item(0).getTextContent();
                String ciudad = equipo.getAttribute(atributo);
                System.out.println("Equipo: " + nombre + " (ciudad: " + ciudad + ")");
            }

        } catch (ParserConfigurationException e) {
            System.out.println("Error de configuración del analizador: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de lectura del fichero XML (" + e.getClass().getSimpleName() + "): " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error SAX (" + e.getClass().getSimpleName() + "): " + e.getMessage());
        } catch (XPathExpressionException e) {
            System.out.println("Error en la expresión XPath: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Otro error (" + e.getClass().getSimpleName() + "): " + e.getMessage());
        }
    }
}