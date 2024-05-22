import org.example.entities.User;

import java.util.List;

public class TestUtils {

    public static User getUserByName(List<User> userList, String userName){

        for(User user : userList){
            if(user.getName().equals(userName)){
                return user;
            }
        }
        return  null;
    }
}
