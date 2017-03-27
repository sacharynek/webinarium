package rest;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Specifications {

    public static final String ACCEPT = "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8";
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";

    public static RequestSpecification setupBasicHeaders() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder
                .setAccept(ACCEPT)
                .setContentType(CONTENT_TYPE);
        RequestSpecification requestSpec = builder.build();
        return requestSpec;
    }

    public static RequestSpecification setupAddUser(String username,
                                                    String password,
                                                    String repeatPassword,
                                                    String firstName,
                                                    String lastName,
                                                    String email,
                                                    String phone,
                                                    String address1,
                                                    String address2,
                                                    String city,
                                                    String state,
                                                    int zip,
                                                    String country,
                                                    String languagePreference,
                                                    String favouriteCategoryId
    ) {
        RequestSpecBuilder builder = new RequestSpecBuilder();

        builder.setBody("username=" + username +
                "&password=" + password +
                "&repeatedPassword=" + repeatPassword +
                "&account.firstName=" + firstName +
                "&account.lastName=" + lastName +
                "&account.email=" + email +
                "&account.phone=" + phone +
                "&account.address1=" + address1 +
                "&account.address2=" + address2 +
                "&account.city=" + city +
                "&account.state=" + state +
                "&account.zip=" + String.valueOf(zip) +
                "&account.country=" + country +
                "&account.languagePreference=" + languagePreference +
                "&account.favouriteCategoryId=" + favouriteCategoryId +
                "&newAccount=Save+Account+Information");

        return builder.build();
    }
}
