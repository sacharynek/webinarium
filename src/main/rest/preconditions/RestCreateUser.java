package rest.preconditions;

import pojo.User;

import static environment.EnvValues.JPET_STORE_ENV;
import static environment.EnvValues.REGISTER_USER;
import static io.restassured.RestAssured.given;
import static pojo.User.DEFAULT_FAVOURITE_CATEGORY_ID;
import static pojo.User.DEFAULT_LANGUAGE_PREFERENCE;
import static rest.Specifications.setupAddUser;
import static rest.Specifications.setupBasicHeaders;

public class RestCreateUser {

    public User createUser(User user) {

        given().log().all().spec(setupBasicHeaders())
                .when()
                .spec(
                        setupAddUser(
                                user.getUsername(),
                                user.getPassword(),
                                user.getPassword(),
                                user.getFirstName(),
                                user.getLastName(),
                                user.getEmail(),
                                user.getPhone(),
                                user.getAddress1(),
                                user.getAddress1(),
                                user.getCity(),
                                user.getState(),
                                user.getZip(),
                                user.getCountry(),
                                DEFAULT_LANGUAGE_PREFERENCE,
                                DEFAULT_FAVOURITE_CATEGORY_ID
                        ))
                .post(JPET_STORE_ENV + REGISTER_USER)
                .then()
                .assertThat().statusCode(302);

        return user;
    }
}
