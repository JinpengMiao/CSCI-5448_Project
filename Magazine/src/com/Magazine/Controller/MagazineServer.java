package com.Magazine.Controller;

import java.util.ArrayList;
import java.util.List;

public class MagazineServer implements MagazineObserverable{
	private ArrayList<MagazineObserver> list = new ArrayList<MagazineObserver>();
	private String magazineName;
	private String magazineDate;
	
	public void registerObserver(MagazineObserver o) {       
        list.add(o);
    }
	
	@Override
	public void notifyObserver() {
		for(int i = 0; i < list.size(); i++) {
            MagazineObserver oserver = list.get(i);
            oserver.update(magazineName, magazineDate);
        }	
	}
	public void setInfomation(String name, String date) {
        this.magazineName = name;
        this.magazineDate = date;
        System.out.println("New magazine name： " + name + "       Release date： " + date);
        notifyObserver();
	}
}
