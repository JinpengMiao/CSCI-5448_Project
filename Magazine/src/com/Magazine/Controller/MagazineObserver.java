package com.Magazine.Controller;

/**
 * @author jinpeng
 * a interface used to be implemented by concrete observer
 */
public interface MagazineObserver {
	public void update(String magazineName, String magazineDate); 
}
