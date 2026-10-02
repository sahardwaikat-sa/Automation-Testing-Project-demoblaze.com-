package TestPages;

import org.testng.annotations.DataProvider;

public class TestingData {

	
@DataProvider(name = "CustomerInfo")
public Object[][] getdata3() {

	return new Object[][] {
		{"sahar", "Palestine","Nablus","9999","Sept","2026","Thank you for your purchase!",true },
		{"","" ,"","","","","Please fill out Name and Creditcard.",false },
		{"","palestine" ,"nnnn","00000000000000000","Oct","26","Please fill out Name and Creditcard.",false, },
		{"ffff","palestine" ,"nnnn","","Oct","26","Please fill out Name and Creditcard." ,false},
		{"2333", "","","9999","","","Thank you for your purchase!" ,true},
		{"2333", "","","-2333","","","Thank you for your purchase!",true },
		{"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaannnnmnmnnnnnaaaaaaaaaaaaaaaaaa", "","","-2333","","","Thank you for your purchase!",true }
		
		

	};
}


@DataProvider(name = "LoginData")
public Object[][] getLoginData() {
    return new Object[][] {
            { "sahar", "1234", "true" },
            { "admin1", "pass123", "false" },
            { "admin", "123", "false" },
            { "", "pass123", "empty" },
            { "admin", "", "empty" },
            { "", "", "empty" },
            { "admin", "-123", "false" },
            { "Admin", "%&*#@", "false" }
    };
}


@DataProvider(name = "SignUpUsers")
public Object[][] getSignupData() {
    return new Object[][] {
            { "sahar", "1234", "false" },
            { "jjjjjjttttttt", "pass123", "true" },
           
    };
}


@DataProvider(name = "Contact")
public Object[][] getcontactData() {
    return new Object[][] {
            { "sahar@gmail.com", "Palestine","Nablus" ,"true" },
                    
            
          
    };
}

}
