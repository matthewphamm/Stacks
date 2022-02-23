public class A4Exercises {
	
	/*
	 * Purpose: determine if the stack of plates has been
	 *          stacked correctly (ie. there is never a plate
	 *          on top of a smaller plate)
	 * Parameters: Stack<Plate> s - a stack of plates
	 * Returns: boolean - true if the plates are stacked correctly
	 *                    false otherwise
	 * Post-condition: the contents of s are not modified
	 */
	public static boolean stackedCorrectly(Stack<Plate> s) {
		Stack<Plate> temp = new A4Stack<Plate>();
		boolean result = true;

		if (s.isEmpty()) {
			return result;
		} else {
			Plate val1 = s.pop(); 
			int d1 = val1.getDiameter();
			temp.push(val1);
			while (s.top() != null) {
				Plate val2 = s.pop();
				int d2 = val2.getDiameter();
				if (d1 > d2) {
					result = false;
				}
				d1 = d2;
				temp.push(val2);
			}
			while (temp.top() != null) {
				Plate v = temp.pop();
				s.push(v);
			}
		}
		return result; 
	}
	
	/*
	 * Purpose: insert p into the correct location in the
	 *          stack such that there are no smaller plates 
	 *          below p and no larger plates above p
	 * Parameters: Stack<Plate> s - a stack of plates
	 *             Plate p - the plate to insert into s
	 * Returns: void - nothing
	 * Pre-condition: plates in s have been stacked correctly
	 */
	public static void insertPlate(Stack<Plate> s, Plate p) {
		Stack<Plate> temp = new A4Stack<Plate>();

		if (s.isEmpty()) {
			s.push(p);
		} else {
			Plate val1 = s.pop(); 
			int d1 = val1.getDiameter();
			int d6 = p.getDiameter();

			if (d6 < d1) {
				temp.push(p);
			}
			temp.push(val1);

			while (s.top() != null) {
				Plate val2 = s.pop();
				int d2 = val2.getDiameter();
				int d3 = p.getDiameter();
				if (d1 < d3 && d3 < d2) {
					temp.push(p);
					temp.push(val2);
				} else if (d3 == d1) {
					temp.push(p);
					temp.push(val2);
				} else {
					temp.push(val2);
				}
				d1 = d2;
			}
			int d5 = p.getDiameter();

			if (d1 <= d5) {
				temp.push(p);
			}

			while (temp.top() != null) {
				Plate v = temp.pop();
				s.push(v);
			}			
		}
	}
}