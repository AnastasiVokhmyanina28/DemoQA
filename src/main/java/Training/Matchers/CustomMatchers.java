package Training.Matchers;

import com.codeborne.selenide.Condition;
import lombok.AllArgsConstructor;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

@AllArgsConstructor
public class CustomMatchers extends BaseMatcher<Integer> {


    private final Integer start;
    private final Integer end;

    @Override
    public boolean matches(Object item) {
        if (!(item instanceof Integer)) {
            return false;
        } else return ((Integer) item >= start && (Integer) item <= end);
    }

    @Override
    public void describeTo(Description description) {

    }
}
