public class CircularQueue {
	private Object[] queue = new Object[5];
	private int f = 0, r = 0, N = 5;

	public static void main(String[] args) {
		new CircularQueue();
	}

	public CircularQueue() {
		enqueue(5);
		enqueue(7);
		enqueue(15);
		enqueue(25);
		System.out.println(full());
		System.out.println(dequeue());
		System.out.println(empty());
		enqueue(50);
		System.out.println(dequeue());
		enqueue(65);
	}

	public boolean full() {
		if ((r - f == -1) || ((r - f) == (N - 1)))
			return true;
		else
			return false;
	}

	public boolean empty() {
		if (r == f)
			return true;
		else
			return false;
	}

	public int size() {
		if (r > f)
			return r - f;
		else
			return N - f + r;
	}

	public void enqueue(int val) {
		if (full())
			System.out.println("Value could not be added. Queue is full.");
		else {
			queue[r] = val;
			System.out.println("At position "+r);
			r = (r + 1) % N;
		}
	}
	
	public Object dequeue(){
		if(empty()){
			System.out.println("Queue is empty.");
			return null;
		}
		else{
			Object val = queue[f];
			queue[f] = null;
			f = (f + 1) % N;
			return val;
		}
	}

}
