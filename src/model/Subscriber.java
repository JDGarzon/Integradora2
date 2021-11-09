package model;

public class Subscriber{
	/**
	* id, es la identificacion del suscriptor
	*/
	private int id;
	/**
	* name, es el nombre del suscriptor
	*/
	private String name;
	/**
	* age, es la edad del suscriptor
	*/
	private int age;
	/**
	* hours, es la cantidad de horas que el suscriptor esta dispuesto a consumir
	*/
	private int hours;
	/**
	* state,es el estado del suscriptor: ACTIVO o INACTIVO
	*/
	private State state;
	/**
	* type, is the type of subscriber: NORMAL,PLATINO;ORO,DIAMANTE
	*/
	private Type type;
	/**
	*Subscriber class constructor method
	@param id, is the subscriber's identification
	@param name, is the name of the subscriber
	@param age, is the subscriber's age
	@param hours, is the number of hours the subscriber is willing to consume at
	@param indexState, is the number that represents the status of the subscriber between 1 and 2
	@param indexType, is the number that represents the type of subscriber between 1 and 4
	*/
	public Subscriber(int id,String name,int age,int hours,int indexState,int indexType){
		this.id=id;
		this.name=name;
		this.age=age;
		this.hours=hours;
		switch(indexState) {
		case 1:
			state=State.INACTIVO;
			break;
		case 2:
			state=State.ACTIVO;
			break;
		}
		switch(indexType) {
		case 1:
			type=Type.NORMAL;
			break;
		case 2:
			type=Type.PLATINO;
			break;
		case 3:
			type=Type.ORO;
			break;
		case 4:
			type=Type.DIAMANTE;
			break;
		}
	}
	/*
	 * ================================= Getters & Setters
	 */
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public int getAge(){
		return age;
	}
	
	public void setAge(int age){
		this.age=age;
	}
	
	public int getHours(){
		return hours;
	}
	
	public void setHours(int hours){
		this.hours=hours;
	}
	
	public State getState(){
		return state;
	}
	
	public void setState(int indexState){
		switch(indexState) {
		case 1:
			state=State.INACTIVO;
			break;
		case 2:
			state=State.ACTIVO;
			break;
		}
	}
	
	public Type getType(){
		return type;
	}
	
	public void setType(int indexType){
		switch(indexType) {
		case 1:
			type=Type.NORMAL;
			break;
		case 2:
			type=Type.PLATINO;
			break;
		case 3:
			type=Type.ORO;
			break;
		case 4:
			type=Type.DIAMANTE;
			break;
		}
	}
}