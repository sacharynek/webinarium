package pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

    public static final String DEFAULT_LANGUAGE_PREFERENCE = "english";
    public static final String DEFAULT_FAVOURITE_CATEGORY_ID = "FISH";

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private int zip;
    private String country;
}
