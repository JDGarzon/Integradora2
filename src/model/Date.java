package model;

public class Date{
	/**
	*day, is the day of the date
	*/
	private int day;
	/**
	*month, is the month of the date
	*/
	private int month;
	/**
	*year, is the year of the date
	*/
	private int year;
	/**
	*Constructor of Date
	@param newDay, is the day of the date
	@param newMonth, is the month of the date
	@param newYear, is the year of the date
	*/
	Date(int newDay,int newMonth, int newYear){
		day = newDay;
		month=newMonth;
		year=newYear;
	}
	public void setDay(int newDay){
		day=newDay;
	}
	public int getDay(){
		return day;
	}
	public void setMonth(int newMonth){
		month=newMonth;
	}
	public int getMonth(){
		return month;
	}
	public void setYear(int newYear){
		year=newYear;
	}
	public int getYear(){
		return year;
	}
	public String toString(){
		return 	day+"/"+month+"/"+year;
	}
}