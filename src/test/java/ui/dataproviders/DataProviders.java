package ui.dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "user-credentials")
    public Object[][] userCredentialsDataProvider() {
        return new Object[][] {
                {"tomsmith", "qwertyuio", "Your password is invalid!\n×"},
                {"qwertyuio", "SuperSecretPassword", "Your username is invalid!\n×"},
                {"qwertyuio", "qweqweqwe", "Your username is invalid!\n×"}
        };
    }
}
