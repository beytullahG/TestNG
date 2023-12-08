package tests.P15_configuration_driver_Usage;

import org.testng.annotations.Test;

public class C04_NegativeLoginTest {

    // 1- Go to the homepage https://www.testautomationu.com/
    // 2- Click on the "login" link
    // 3- Create 3 different test methods.
    //	- valid username, invalid password
    //	- invalid username, valid password
    //	- invalid username, invalid password.
    //4- Login by clicking the Login button
    //5- Test if the login is unsuccessful

    @Test
    public void invalidPasswordTest(){
        // 1- Go to the homepage https://www.testautomationu.com/
        // 2- Click on the "account" link
        // 3- Create 3 different test methods.
        //	- valid username, invalid password

        //4- Login by clicking the Login button

        //5- Test if the login is unsuccessful

    }

    @Test
    public void invalidEmailTest(){
        // 1- Go to the homepage https://www.testautomationu.com/

        // 2- Click on the "account" link

        // 3- Create 3 different test methods.
        //	- invalid username, valid password

        //4- Login by clicking the Login button


    }

    @Test(priority = 5)
    public void invalidEmailInvalidPasswordTest() {
        // 1- Go to the homepage https://www.testautomationu.com/

        // 2- Click on the "account" link

        // 3- Create 3 different test methods.
        //	- invalid username, invalid password

        //4- Login by clicking the Login button

        //5- Test if the login is unsuccessful


    }
}
