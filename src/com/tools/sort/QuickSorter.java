package com.tools.sort;

public class QuickSorter<E> extends Sorter<E> {

	public QuickSorter(MyComparator<E> comparator) {
		super(comparator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort(E[] array) {
		// TODO Auto-generated method stub
		sort(array, 0, array.length - 1);
	}

	private void sort(E[] array, int from, int to) {
		// TODO Auto-generated method stub
		if (from >= to)
			return;
		int pivot = partition(array, from, to);
		sort(array, from, pivot);
		sort(array, pivot+1, to);

	}

	private int partition(E[] array,int from, int to) {
		// TODO Auto-generated method stub
		E pivotVal = array[from];
		int i = from - 1;
		int j = to + 1;
		while (i < j) {
			i++;
			while (super.comparator.Compare(array[i], pivotVal))
				i++;

			j--;
			while (super.comparator.Compare(pivotVal, array[j]))
				j--;
			if (i < j) {
				super.swap(array, i, j);
				
			}
		}
		return j;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] x = new Integer[] { 1, -1 ,2,3,-8,-11};
		Sorter<Integer> s = new QuickSorter<>(new MyComparator<Integer>() {

			@Override
			public boolean Compare(Integer e1, Integer e2) {
				// TODO Auto-generated method stub
				return e1 < e2;
			}
		});
		s.sort(x);
	}

}
