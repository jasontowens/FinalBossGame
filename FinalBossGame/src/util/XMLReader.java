package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/*
 * General purpose utility that provides XML Reading. Can be reused wherever 
 * XML needs to be read. Can either return parsed document or
 * all elements containing specified tag.
 * 
 * 
 * Refactored to be a singleton class.
 * 
 * @author: Hanif
 */
public class XMLReader {
	
	
	private DocumentBuilderFactory factory;
	private static XMLReader reader = null;
	DocumentBuilder db;
	Document doc = null;
	private XMLReader(InputStream is){
		factory = DocumentBuilderFactory.newInstance();
		try {
			db = factory.newDocumentBuilder();
			doc = db.parse(new InputSource(is));
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			System.out.println("Parser Coniguration Exception");
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			System.out.println("SAXException");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO Exception");
			e.printStackTrace();
		}
	}
	
	public static XMLReader getInstance(InputStream is){
		if(reader == null){
			reader = new XMLReader(is);
		}
		
		return reader;
	}
	
	public Document parseDocument(){
		if(doc == null){
			System.out.println("Error creating XMLReader instance, check InputStream");
		}
		return doc;
	}
	
	
	
	//returns ArrayList of all children of element 'e' with tag 'tag'
	
	public List<Element> getElements(String tag , Element e){
		ArrayList<Element> elements = new ArrayList<Element>();
		NodeList nodes = e.getElementsByTagName(tag);

		for(int i = 0; i < nodes.getLength(); ++i){
			elements.add( (Element) (nodes.item(i)));
		}
		
		return elements;		
	}
}







