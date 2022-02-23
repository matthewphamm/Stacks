public class A4Stack<T> implements Stack<T> {
	private A4Node<T> head;

	public A4Stack() {
		head = null;
	}

	public void push(T value) {
		A4Node<T> n = new A4Node<T>(value);

		if (isEmpty()) {
			head = n;
		} else {
			n.next = head;
			head = n;
		}
	}

	public T pop() {
		T removeValue = top();
		if (!isEmpty()) {
			head = head.next;
			return removeValue;
		}
		return null; 
	}

	public boolean isEmpty() {
		return head==null;
	}

	public T top() {
		if (!isEmpty()) {
			return head.getData();
		}
		return null; 
	}

	public void popAll() {
		head = null;
	}
	
	public String toString() {
		String result = "{";
		A4Node<T> cur = head;
		while (cur != null) {
			result += cur.getData();
			if (cur.next != null) {
				result += ", ";
			}
			cur = cur.next;
		}
		result += "}";
		return result;
	}
}