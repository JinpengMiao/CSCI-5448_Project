package com.Magazine.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jinpeng
 * a concrete class implements MagazineObserverable to achieve observer pattern
 */
public class MagazineServer implements MagazineObserverable{
	private ArrayList<MagazineObserver> list = new ArrayList<MagazineObserver>();
	private String magazineName;
	private String magazineDate;
	
	/* (non-Javadoc)
	 * @see com.Magazine.Controller.MagazineObserverable#registerObserver(com.Magazine.Controller.MagazineObserver): add the subscribed observer to arraylist
	 */
	public void registerObserver(MagazineObserver o) {       
        list.add(o);
    }
	
	/* (non-Javadoc)
	 * @see com.Magazine.Controller.MagazineObserverable#notifyObserver(): notify observers
	 */
	@Override
	public void notifyObserver() {
		for(int i = 0; i < list.size(); i++) {
            MagazineObserver oserver = list.get(i);
            oserver.update(magazineName, magazineDate);
        }	
	}
	/**
	 * @param name String value new magazine name
	 * @param date String value new magazine date
	 */
	public void setInfomation(String name, String date) {
        this.magazineName = name;
        this.magazineDate = date;
        System.out.println("New magazine name： " + name + "       Release date： " + date);
        notifyObserver();
	}
}
