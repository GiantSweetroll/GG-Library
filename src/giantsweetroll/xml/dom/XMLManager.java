package giantsweetroll.xml.dom;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// TODO: Auto-generated Javadoc
/**
 * The Class XMLManager.
 */
public class XMLManager 
{
	
	/**
	 * Creates the document.
	 *
	 * @param filePath the file path
	 * @param isInputStream if true, it will get the file path using getResourceAsStream() method, if false it will be plain String
	 * @return the document
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Document createDocument(String filePath, boolean isInputStream) throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		if (isInputStream)
		{
			return builder.parse(XMLManager.class.getResourceAsStream(filePath));
		}
		else
		{
			return builder.parse(filePath);
		}
	}
	
	/**
	 * Creates the document.
	 *
	 * @param url the URL of the file
	 * @return the document
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Document createDocument(URL url) throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		return builder.parse(url.toString());
	}
	
	/**
	 * Creates an empty XML document.
	 * @return the document
	 * @throws ParserConfigurationException the parser configuration exception
	 */
	public static Document createDocument() throws ParserConfigurationException
	{
		DocumentBuilderFactory dfc = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dfc.newDocumentBuilder();
		return db.newDocument();
	}
	
	/**
	 * Gets the element at a particular index in a particular Node from the NodeList.
	 *
	 * @param nodeList the NodeList
	 * @param index the index
	 * @return the element
	 */
	public static Element getElement(NodeList nodeList, int index)
	{
		return (Element)nodeList.item(index);
	}
	
	/**
	 * Gets an array of elements in a NodeList.
	 *
	 * @param nodeList the NodeList
	 * @return the array of elements
	 */
	public static ArrayList<Element> getElements(NodeList nodeList)
	{
		ArrayList<Element> elements = new ArrayList<Element>();
		
		for (int i=0; i<nodeList.getLength(); i++)
		{
			Node node = nodeList.item(i);
			elements.add((Element)node);
		}
		
		return elements;
	}
	
	/**
	 * Outputs XML document to file
	 *
	 * @param document the document
	 * @param file the output file
	 */
	public static void exportXML(Document document, File file, int indent) throws TransformerException
	{
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", Integer.toString(indent));
		DOMSource source = new DOMSource(document);
		
		StreamResult streamResult = new StreamResult(file);
		
		transformer.transform(source, streamResult);
	}
}
