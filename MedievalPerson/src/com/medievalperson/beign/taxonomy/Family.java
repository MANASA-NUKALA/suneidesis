package com.medievalperson.beign.taxonomy;

import com.medievalperson.Concept;

public class Family extends Concept {

	private Order order;

	private Family superFamily;
	
	public Family(String name) {
		super(name);
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Family getSuperFamily() {
		return superFamily;
	}

	public void setSuperFamily(Family superFamily) {
		this.superFamily = superFamily;
	}

}
