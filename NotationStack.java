import java.util.ArrayList;

public class NotationStack<T> implements StackInterface<T> {

	private int stackSize, index;
	private int DEFAULT_SIZE = 5;
	private ArrayList<T> stack;

	NotationStack() {
		index = -1;
		stackSize = DEFAULT_SIZE;
		stack = new ArrayList<T>(DEFAULT_SIZE);
	}

	NotationStack(int stackSize) {
		index = -1;
		this.stackSize = stackSize;
		stack = new ArrayList<T>(stackSize);
	}

	public boolean isEmpty() {
		return (stack.isEmpty());
	}

	@Override
	public boolean isFull() {
		return (index == stackSize - 1);
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (index == -1) {
			throw new StackUnderflowException();
		} else {
			T value = stack.get(index);
			stack.remove(index);
			index--;
			return value;
		}
	}

	@Override
	public T top() throws StackUnderflowException {
		if (index == -1) {
			throw new StackUnderflowException();
		} else {
			T value = stack.get(index);
			return value;
		}
	}

	@Override
	public int size() {
		return index + 1;
	}

	@Override
	public boolean push(T e) throws StackOverflowException {
		if (index == stackSize - 1) {
			throw new StackOverflowException();
		} else {
			index++;
			stack.add(index, e);
			return true;
		}
	}

	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < index + 1; i++) {
			str += stack.get(i);
		}
		return str;
	}

	@Override
	public String toString(String delimiter) {
		String str = "";
		for (int i = 0; i < index; i++) {
			str += stack.get(i) + delimiter;
		}
		str += stack.get(index);
		return str;
	}

	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> copylist = new ArrayList<T>(list);
		for (int i = 0; i < copylist.size(); i++) {
			try {
				push(copylist.get(i));
			} catch (StackOverflowException e) {
				e.printStackTrace();
			}
		}
	}

}
