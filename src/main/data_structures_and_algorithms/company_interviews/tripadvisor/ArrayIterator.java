package data_structures_and_algorithms.company_interviews.tripadvisor;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class ArrayIterator<Integer> implements Iterator<Integer> {
	private Integer[] array;
	private int pos = 0;

	public ArrayIterator(Integer[] anArray) {
		array = anArray;
	}

	public boolean hasNext() {
		return pos < array.length;
	}

	public Integer next() {
		if (hasNext()) {
			while ((int)array[pos] % 2 != 0) {
				pos++;
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
			}
			return array[pos++];
		}else {
		  	throw new NoSuchElementException();
		}
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}