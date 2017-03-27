package helpers;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class RandomValues {


    public String getRandomAlphaNumericWithSize(int sizeOfRandomString) {
        return randomAlphanumeric(sizeOfRandomString).toLowerCase();
    }
}
