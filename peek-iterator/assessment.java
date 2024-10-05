class PeekingIterator implements Iterator<Integer> {
    List<Integer> elems = new ArrayList<>();
    int idx = 0;
    int len = 0;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    elems.clear();
        idx = 0;
        len = 0;
        while(iterator.hasNext()) {
            elems.add(iterator.next());
            len++;
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return elems.get(idx);
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int nextVal = elems.get(idx);
        idx++;
        return nextVal;
	}
	
	@Override
	public boolean hasNext() {
	    return idx < len;
	}
}