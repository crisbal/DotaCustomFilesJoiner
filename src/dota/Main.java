package dota;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main
{
	public static final String PROGRAM_NAME = "Dota Custom File Generator";
	
	public static String[] folders = {"heroes","abilities","items","units"};
	public static String[] keys = {"DOTAHeroes","DOTAAbilities","DOTAAbilities","DOTAUnits"};
	public static String[] files = {"npc_heroes_custom.txt","npc_abilities_custom.txt","npc_items_custom.txt","npc_units_custom.txt"};
	
	public static void main(String[] args){
		System.out.println("Starting program");
		
		for(int i=0;i<folders.length;i++){
			System.out.println(generateFileForFolder(folders[i], files[i], keys[i]));
		}		
	}
	
	
	public static String generateFileForFolder(String folder,String filename,String key){
		
		System.out.println("Generating " + filename + " file");
		
		File heroesFolder = new File(folder);
		if (!heroesFolder.isDirectory())
			return "No folder named '" + folder + "' found. '" + filename + "' will not be generated";
		
		FileWriter f;
		try
		{
			f = new FileWriter(filename);
			PrintWriter newFile = new PrintWriter(f);
			
			newFile.println("//Generated using " + PROGRAM_NAME + " by cris9696");
			newFile.println('"'+key+'"');
			newFile.println("{");
			
			//time to write on the new file the file content of all the source file
			for(File file : heroesFolder.listFiles()){
				FileReader fr = new FileReader(file);
				BufferedReader fileSource = new BufferedReader(fr);
				
				newFile.println("\n");
				newFile.println("\t//Start of file " + file.getName());
				
				String line = "";
				while(line!=null)
				{
					line = fileSource.readLine();
					if(line!=null)
						newFile.println("\t" + line);
				}
				fr.close();
				
				newFile.println("\t//End of file " + file.getName());
			}
			newFile.println("}");
			newFile.flush();
			f.close();
			
		} catch (IOException e)
		{
			return "Error: fatal error, operation not completed.\nPlease report to the developer the following: " + e.toString();
		}
		
		return "OK";
		
	}
}
