package com.tools.sort;

public interface MyComparator<E> {
	/*
	 * if true then e1 better (and not equal) than e1 so it has the higher priority to be inserted in an array
	 * */
public boolean Compare (E e1,E e2);
}
