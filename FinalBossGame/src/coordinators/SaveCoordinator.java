package coordinators;

import map.GameMap;
import java.util.ArrayList;
import map.Pair;
import map.CoordinatePair;
import entity.Entity;
import item.Item;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class SaveCoordinator {
	private static SaveCoordinator saveCoord = SaveCoordinator.getInstance();
	private GameMap activeMap;
	
	/*-----------CONSTRUCTORS--------------*/
	private SaveCoordinator(){};
	
	/*-----------USAGE--------------*/
	
	public void save(){
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML files", "xml");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null); //MAY NOT NEED TO BE NULL		
		if(returnVal == JFileChooser.APPROVE_OPTION){
			System.out.println("Opened the file: " + chooser.getSelectedFile().getName());
		}
		File timeToWrite = chooser.getSelectedFile();
		try{
		PrintWriter writeFile = new PrintWriter(timeToWrite);
		writeFile.println(activeMap.toXML());
		writeFile.close();
		}
		catch(FileNotFoundException a){
			a.printStackTrace();
		}
	}
	
	/*-----------SINGLETON RETRIEVAL--------*/
	public static SaveCoordinator getInstance(){
		if(saveCoord == null){
			saveCoord = new SaveCoordinator();
		}
		return saveCoord;
	}
}
