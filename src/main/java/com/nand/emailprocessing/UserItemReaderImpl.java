package com.nand.emailprocessing;

import java.util.Iterator;
import java.util.List;

/**
 * This is implementation class of UserItemReader
 * @author Nand
 *
 */
public class UserItemReaderImpl<I> implements UserItemReader<I> {

	 private List<I> items;

	    private Iterator<I> iterator;

	    public UserItemReaderImpl(List<I> items) {
	    	this.items = items;
	        this.iterator = items.iterator();
	    }

	   
	    public I read() {
	        if (!hasNext())
	            return null;

	        return next();
	    }

	    private boolean hasNext() {
	        return iterator.hasNext();
	    }

	    private I next() {
	        return iterator.next();
	    }


		public List<I> getItems() {
			return items;
		}
}
