package dota;

import java.io.Serializable;

public class Config implements Serializable
{
	public String name, inputFolderPath, outputFile, startFile, endFile;
	
	public boolean changeChecker;
	
	
	@Override
	public String toString()
	{
		return name;
	}


	public Config(String name, String inputFolderPath, String outputFilePath, String startFile, String endFile, boolean changeChecker)
	{
		super();
		this.name = name;
		this.inputFolderPath = inputFolderPath;
		this.outputFile = outputFilePath;
		this.startFile = startFile;
		this.endFile = endFile;
		this.changeChecker = changeChecker;
	}
	
	
}
