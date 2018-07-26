package com.ayantsoft.trms.finance.paypal.model;

public class ItemList {
	
	private Item item;
	private ShippingAddress shippingAddress;
	
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
}
