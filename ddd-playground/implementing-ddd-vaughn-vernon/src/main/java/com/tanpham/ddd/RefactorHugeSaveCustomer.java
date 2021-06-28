package com.tanpham.ddd;

public class RefactorHugeSaveCustomer {
	
	class Customer {
		private Long customerId;
		private String customerFirstName; 
		private String customerLastName;
		private String streetAddress1; 
		private String streetAddress2;
		private String city; 
		private String stateOrProvince;
		private String postalCode; 
		private String country;
		private String homePhone; 
		private String mobilePhone;
		private String primaryEmailAddress; 
		private String secondaryEmailAddress;
		public Long getCustomerId() {
			return customerId;
		}
		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}
		public String getCustomerFirstName() {
			return customerFirstName;
		}
		public void setCustomerFirstName(String customerFirstName) {
			this.customerFirstName = customerFirstName;
		}
		public String getCustomerLastName() {
			return customerLastName;
		}
		public void setCustomerLastName(String customerLastName) {
			this.customerLastName = customerLastName;
		}
		public String getStreetAddress1() {
			return streetAddress1;
		}
		public void setStreetAddress1(String streetAddress1) {
			this.streetAddress1 = streetAddress1;
		}
		public String getStreetAddress2() {
			return streetAddress2;
		}
		public void setStreetAddress2(String streetAddress2) {
			this.streetAddress2 = streetAddress2;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getStateOrProvince() {
			return stateOrProvince;
		}
		public void setStateOrProvince(String stateOrProvince) {
			this.stateOrProvince = stateOrProvince;
		}
		public String getPostalCode() {
			return postalCode;
		}
		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getHomePhone() {
			return homePhone;
		}
		public void setHomePhone(String homePhone) {
			this.homePhone = homePhone;
		}
		public String getMobilePhone() {
			return mobilePhone;
		}
		public void setMobilePhone(String mobilePhone) {
			this.mobilePhone = mobilePhone;
		}
		public String getPrimaryEmailAddress() {
			return primaryEmailAddress;
		}
		public void setPrimaryEmailAddress(String primaryEmailAddress) {
			this.primaryEmailAddress = primaryEmailAddress;
		}
		public String getSecondaryEmailAddress() {
			return secondaryEmailAddress;
		}
		public void setSecondaryEmailAddress(String secondaryEmailAddress) {
			this.secondaryEmailAddress = secondaryEmailAddress;
		}
	}
	
	class CustomerDao {
		public Customer readCustomer(Long customerId) {
			return new Customer();
		}
		
		public Customer saveCustomer(Customer customer) {
			return new Customer();
		}
	}

	class CustomerService {
		private CustomerDao customerDao;
		public void saveCustomer(
				Long customerId,
				String customerFirstName, String customerLastName,
				String streetAddress1, String streetAddress2,
				String city, String stateOrProvince,
				String postalCode, String country,
				String homePhone, String mobilePhone,
				String primaryEmailAddress, String secondaryEmailAddress) {
			Customer customer = customerDao.readCustomer(customerId);
			if (customer == null) {
				customer = new Customer();
				customer.setCustomerId(customerId);
			}

			if (customerFirstName != null) {
				customer.setCustomerFirstName(customerFirstName);
			}
			if (customerLastName != null) {
				customer.setCustomerLastName(customerLastName);
			}
			if (streetAddress1 != null) {
				customer.setStreetAddress1(streetAddress1);
			}
			if (streetAddress2 != null) {
				customer.setStreetAddress2(streetAddress2);
			}
			if (city != null) {
				customer.setCity(city);
			}
			if (stateOrProvince != null) {
				customer.setStateOrProvince(stateOrProvince);
			}
			if (postalCode != null) {
				customer.setPostalCode(postalCode);
			}
			if (country != null) {
				customer.setCountry(country);
			}
			if (homePhone != null) {
				customer.setHomePhone(homePhone);
			}
			if (mobilePhone != null) {
				customer.setMobilePhone(mobilePhone);
			}
			if (primaryEmailAddress != null) {
				customer.setPrimaryEmailAddress(primaryEmailAddress);
			}
			if (secondaryEmailAddress != null) {
				customer.setSecondaryEmailAddress(secondaryEmailAddress);
			}
			customerDao.saveCustomer(customer);
		}
	}
	
	
	////////////////////////////////////// Refactoring to this idea
	interface ICustomer {
		public void changePersonalName(
				String firstName, String lastName);
		public void postalAddress(PostalAddress postalAddress);
		public void relocateTo(PostalAddress changedPostalAddress);
		public void changeHomeTelephone(Telephone telephone);
		public void disconnectHomeTelephone();
		public void changeMobileTelephone(Telephone telephone);
		public void disconnectMobileTelephone();
		public void primaryEmailAddress(EmailAddress emailAddress);
		public void secondaryEmailAddress(EmailAddress emailAddress);
	}
	
	class PostalAddress {
		 
	}
	
	class Telephone {
		
	}
	
	class EmailAddress {
		
	}
	
}
