package com.tl.bean;

import java.io.Serializable;

public class FactoryBean implements Serializable {

	private static final long serialVersionUID = 1L;
		private int facID;
		private String facLocation;
		private String facCountry;
		private String facName;
		private String facAddress;
		private String facPhone;
		private String facUrl;
		
		public FactoryBean() {}
		
		public FactoryBean(int facID,String facLocation,String facCountry, String facName,String facAddress,String facPhone,String facUrl) {
			this.facID = facID;
			this.facName = facName;
			this.facAddress=facAddress;
			this.facCountry=facCountry;
			this.facLocation=facLocation;
			this.facPhone = facPhone;
			this.facUrl=facUrl;
			
		
		}
		
		public String getFacLocation() {
			return facLocation;
		}

		public void setFacLocation(String facLocation) {
			this.facLocation = facLocation;
		}

		public String getFacCountry() {
			return facCountry;
		}

		public void setFacCountry(String facCountry) {
			this.facCountry = facCountry;
		}

		public String getFacAddress() {
			return facAddress;
		}

		public void setFacAddress(String facAddress) {
			this.facAddress = facAddress;
		}

		public String getFacPhone() {
			return facPhone;
		}

		public void setFacPhone(String facPhone) {
			this.facPhone = facPhone;
		}

		public String getFacUrl() {
			return facUrl;
		}

		public void setFacUrl(String facUrl) {
			this.facUrl = facUrl;
		}
		
		public int getFacID() {
			return facID;
		}
		public void setFacID(int facID) {
			this.facID = facID;
		}

		public String getFacName() {
			return facName;
		}
		public void setFacName(String facName) {
			this.facName = facName;
		}

		
		
		
	}
