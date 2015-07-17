package com.tools.sort;

public class Bubble<E> extends Sorter<E> {
	public Bubble(MyComparator<E> comparator) {
		super(comparator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort(E[] array) {
		// TODO Auto-generated method stub
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (!super.comparator.Compare(array[i], array[j])) {
					super.swap(array,i,j);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] x = new Integer[] { 1, -1 };
		Sorter<Integer> s = new Bubble<>(new MyComparator<Integer>() {

			@Override
			public boolean Compare(Integer e1, Integer e2) {
				// TODO Auto-generated method stub
				return e1 < e2;
			}
		});
		s.sort(x);
	}

}
