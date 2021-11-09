package model;

public abstract class Product{
	/**
	*name, is the name of the product
	*/
	private String name;
	/**
	*directorName, is the name of the director
	*/
	private String directorName;
	/**
	*synopsis, is th synopsis of the product
	*/
	private String synopsis;
	/**
	*date, is the date of the first transmition of the product
	*/
	private Date date;
	/**
	*Constructor of Product
	@param name, is the name of the product
	@param directorName, is the name of the director
	@param synopsis, is th synopsis of the product
	@param date, is the date of the first transmition of the serie
	*/
	Product(String name,String directorName,String synopsis,Date date){
		this.name=name;
		this.directorName=directorName;
		this.synopsis=synopsis;
		this.date=date;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getDirectorName(){
		return directorName;
	}
	
	public void setDirectorName(String directorName){
		this.directorName=directorName;
	}
	
	public String getSynopsis(){
		return synopsis;
	}
	
	public void setSynopsis(String synopsis){
		this.synopsis=synopsis;
	}
	
	public Date getDate(){
		return date;
	}
	public void setDate(Date date){
		this.date=date;
	}
	
	public String toString(){
		return "Nombre: "+name+"\n"+
		       "Nombre del director: "+directorName+"\n"+
			   "Sinopsis:\n"+synopsis+"\n"+
			   "Fecha: "+date;
	}
}