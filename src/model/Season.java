package model;

public class Season{
	/**
	* chapters, is the amount of chapters
	*/
	private int chapters;
	/**
	* trailerPath, is the path to the trailer
	*/
	private String trailerPath;
	/**
	*date, is the date of first transmission of the serie
	*/
	private Date date;
	/**
	*Constructor of Season
	@param chapters,is the amount of chapters
	@param trailerPath,is the path to the trailer
	@param date, is the date of first transmission of the serie
	*/
	public Season(int chapters,String trailerPath,Date date){
		this.chapters=chapters;
		this.trailerPath=trailerPath;
		this.date=date;
	}
	public String toString(){
		return "Capitulos: "+chapters+"\n"+
				"Trailer: "+trailerPath+"\n"+
				"Fecha: "+date;
	}
	
}