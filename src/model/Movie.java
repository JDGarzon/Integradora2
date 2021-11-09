package model;

public class Movie extends Product{
	/**
	*producer, is the name of the producer
	*/
	private String producer;
	/**
	*minimunAge, is the minimun age to see the movie
	*/
	private int minimunAge;
	/**
	*trailerPath, is the path to the trailer
	*/
	private String trailerPath;
	/**
	*indexCategory, is the index to choose the category 
	*/
	private Category category;
	/**
	*Constructor of Movie
	@param name, is the name of the movie
	@param directorName, is the name of the director
	@param synopsis, is th synopsis of the movie
	@param date, is the date of the first transmition of the movie
	@param producer, is the name of the producer
	@param minimunAge, is the minimun age to see the movie
	@param trailerPath, is the path to the trailer
	@param indexCategory, is the index to choose the category 
	*/
	public Movie(String name,String directorName,String synopsis,Date date,String producer,int minimunAge,String trailerPath,int indexCategory){
		super(name,directorName,synopsis,date);
		this.producer=producer;
		this.minimunAge=minimunAge;
		this.trailerPath=trailerPath;
		switch(indexCategory){
			case 1:
				this.category=Category.ROMANTICA;
				break;
			case 2:
				this.category=Category.ACCION;
				break;
			case 3:
				this.category=Category.SUSPENSO;
				break;
			case 4:
				this.category=Category.TERROR;
				break;
			case 5:
				this.category=Category.COMEDIA;
				break;
		}
	}
	
	public String getProducer(){
		return producer;
	}
	
	public void setProducer(String producer){
		this.producer=producer;
	}
	
	public int getMinimunAge(){
		return minimunAge;
	}
	
	public void setMinimunAge(int minimunAge){
		this.minimunAge=minimunAge;
	}
	
	public String getTrailerPath(){
		return trailerPath;
	}
	
	public void setTrailerPath(String trailerPath){
		this.trailerPath=trailerPath;
	}
	
	public Category getCategory(){
		return category;
	}
	
	public void setCategory(Category category){
		this.category=category;
	}
	
	public String toString(){
		return super.toString()+"\n"+
		       "Prodctora: "+producer+"\n"+
			   "Edad minima: "+minimunAge+"\n"+
			   "Trailer: "+trailerPath;
	}

}