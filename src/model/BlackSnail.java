package model;

public class BlackSnail{
	/**
	*IS the canal's "Número of identificación tributaría"
	*/
	private String nit;
	/**
	*Is the direction
	*/
	private String direction;
	/**
	*webSite is the website's direction 
	*/
	private String webSite;
	/**
	*list is the suscriptors list
	*/
	private Subscriber [] list;
	/**
	*productList is the products list
	*/
	private Product [] productList;
	/**
	*PSIZE is the amount of possibles products
	*/
	public static final int PSIZE=85;
	/**
	*SSIZE is the amount of possibles suscriptors
	*/
	public static final int SSIZE=50;
	/**
	*Constructor method of the class
	@param nit, is an integer that represents the channel's tax identification number
	@param direction, It is the direction of the channel
	@param webSite, is the website address in a text string
	*/
	public BlackSnail(String nit, String direction, String webSite){
		this.nit=nit;
		this.direction=direction;
		this.webSite=webSite;
		list = new Subscriber [SSIZE];
		productList=new Product [PSIZE];
	}
	/*
	 * ================================= Getters & Setters
	 */
	public String getNit(){
		return nit;
	}
	
	public void setNit(String nit){
		this.nit=nit;
	}
	
	public String getDirection(){
		return direction;
	}
	
	public void setDirection (String direction){
		this.direction=direction;
	}
	
	public String getWebSite(){
		return webSite;
	}
	
	public void setWebSite(String webSite){
		this.webSite=webSite;
	}
	
	public Subscriber getSubscriber(int index){
		return list[index];
	}
	
	public Product getProduct(int index){
		return productList[index];
	}
	
	public void setSubscriber(int index,Subscriber newSubscriber){
		list[index]=newSubscriber;
	}
	/**
	*It is the method that finds an available space
	@return index, is the index of the space found
	*/
	public int hasSpace(){
		int index=-1;
		int i;
		boolean flag=false;
		for(i=0;i<list.length&&!flag;i++){
			if(list[i]==null){
				flag=true;
				index=i;
			}
		}
		return index;
	}
	/**
	*Verify if the entered identification corresponds to a previously entered identification
	@param newId is the id to verify if exist
	@return out, is the result of checking if the identification has been previously entered. true if it does not exist and false otherwise
	*/
	public boolean verifyId(int newId){
		int i;
		boolean flag=false;
		boolean out=true;
		for(i=0;(i<list.length)&&!flag;i++){
			if(list[i]!=null){
				if(list[i].getId()==newId){
					flag=true;
					out=false;
				}	
			}
		}
		return out;
	}
	/**
	* Add a subscriber with the information entered.
	@param id, is the identification of the subscriber to register
	@param name, is the name of the subscriber to register
	@param age, is the age of the subscriber to register
	@param hours, is the number of hours the subscriber to register will consume
	@param indexState, is the number that represents the state of the subscriber to register between 1 and 2
	@param indexType, is the number that represents the type of subscriber to register between 1 and 4
	*/
	public void addSubscriber(int id,String name,int age,int hours,int indexState,int indexType){
		int index=hasSpace();
		list[index]=new Subscriber(id, name,age, hours, indexState,indexType);
	}

	/**
	* Find the number of active subscribers and then find the number of each type
	@return amountList, it is an arrangement with the information of the number of subscribers in space 0 and that of the types in the following numbers
	*/ 
	public int [] amountSubscribers(){
		int [] amountList=new int[5];
		int amount=0;
		int normal=0;
		int platine=0;
		int gold=0;
		int daimond=0;
		int i;
		for(i=0;i<list.length;i++){
			if(list[i]!=null){
				if(list[i].getState().equals(State.ACTIVO)){
					amount++;
					if(list[i].getType().equals(Type.NORMAL)){
						normal++;
					}
					if(list[i].getType().equals(Type.PLATINO)){
						platine++;
					}
					if(list[i].getType().equals(Type.ORO)){
						gold++;
					}
					if(list[i].getType().equals(Type.DIAMANTE)){
						daimond++;
					}
				}
			}
		}
		amountList[0]=amount;
		amountList[1]=normal;
		amountList[2]=platine;
		amountList[3]=gold;
		amountList[4]=daimond;
		
		return amountList;
	}
	/**
	*Print the subscriber's list
	*/
	public String showSubscribers(){
		int i;
		String message="";
		for(i=0;i<list.length;i++){
			if(list[i]!=null){
				message+=(i+1)+". "+(list[i].getName())+"\n";
			}
		}
		return message;
	}
	/**
	*Change the state of the suscriptors to "INACTIVO"
	@param i, is the index of the subscriber
	*/
	public void deactivateSubscriber(int i){
		if(list[i]!=null){
			list[i].setState(1);
			list[i].setType(1);	
			System.out.println("Se ha desactivado el usuario exitosamente");
		}else System.out.println("Ha seleccionado un indice incorrecto");
		
	}
	/**
	*Retorna el nombre del subscriber menor de edad con más horas dispuesto a consumir 
	@return name, is the name of a subscriber of minor age with the most hours to spend
	*/
	public String youngestSubscriber(){
		String name="";
		int age=0;
		int hours=0;
		int i;
		int index=-1;
		for(i=0;i<list.length;i++){
			if(list[i]!=null){
				if(list[i].getAge()<18){
					if(list[i].getHours()>hours){
						index=i;
					}
				}
			}	
		}
		if(index==-1){
			name="- ningun miembro registrado es menor de edad";
		}else name=list[index].getName();
		
		return name;
	}
	/**
	*It is the method that finds an available space
	@return index, is the index of the space found
	*/
	public int hasSpaceProduct(){
		int index=-1;
		int i;
		boolean flag=false;
		for(i=0;i<list.length&&!flag;i++){
			if(productList[i]==null){
				flag=true;
				index=i;
			}
		}
		return index;
	}
	/**
	*add a serie
	@param index is the index of the serie in the array
	@param name, is the name of the serie
	@param directorName, is the name of the director
	@param synopsis, is th synopsis of the serie
	@param day, is the day of the series date
	@param month, is the month of the series date
	@param year, is the year of the series date
	@param protagistsName, is the name of the protanists
	@param motive, is the motive for censourship 
	@param indexCensourchip, is the index to choose a censourchip
	@param chapters,is the amount of chapters
	@param trailerPath,is the path to the trailer
	@param dayS, is the day of the seasons date
	@param monthS, is the month of the seasons date
	@param yearS, is the year of the seasons date
	*/
	public void addSerie(int index,String name,String directorName,String synopsis,int day,int month,int year,String protagistsName,
						String motive,int indexCensourchip,int chapters,String trailerPath,int dayS,int monthS,int yearS){
		boolean flag=false;
		Date date=new Date(day,month,year);
		Date dateS=new Date(dayS,monthS,yearS);
		Censourship censourchip;
		Season season=new Season(chapters,trailerPath,dateS);
		productList[index]=new Serie(name,directorName,synopsis,date,protagistsName,motive,indexCensourchip,season);
		System.out.println("Se ha creado el producto");
	
	}
	/**
	*add a movie
	@param index  is the index of the movie in the array
	@param name, is the name of the movie
	@param directorName, is the name of the director
	@param synopsis, is th synopsis of the movie
	@param day, is the day of the movies date
	@param month, is the month of the movies date
	@param year, is the year of the movies date
	@param producer, is the name of the producer
	@param minimunAge, is the minimun age to see the movie
	@param trailerPath, is the path to the trailer
	@param indexCategory, is the index to choose the category 
	*/
	public void addMovie(int index,String name,String directorName,String synopsis,int day,int month,int year,
						String producer,int minimunAge,String trailerPath,int indexCategory){
		boolean flag=false;
		Date date=new Date(day,month,year);
		productList[index]=new Movie(name,directorName,synopsis,date,producer,minimunAge,trailerPath,indexCategory);
		System.out.println("Se ha creado el producto");
	}
	
	/**
	*serach a product with its name
	@param name, is the name to searc 
	@return index,is the index of the serie, -1 if there is not a product with this name
	*/
	public int search(String name){
		int i;
		int index=-1;
		boolean flag=false;
		for(i=0;i<PSIZE-1&&!flag;i++){
			if(productList[i]!=null){
				if(name.equals(productList[i].getName())){
					flag=true;
					index=i;
				}
			}
		}
		return index;
	}
	/**
	*verify if there is a product with the the same name 
	@param name, is the name to verify
	@return out, is the logical value, false if there is not other product with this name and true if there is 
	*/
	public boolean verifyName(String name){
		boolean out=false;
		int i;
		boolean flag=false;
		for(i=0;i<PSIZE-1&&!flag;i++){
			if(productList[i]!=null){
				if(productList[i].getName().equals(name)){
					out=true;
					flag=true;
				}	
			}	
		}
		return out;
	}
	/**
	*add a season
	@param index, is the index of the serie to add a season
	@param chapters,is the amount of chapters
	@param trailerPath,is the path to the trailer
	@param day, is the day of the seasons date
	@param month, is the month of the seasons date
	@param year, is the year of the seasons date
	*/
	public void addSeason(int index,int chapters,String trailerPath,int day,int month,int year){
		Date date=new Date(day,month,year);
		Serie serie=(Serie)productList[index];
		serie.addSeason(chapters,trailerPath,date);
	}
	/**
	*verify if the product is a instance of a serie
	@param index,is the index of the product to verify
	@return true if the expression is true, false otherwise 
	*/
	public boolean verifySerie(int index){
		return productList[index] instanceof Serie;
	}
	/**
	*verify if the product is a instance of a movie
	@param index,is the index of the product to verify
	@return true if the expression is true, false otherwise 
	*/
	public boolean verifyMovie(int index){
		return productList[index] instanceof Movie;
	}
	/**
	*verify if the movie has the same category
	@param index,is the index of the movie
	@param indexCategory, is the index to choose the category
	@return out, true if the cayegory choosed and the movie category is equal, false otherwise
	*/
	public boolean verifyCategory(int index,int indexCategory){
		Movie movie=(Movie)productList[index];
		Category category=Category.ROMANTICA;
		boolean out=false;
		if(indexCategory==1){
			category=Category.ROMANTICA;
		}else if(indexCategory==2){
			category=Category.ACCION;
		}else if(indexCategory==3){
			category=Category.SUSPENSO;
		}else if(indexCategory==4){
			category=Category.TERROR;
		}else if(indexCategory==5){
			category=Category.COMEDIA;
		}
		if(movie.getCategory().equals(category)){
			out=true;
		}
		return out;
	}
}