package com.Magazine.Controller;

/**
 * @author jinpeng
 * a subject interface to achieve observer pattern
 */
public interface MagazineObserverable {
	/**
	 * @param o MagazineObserver used to subscribe
	 */
	public void registerObserver(MagazineObserver o);
	public void notifyObserver();
}
