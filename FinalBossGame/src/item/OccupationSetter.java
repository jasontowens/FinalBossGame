package item;

import entity.Entity;
import entity.Occupation;

public class OccupationSetter extends Interactive{
	private String jobName;
	
	public OccupationSetter(String className, String name, String description, String jobName){
		super(className, name, description)
		this.jobName = jobName;
	}
	public OccupationSetter(String className, String name, String description, boolean hasActivated String jobName){
		super(className, name, description, hasActivated);
		this.jobName = jobName;
	}
	
	public boolean activate(Entity entity){
		entity.setOccupation(jobName);
	}
}