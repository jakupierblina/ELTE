
package Song;

//OompaLoompa (code, name, height, favorite food (can be a String))

public class OomplaLoompa extends Beings
{
	private double height;
	private String favfood;
	
	//Constructor
	public OomplaLoompa (int code,String name, double height, String favfood)
	{
		super(code,name);
		
		this.height=height;
		this.favfood=favfood;
		
	}
	
	/* Getters & Setters */
	
	public void setHeight(double height)
	{
		this.height=height;
	}
	public double getHeight()
	{
		return height;
	}
	
	public void setFavfood(String favfood)
	{
		this.favfood=favfood;
	}
	public String getFavfood()
	{
		return favfood;
	}

	@Override
	public String toString()
	{
		return 	super.toString()+" " + "height;" + height + "favorite food; " + favfood;
	}
}