package testdata;

import org.example.entities.Accounts;

import java.util.ArrayList;
import java.util.List;

public class TestUser {

    private String name = "Mateusz";
    private String adress = "Warszawa";
    private List<Accounts> userAccountsList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public List<Accounts> getUserAccountsList() {
        return userAccountsList;
    }

    public void setUserAccountsList(List<Accounts> userAccountsList) {
        this.userAccountsList = userAccountsList;
    }
}
