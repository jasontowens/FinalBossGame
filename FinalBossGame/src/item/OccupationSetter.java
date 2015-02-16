package item;

import entity.Entity;
import entity.Occupation;

public class OccupationSetter extends Interactive{
	private String jobName;
	
	protected OccupationSetter(String className, String name, String description, int ID, String jobName){
		super(className, name, description, ID); //TODO: change ID to how Hanif wants it set up 
		this.jobName = jobName;
	}
	public OccupationSetter(String name, String description, int ID, String jobName){
		super("OccupationSetter", name, description, ID); //TODO: change ID to how Hanif wants it set up 
		this.jobName = jobName;
	}
	protected OccupationSetter(String className, String name, String description, int ID, boolean hasActivated, String jobName){
		super(className, name, description, ID, hasActivated); //TODO: change ID to how Hanif wants it set up 
		this.jobName = jobName;
	}
	public OccupationSetter(String name, String description, int ID, boolean hasActivated, String jobName){
		super("OccupationSetter", name, description, ID, hasActivated); //TODO: change ID to how Hanif wants it set up 
		this.jobName = jobName;
	}
	
	public boolean activate(Entity entity){
		entity.setOccupation(jobName);
		//this should block movement
		return false;
	}
}