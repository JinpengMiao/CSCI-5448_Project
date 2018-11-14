package com.Magazine.Controller;

public interface MagazineObserverable {
	public void registerObserver(MagazineObserver o);
	public void notifyObserver();
}
