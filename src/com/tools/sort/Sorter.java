package com.tools.sort;

public abstract class Sorter<E> {
	
	protected MyComparator<E> comparator;

	public Sorter(MyComparator<E> comparator) {
		if (comparator == null)
			throw new RuntimeException("Comparator cannot be null!");
		
		this.comparator = comparator;

	}

	abstract public void sort(E[] array);

	protected void swap(E[]array , int i , int j) {
		E tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
