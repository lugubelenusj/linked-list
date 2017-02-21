public class LinkedList {

	private ListNode head;
	private ListNode tail;

	LinkedList() {
		head = new ListNode(null);
		tail = head;
	}

	/**
 	* Add an element to the end of the list
 	* @param o The object to add to the end of the list
 	*/
    public void add(Object o) {
    	tail.setNext(new ListNode(o));
    	tail = tail.next();
    }

    /**
     * Remove the first occurrence of elemToRemove from the list.  If elemToRemove does not
     * appear in the list, then do nothing.
     * @param elemToRemove The element to remove from the list
     */
    public void removeFirst(Object elemToRemove) {
		// Start the current pointer at the head.
		ListNode current = head;

		// Continue until the pointer is about to reach the end.
		while (current.next() != null) {
			if (current.next().data().equals(elemToRemove)) {

				// As soon as an elemToRemove is found, remove it and break out.
				if (current.next().next() == null) {
					current.setNext(null);
					tail = current;
					break;
				}
				else {
					current.setNext(current.next().next());
					break;
				}
			}

			current = current.next();
		}
    }

    /**
     * Remove all occurrences of an element from a list.
     * @param elemToRemove The element to remove from the list
     */
    public void removeAll(Object elemToRemove) {
			// Start the current pointer at the head.
			ListNode current = head;
			while (current.next() != null) {

				if (current.next().data().equals(elemToRemove)) {

					// If elemToRemove is the last element, then just point this node's next to null.
					if (current.next().next() == null) {
						current.setNext(null);
						tail = current;
						break;
					}

					// Else set its next to the node after the next one and repeat to check that this new next is not also an elemToRemove.
					else {
						current.setNext(current.next().next());
					}
				}

				// If the next node is not the elemToRemove then move onto it.
				else {
					current = current.next();
				}
			}
    }

    /**
     * Remove the last occurrence of an element from a list.
     * @param elemToRemove The element to remove from the list
     */
    public void removeLast(Object elemToRemove) {
		// Start the current pointer at the head and make a prev pointer.
		ListNode temp = head;
		ListNode prev = null;

		// Go through the entire linked list and constantly point prev to the node before the one we want to remove.
		while (temp.next() != null) {
			if (temp.next().data().equals(elemToRemove)) {
				prev = temp;
			}
			temp = temp.next();
		}

		// Now prev will get rid of the next node, which will be the last instance of elemToRemove.
		if (prev.next().next() == null) {
			prev.setNext(null);
			tail = prev;
		}
		else {
			prev.setNext(prev.next().next());
		}

    }

    /**
     * Create a string representation of the list.  The created string will begin with '[' and
     * end with ']', and contain the toString representation of all elements in the list,
     * separated by commas.  So, if the list contains the first 3 positive integers, then
     * toString would return the string "[1, 2, 3]"
     */
    public String toString() {
			String list = "[";
			ListNode current = head;

			while (current.next() != null) {

				// If the next item is the last in the list, don't add a ", ".
				if (current.next().next() == null) {
					list = list.concat(current.next().data().toString());
				}

				// Else add on a ", ".
				else {
					list = list.concat(current.next().data() + ", ");
				}

				current = current.next();
			}

			list = list.concat("]");
    	return list;
  	}



    public static void main(String args[])
    {
    	LinkedList L  = new LinkedList();
    	for (int i = 0; i < 4; i++)
    	{
    		for (int j = 0; j < 5; j++)
    		{
    			L.add(j);
    		}
    	}
    	System.out.println(L);
    	L.removeFirst(1);
    	System.out.println(L);
    	L.removeFirst(0);
    	System.out.println(L);
    	L.removeLast(3);
    	System.out.println(L);
    	L.removeLast(4);
    	System.out.println(L);
    	L.add(5);
    	System.out.println(L);
    	L.removeAll(0);
    	System.out.println(L);
    	L.removeAll(5);
    	System.out.println(L);

    	L = new LinkedList();
    	for (int i = 0; i < 10; i++)
    	{
    		L.add(1);
    	}
    	System.out.println(L);
    	L.removeAll(1);
    	System.out.println(L);
    	L.add(2);
    	System.out.println(L);
    }

}
