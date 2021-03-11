import java.util.Arrays;

public class List<E> {

	private int size = 0; // Size of list

	private static final int DEFAULT_CAPACITY = 20; // Default capacity of list is 20

	private Object elements[]; // This array will store all elements added to list

	public List() { // Default constructor
		elements = new Object[DEFAULT_CAPACITY];
	}

	public void add(E e) { // Add method
		if (size == elements.length) {
			ensureCapacity();
		}
		elements[size++] = e;
	}

	public E get(int key) { // Get method

		for (int j = 0; j < size; j++) {
			if ((int) elements[j] == key)
				System.out.println("Student found in List!");
		}
		return null;
	}

	public E remove(int key) { // Remove method
		for (int i = 0; i < size; i++) {
			if ((int) elements[i] == key) {
				int numElts = elements.length - (i + 1);
				System.arraycopy(elements, i + 1, elements, i, numElts);
				size--;
			}
		}
		return null;
	}
	public E print() { // Get method

		for (int j = 0; j < size; j++) {
			
				System.out.println(elements[j]);
		}
		return null;
	}

	public int size() { // Get Size of list
		return size;
	}

	private void ensureCapacity() {
		int newSize = elements.length * 2;
		elements = Arrays.copyOf(elements, newSize);
	}
}