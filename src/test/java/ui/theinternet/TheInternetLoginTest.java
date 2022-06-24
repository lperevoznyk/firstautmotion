package ui.theinternet;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.theinternet.TheInternetLoginPage;
import testdata.User;
import ui.BaseTest;
import ui.dataproviders.DataProviders;

public class TheInternetLoginTest extends BaseTest {

    //valid login: tomsmith
    //valid password: SuperSecretPassword!
    @Test(description = "Error message should appears if user enters invalid credentials",
            dataProvider = "user-credentials", dataProviderClass = DataProviders.class)
    public void errorMessageShouldAppears(String login, String password, String errorMessage) {
        User user = new User(login, password);
        TheInternetLoginPage theInternetLoginPage = new TheInternetLoginPage(driver);
        theInternetLoginPage.navigate();
        theInternetLoginPage.login(user);
        Assert.assertEquals(theInternetLoginPage.getErrorMessage(), errorMessage);
    }

    @Test(groups = "exclude-me")
    public void arrayTest() {
        int[][] array = new int[4][6];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = i + j;
            }
        }
        print(array);
    }

    private void print(int[][] arr) {
        for (int row = 0; row < arr.length; row++)//Cycles through rows
        {
            for (int col = 0; col < arr[row].length; col++)//Cycles through columns
            {
                System.out.printf("%5d", arr[row][col]); //change the %5d to however much space you want
            }
            System.out.println(); //Makes a new row
        }
    }
}