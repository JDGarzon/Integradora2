package model;

public class Serie extends Product{
	/**
	*protagistsName, is the name of the protanists
	*/
	private String protagistsName;
	/**
	*motive, is the motive for censourship 
	*/
	private String motive;
	/**
	*censourship, is SI or NO
	*/
	private Censourship censourship;
	/**
	*season are the seasons of the serie
	*/
	private Season [] season;
	/**
	*NUMSEASONS, is the number of possibles seasons
	*/
	public final int NUMSEASONS=100;
	
	/**
	*Constructor of Serie
	@param name, is the name of the serie
	@param directorName, is the name of the director
	@param synopsis, is th synopsis of the serie
	@param date, is the date of the first transmition of the serie
	@param protagistsName, is the name of the protanists
	@param motive, is the motive for censourship 
	@param censourship, is SI or NO
	@param season, is the first season of the serie
	*/
	Serie(String name,String directorName,String synopsis,Date date,String protagistsName, String motive,int indexCensourship,Season season){
		super(name,directorName,synopsis,date);
		this.protagistsName=protagistsName;
		this.motive=motive;
		if(indexCensourship==1){
			this.censourship=Censourship.SI;
		}else if(indexCensourship==2){
			this.censourship=Censourship.NO;
		}
		this.season= new Season [NUMSEASONS];
		this.season[0]=season;
	}
	
	public String getProtagosnitsName(){
		return protagistsName;
	}
	
	public void setProtanistsName(String protagistsName){
		this.protagistsName=protagistsName;
	}
	
	public String getMotive(){
		return motive;
	}
	
	public void setMotive(String motive){
		this.motive=motive;
	}
		
	/**
	*search the last season
	@return index, is the index of the last season
	*/
	
	public int lastSeason(){
		int i;
		int index=0;
		boolean flag=false;
		for(i=0;i<NUMSEASONS&&!flag;i++){
			if(season[i]==null){
				flag=true;
				index=i-1;
			}
		}
		return index;
	}
	
	public String toString(){
		int index=lastSeason();
		return super.toString()+"\n"+
		       "Nombre de protagosnistas: " + protagistsName+"\n"+
			   "Temporadas: "+(index+1)+"\n"+
			   season[index];
	}
	/**
	*add a season
	@param chapters,is the amount of chapters
	@param trailerPath,is the path to the trailer
	@param date, is the date of first transmission of the serie
	*/
	public void addSeason(int chapters,String trailerPath,Date date){
		int i;
		boolean flag=false;
		for(i=1;i<NUMSEASONS&&!flag;i++){
			if(season[i]==null){
				season[i]=new Season (chapters,trailerPath,date);
				flag=true;
			}
		}
	}
}