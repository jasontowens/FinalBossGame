/*
 * IDGenerator class is used with every Model object to generate a UID or return a used UID for reuse. The following public methods should be used:
 * 		generateID( String objectName) - creates a node in the UID xml file with a randomly generated unique ID which is then returned as an int
 * 		returnID( int ID) - deletes the given ID from the XML sheet 
 */



package model;

import java.io.File;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class IDGenerator {

	private static final String FILEPATH = ".\\misc\\ids.xml";
	private Document doc;
	private File file;

	
	//helper method used by generateID to get a random UID for a created object
	private int randInt( int min, int max){
		
		Random r = new Random();
		
		int randInt = r.nextInt((max - min) + 1) + min;
		return randInt;
	}
	
	private void saveToFile(){
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		
		try { 
			
			//for output to file
			transformer = transformerFactory.newTransformer(); 
			
			//for printing to file
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			
			//write to the file
			StreamResult streamFile = new StreamResult(file);
			
			//flush the output
			transformer.transform(source, streamFile);
		} catch (Exception e) {

			e.printStackTrace();
		}
       
	}
	//sets up necessary components to be used in later methods
	public IDGenerator(){
		
		file = new File(FILEPATH);
		
		
		if (!( file.exists() && file.canRead() ) ){
			System.err.println("Error: cannot read " + FILEPATH + ". Exiting now.");
			
			System.exit(1);
		}
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		
		try {
			db = dbFactory.newDocumentBuilder();	
			doc = db.parse(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	//Creates a UID and adds it to the given XMNL file. 
	//If the ID is incapable of being created (all IDs are taken), -1 is returned
	public int generateID(String objectName){
		Element newNode = doc.createElement("ID");
		NodeList nodes = doc.getFirstChild().getChildNodes();
		
		int id = randInt(100000, 999999);
		
		for (int i = 0; i != nodes.getLength(); ++i){
			Node n = (Node)nodes.item(i);
			
			if (String.valueOf(id) == n.getNodeValue()){
				id = randInt(100000, 999999);
				i = -1;
			}
		}		
		
		//check if ID is still a duplicate
		for (int i = 0; i != nodes.getLength(); ++i){
			Node n = (Node)nodes.item(i);
			
			//if the ID is a duplicate of an existing ID, return -1 and do not save anything to file
			if (String.valueOf(id) == n.getNodeValue()){
				return -1;
			}
		}
		
		newNode.setTextContent(String.valueOf(id));
		newNode.setAttribute("className", objectName);
		doc.getFirstChild().appendChild(newNode);
		
       
		saveToFile();

		
		
		return id;
	}
	
	public void returnID(int ID){
		NodeList nodes = doc.getFirstChild().getChildNodes();
		
		for (int i = 0; i != nodes.getLength(); ++i){
			Node n = (Node) nodes.item(i);
			
			if (String.valueOf(ID) == n.getNodeValue()){
				doc.getFirstChild().removeChild(n);
				break;
			}
		}
		
		saveToFile();
		return;
	}
}
