package basic;

import org.testng.annotations.DataProvider;

public class DataDriven {
	 @DataProvider(name = "reviewData")
	    public Object[][] reviewData() {
	        return new Object[][] {
	            {"3", "Ramya", "Great product", "This product exceeded my expectations."},
	        };
	 }
	 @DataProvider(name = "signUpCredentials")
     public Object[][] getSignUpCredentials() {
         return new Object[][]{
                 {"Ramya", "Yarra","ramya123@gmail.com", "Password@123"},
         };
	 }
	 @DataProvider(name = "loginCredentials")
	    public Object[][] getLoginCredentials() {
	        return new Object[][]{
	                {"Yarra@gmail.com", "Password@123"}
	        };
	    }
	 @DataProvider(name = "invalidLoginCredentials")
  public Object[][] getInvalidLoginCredentials() {
      return new Object[][]{
              {"invalidemail@gmail.com", "invalidpassword"},
      };
	 }
}