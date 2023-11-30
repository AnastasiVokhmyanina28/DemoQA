package Person;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

@Getter
@Setter
@Accessors(chain = true)
public class Student {
    public String firstName;
    public String lastName;
    public GENDERS gender;
    public String mobile;

    public static Student randomized() {
        return new Student()
                .setFirstName(RandomStringUtils.random(10, true, false))
                .setLastName(RandomStringUtils.random(10, true, false))
                .setGender(GENDERS.values()[new Random().nextInt(GENDERS.values().length - 1)])
                .setMobile(RandomStringUtils.random(10,false,true));
    }

    @Getter
    @AllArgsConstructor

    public static enum GENDERS {

        Male("Male"),
        Female("Female"),
        Other("Other");
        final String gender;
    }

}
