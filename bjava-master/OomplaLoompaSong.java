
package Song;


import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class OomplaLoompaSong
{
	private int lines;
	private ArrayList<String> line;
	private String file = "OompaLoompaSong.txt";

	public OomplaLoompaSong(int lines){
		this.lines = lines;
		line = new ArrayList<>();
	};  
	
	//Getter and Setter for filePath
	public String getfile(){
		return file;
	}   
	public void setfile(String file){
		this.file = file;
	}

	// Return a String with the song
	public void singRandomly(){
		int k = 0;
		readFile();
		for(int i = 0; i < lines; i++){
			Random rnd = new Random();
		    k = rnd.nextInt(line.size()-1);
			System.out.println(line.get(i));
		}
		System.out.println();
	}

	public void singSong(){
		for(int i = 0; i<line.size(); i++){
			System.out.println(line.get(i));
		}
		System.out.println();
	}

	public void readFile()
	{
		try {
			
			int index = 0;
			Scanner read = new Scanner( new File(file) );
			
			while ( read.hasNextLine() )
				{
				line.add(read.nextLine());
				index++;
			}
		} 
		catch (Exception e)
		{
			e.getMessage();
		} 
	}	

}