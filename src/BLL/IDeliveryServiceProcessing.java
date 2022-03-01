package BLL;

import java.util.ArrayList;
/**
 * @Author: Ardelean Adriana
 * @Date: 24.05.2021
 */
public interface IDeliveryServiceProcessing {

	/**
	 * @pre a!=null
	 * @param a
	 */
	public void addUser(Account a);
	/**
	 * @pre a!=null
	 * @param a
	 */
	public void addProduct(MenuItem a) ;
	/**
	 * @pre title!=null
	 * @param title
	 * @param rating
	 * @param calories
	 * @param protein
	 * @param fat
	 * @param sodium
	 * @param price
	 */
	public void editMenuItem(String title, float rating, int calories, int protein, int fat, int sodium, float price);
	/**
	 * @pre title!=null
	 * @param title
	 */
	public MenuItem searchByName(String title) ;
	/**
	 * @pre str!=null
	 * @param str
	 */
	public void deleteMenuItem(String str) ;
	/**
	 * @pre n!=null
	 * @param m
	 * @param n
	 */
	public void addInComposit(MenuItem m, MenuItem n);
	/**
	 * @post meniu!=null
	 */
	public void importBaseProducts();
	/**
	 * @pre ord!=null
	 * @param ord
	 * @param items
	 */
	public void AddOrder(Order ord, ArrayList<MenuItem> items);
	/**
	 * @pre startHour<25
	 * @pre endHour<25
	 * @param startHour
	 * @param endHour
	 */
	public void report1(int startHour, int endHour);
	/**
	 * @pre nrTimes > 0 
	 * @param nrTimes
	 */
	public void report2(int nrTimes) ;
	/**
	 * @pre nrTimes>0
	 * @pre amount>0
	 * @param nrTimes
	 * @param amount
	 */
	public void report3(int nrTimes, Double amount);
	/**
	 * @pre date<32
	 * @param date
	 */
	public void report4(int date);
}
