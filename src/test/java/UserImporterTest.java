import InputOutput.UserImporter;
import ListsAndIterators.ArrayUnorderedList;
import UserData.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserImporterTest {
    UserImporter userImporter;

    @BeforeEach
    void setup() {
        userImporter = new UserImporter("./src/main/resources/socialgraph.json");
    }


    @Test
    void getUsersTest(){
        ArrayUnorderedList<User> list = userImporter.getUsers();
        for (User u :
                list) {
            System.out.print(u.toString());
        }
    }

}
