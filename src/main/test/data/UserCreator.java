package test.data;

import org.codehaus.jackson.map.ObjectMapper;
import pojo.User;

import java.io.File;
import java.io.IOException;

public class UserCreator {

    public static final String TEST_DATAFILE = "src\\main\\resources\\testdata.json";

    public static User getUser(String pathToFile) {
        User user = new User();
        try {
            ObjectMapper mapper = new ObjectMapper();
            user = mapper.readValue(new File(pathToFile), User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
