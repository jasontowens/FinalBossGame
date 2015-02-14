package item;

import entity.Entity;
import entity.Occupation;

public class OccupationSetter extends Interactive{
	private String jobName;
	
	protected OccupationSetter(String className, String name, String description, String spriteFilePath, String jobName){
		super(className, name, description, spriteFilePath);
		this.jobName = jobName;
	}
	public OccupationSetter(String name, String description, String spriteFilePath, String jobName){
		super("OccupationSetter", name, description, spriteFilePath);
		this.jobName = jobName;
	}
	protected OccupationSetter(String className, String name, String description, String spriteFilePath, boolean hasActivated, String jobName){
		super(className, name, description, spriteFilePath, hasActivated);
		this.jobName = jobName;
	}
	public OccupationSetter(String name, String description, String spriteFilePath, boolean hasActivated, String jobName){
		super("OccupationSetter", name, description, spriteFilePath, hasActivated);
		this.jobName = jobName;
	}
	
	public boolean activate(Entity entity){
		entity.setOccupation(jobName);
	}
}