package ui;
/**
*is the conection with scanner
*/
import java.util.Scanner;
/**
*is the conection with the package model
*/
import model.BlackSnail;
/**
*Is the user interface
*/
public class TvChannel{
	/**
	*sc is the reader object
	*/
	private Scanner sc;
	/**
	*It is the relationship with the model package
	*/
	private BlackSnail channel;
	/**
	*It is the constructor method of the main
	*/
	public TvChannel(){
		sc=new Scanner(System.in);
	}
	
	public static void main(String[] args){
		TvChannel tv=new TvChannel();
		tv.startProgram();
		tv.menu();
	}
	/**
	*Initialize the channel object of the BlackSnail class
	*/
	public void startProgram(){
		String nit;
		System.out.println("**Iniciando programa**");
		System.out.println("Ingresar nit del canal");
		nit=sc.nextLine();
		System.out.println("Ingresar direccion del canal");
		String adress=sc.nextLine();
		System.out.println("Ingresar website del canal");
		String webSite=sc.nextLine();
		System.out.println("Preparacion completa");
		System.out.println("____________________");
		channel= new BlackSnail(nit,adress,webSite);
	}
	/**
	*It's the options menu.
	*/
	public void menu(){
		int option;
		boolean flag=false;
		
		do{
			System.out.println("Seleccione una opcion");
			System.out.println("1.Crear nuevo suscriptor");
			System.out.println("2.Desactivar  un suscriptor");
			System.out.println("3.Desplegar la cantidad de suscriptores activos por cada tipo de cliente");
			System.out.println("4.Desplegar el nombre del suscriptor menor de edad que tenga el mayor número de horas dispuesto a consumir");
			System.out.println("5.Agregar productos");
			System.out.println("6.Buscar producto");
			System.out.println("7.Anadir temporada");
			System.out.println("8.Buscar peliculas por categoria");
			System.out.println("9.Buscar series");
			System.out.println("0.Finalizar");
			option=sc.nextInt();
			sc.nextLine();
			switch(option) {
				
			case 0:
				flag=true;
				break;
			case 1:
				addSubscriber();
				break;
			case 2:
				deactivateSubscriber();
				break;
			case 3:
				suscribersList();
				break;
		
			case 4:
				youngestSubscriber();
				break;
			case 5:
				do{
					System.out.println("Desea agregar");
					System.out.println("1. Pelicula");
					System.out.println("2. Serie");
					option=sc.nextInt();
					sc.nextLine();
					if(option==1){
						addMovie();
					}else if(option==2){
						addSerie();
					}	
				}while(option!=1&&option!=2);
				
				
				break;
			case 6:
				int index=search();
				printSearh(index);
				break;
			case 7:
				addSeason();
				break;
			case 8:
				printMoviesByCategory();
				break;
			case 9:
				printSeries();
				break;
			default:
				System.out.println("Error, opcion no válida");
				
			
			}
		}while(!flag);
		
	}
	/**
	*Add a suscriptor
	*/
	public void addSubscriber(){
		int id;
		String name;
		int age;
		int hours;
		int indexState;
		int indexType;
		if(channel.hasSpace()!=-1){
			System.out.println("Ingresar cedula");
			id=sc.nextInt();
			sc.nextLine();
			if(channel.verifyId(id)){
				System.out.println("Ingresar nombre");
				name=sc.nextLine();
				System.out.println("Ingresar edad");
				age=sc.nextInt();
				sc.nextLine();
				System.out.println("Ingresar horas");
				hours=sc.nextInt();
				sc.nextLine();
				do{
					System.out.println("seleccionar estado");
					System.out.println("1. Desactivado ");
					System.out.println("2. ACTIVO");
					indexState=sc.nextInt();
					sc.nextLine();	
				}while(indexState<1||indexState>2);
				
				do{
					System.out.println("Seleccionar tipo");
					System.out.println("1. NORMAL");
					System.out.println("2. PLATINO");
					System.out.println("3. ORO");
					System.out.println("4. DIAMANTE");
					indexType=sc.nextInt();
					sc.nextLine();
				}while(indexType<1||indexType>4);
				channel.addSubscriber(id,name,age,hours,indexState,indexType);
				System.out.println("Se ha registrado exitosamente el usuario");
			}else System.out.println("Ya hay un usuario con la cedula registrada");
			
			
		}else System.out.println("No hay espacio disponible para añadir suscriptores");
	}
	/**
	*Change the status of a subscriber to "INACTIVO"
	*/
	public void deactivateSubscriber(){
		int index;
		System.out.println("Seleccione el usuario a desactivar");
		System.out.println(channel.showSubscribers());
		index=sc.nextInt();
		sc.nextLine();
		channel.deactivateSubscriber(index-1);
	}
	/**
	*Print the number of active subscribers and the number of each category
	*/
	public void suscribersList(){
		int [] list=channel.amountSubscribers();
		System.out.println("La cantidad de suscriptores activos son: " +list[0] +", distribuidos de la siguiente manera:");
		System.out.println(" NORMAL "+list[1]);
		System.out.println(" PLATINO "+list[2]);
		System.out.println(" ORO "+list[3]);
		System.out.println(" DIAMANTE "+list[4]);
	}
	/**
	*Print the name of the underage subscriber with the most hours willing to consume.
	*/
	public void youngestSubscriber(){
		System.out.println("El suscriptor menor de edad dispuesto a consumir por mas horas es "+channel.youngestSubscriber());
	}
	/**
	*add a serie
	*/
	public void addSerie(){
		String name;
		String directorName;
		String synopsis;
		String protanistsNames;
		String motive="";
		String trailerPath;
		int day;
		int month;
		int year;
		int indexCensourchip;
		int chapters;
		int dayS;
		int monthS;;
		int yearS;
		int index=channel.hasSpaceProduct();
		System.out.println("Ingresar nombre de la pelicula");
		name=sc.nextLine();
		if(index!=-1){
		if(!channel.verifyName(name)){
			System.out.println("Ingresar nombre del director");
			directorName=sc.nextLine();
			System.out.println("Ingresar sinopsis");
			synopsis=sc.nextLine();
			System.out.println("Estreno de la serie");
			System.out.println("Dia");
			day=sc.nextInt();
			sc.nextLine();
			System.out.println("Mes");
			month=sc.nextInt();
			sc.nextLine();
			System.out.println("Año");
			year=sc.nextInt();
			sc.nextLine();
			System.out.println("Nombre de los protagonistas");
			protanistsNames=sc.nextLine();
			do{
				System.out.println("Ha sido censurada");
				System.out.println("1. Si");
				System.out.println("2. No");
				indexCensourchip=sc.nextInt();
				sc.nextLine();	
			}while(indexCensourchip!=1&&indexCensourchip!=2);
			if(indexCensourchip==1){
				System.out.println("Motivo");
				motive=sc.nextLine();
			}
			System.out.println("Ingresar informacion de temporada");
			System.out.println("Trailer");
			trailerPath=sc.nextLine();
			System.out.println("Numero de capitulos");
			chapters=sc.nextInt();
			sc.nextLine();
			System.out.println("Fecha de estreno de la temporada");
			System.out.println("Dia");
			dayS=sc.nextInt();
			sc.nextLine();
			System.out.println("Mes");
			monthS=sc.nextInt();
			sc.nextLine();
			System.out.println("Año");
			yearS=sc.nextInt();
			sc.nextLine();
			channel.addSerie(index,name,directorName,synopsis,day,month,year,protanistsNames,motive,indexCensourchip,chapters,trailerPath,dayS,monthS,yearS);
			//channel.addSerie("Friends","Gary Halvorson","Sigue las vivencias de seis amigos veinteañeros que residen en Manhattan, Nueva York, y se encuentran habitualmente en la cafetería Central Perk",22,9,1994,"Jennifer Aniston,Courteney Cox,Matthew Perry,Matt LeBlanc,Lisa Kudrow,David Schwimmer","",2,24,"www.youtube.com/watch?v=mUPIZLUe83c",18,5,1995);	
			}
		}
	}
	/**
	*add a movie
	*/
	public void addMovie(){
		String name;
		String directorName;
		String synopsis;
		String producer;
		String trailerPath;
		int index=channel.hasSpaceProduct();
		int day;
		int month;
		int year;
		int minimumAge;
		int indexCategory;
		if(index!=-1){
			System.out.println("Ingresar nombre de la pelicula");
			name=sc.nextLine();
			if(!channel.verifyName(name)){
				System.out.println("Ingresar nombre del director");
				directorName=sc.nextLine();
				System.out.println("Ingresar sinopsis");
				synopsis=sc.nextLine();
				System.out.println("Estreno de la pelicula");
				System.out.println("Dia");
				day=sc.nextInt();
				sc.nextLine();
				System.out.println("Mes");
				month=sc.nextInt();
				sc.nextLine();
				System.out.println("Año");
				year=sc.nextInt();
				sc.nextLine();
				System.out.println("Productora");
				producer=sc.nextLine();
				System.out.println("Edad minima");
				minimumAge=sc.nextInt();
				sc.nextLine();
				System.out.println("Trailer");
				trailerPath=sc.nextLine();
				do{
					System.out.println("Categoria");
					System.out.println("1. Romantica");
					System.out.println("2. Accion");
					System.out.println("3. Suspenso");
					System.out.println("5. Terror");
					System.out.println("4. Comedia");
					indexCategory=sc.nextInt();
					sc.nextLine();	
				}while(indexCategory!=1&&indexCategory!=2&&indexCategory!=3&&indexCategory!=4);
				//channel.addMovie("Titanic","James Cameron","Jack es un joven artista que gana un pasaje para viajar a América en el Titanic, el transatlántico más grande y seguro jamás construido. A bordo del buque conoce a Rose, una chica de clase alta que viaja con su madre y su prometido Cal, un millonario engreído a quien solo interesa el prestigio de la familia de su prometida. Jack y Rose se enamoran a pesar de las trabas que ponen la madre de ella y Cal en su relación. Mientras, el lujoso transatlántico se acerca a un inmenso iceberg.",13,2,1997,"Paramount Pictures",5,"www.youtube.com/watch?v=FiRVcExwBVA",1);
				//channel.addMovie("Harry Potter y la piedra filosofal","Chris Columbus","El día de su cumpleaños, Harry Potter descubre que es hijo de dos conocidos hechiceros, de los que ha heredado poderes mágicos. Debe asistir a una famosa escuela de magia y hechicería, donde entabla una amistad con dos jóvenes que se convertirán en sus compañeros de aventura. Durante su primer año en Hogwarts, descubre que un malévolo y poderoso mago llamado Voldemort está en busca de una piedra filosofal que alarga la vida de quien la posee.",30,11,2001,"	Heyday Films",2,"www.youtube.com/watch?v=WE4AJuIvG1Y",2);
				channel.addMovie(index,name,directorName,synopsis,day,month,year,producer,minimumAge,trailerPath,indexCategory);	
			}	
		}
	}
		
	/**
	*search a product with a name
	@return index is the resul of the search
	*/
	public int search(){
		String name;
		System.out.println("Ingresar nombre del producto");
		name = sc.nextLine();
		int index=channel.search(name);
		
		return index;
	}
	/**
	*Print the searched product
	@param index is the index of the product to print
	*/
	public void printSearh(int index){
		if(index!=-1){
			System.out.println(channel.getProduct(index));
		}else System.out.println("No existe el producto");
	}
	/**
	*add a season
	*/
	public void addSeason(){
		String trailerPath;
		String mesage="No se ha encontrado una serie con este nombre";
		int chapters;
		int dayS;
		int monthS;;
		int yearS;
		int index=search();
		if(index!=-1){
			if(channel.verifySerie(index)){
				System.out.println("Trailer");
				trailerPath=sc.nextLine();
				System.out.println("Numero de capitulos");
				chapters=sc.nextInt();
				sc.nextLine();
				System.out.println("Fecha de estreno de la temporada");
				System.out.println("Dia");
				dayS=sc.nextInt();
				sc.nextLine();
				System.out.println("Mes");
				monthS=sc.nextInt();
				sc.nextLine();
				System.out.println("Año");
				yearS=sc.nextInt();
				sc.nextLine();
				channel.addSeason(index,chapters,trailerPath,dayS,monthS,yearS);	
			}else System.out.println(mesage);
				
		}else System.out.println(mesage);
		
	}
	/**
	*print the information of all series
	*/
	public void printSeries(){
		int i;
		int iteration=0;
		for(i=0;i<channel.PSIZE;i++){
			if(channel.verifySerie(i)){
				System.out.println(channel.getProduct(i));
				iteration++;
			}
		}
		if(iteration==0){
			System.out.println("No se han encontrado series");
		}
	}
	/**
	*print the movies of a category
	*/
	public void printMoviesByCategory(){
		int indexCategory;
		int i;
		int iteration=0;
		do{
			System.out.println("Selecionar categoria");
			System.out.println("1. Romantica");
			System.out.println("2. Accion");
			System.out.println("3. Suspenso");
			System.out.println("5. Terror");
			System.out.println("4. Comedia");
			indexCategory=sc.nextInt();
			sc.nextLine();	
		}while(indexCategory!=1&&indexCategory!=2&&indexCategory!=3&&indexCategory!=4);
		
		for(i=0;i<channel.PSIZE;i++){
			if(channel.getProduct(i)!=null){
				if(channel.verifyMovie(i)){
					iteration++;
					System.out.println("**--Pelicula--**");
					System.out.println(channel.getProduct(i));
				}	
			}
		}
		if(iteration==0){
			System.out.println("No se han encontrado peliculas");
		}
	}
	
	
}