import java.util.ArrayList;

public class NotationQueue<T> implements QueueInterface<T>{
	private int queueSize, back, front, count;
	private int defaultSize = 5;
	ArrayList<T> queue;
	
	NotationQueue(int queueSize){
		this.queueSize = queueSize;
		this.count = 0;
		this.front = 0;
		this.back = -1;
		queue = new ArrayList<T>(queueSize);
	}
	NotationQueue(){
		this.queueSize = defaultSize;
		this.count = 0;
		this.front = 0;
		this.back = -1;
		queue = new ArrayList<T>(queueSize);
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public boolean isFull() {
		if(queue.size() == queueSize) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (count == 0) {
			throw new QueueUnderflowException();
		} else {
			T value = queue.get(front);
			queue.remove(front);
			count--;
			return value;
		}
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if(count == queueSize) {
			throw new QueueOverflowException();
		}
		else {
			back += 1;
			queue.add(back, e);
			count++;
			return true;
		}
	}
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < count; i++) {
			str += queue.get(i);
		}
		return str;
	}
	
	@Override
	public String toString(String delimiter) {
		String str = "";
		for (int i = 0; i < count - 1; i++) {
			str += queue.get(i) + delimiter;
		}
		str += queue.get(back);
		return str;
	}

	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> copylist = new ArrayList<T>(list);
		for (int i = 0; i < copylist.size(); i++) {
			try {
				enqueue(copylist.get(i));
			} catch (QueueOverflowException e) {
				e.printStackTrace();
			}
		}
	}

}
