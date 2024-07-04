import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPatternValidator {
    private  Pattern pattern;
    private  Matcher matcher;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    private static final String RIGHTFAX_EMAIL_PATTERN = "(^/name=[A-Za-z_.'\\- ]+)?/fax=[0-9]+@fax(dev)?\\.kp\\.org";

    public RegexPatternValidator(Pattern pattern, Matcher matcher) {
        this.pattern = pattern;
        this.matcher = matcher;
    }

    public RegexPatternValidator(String pattern, String str) {
        this.pattern = Pattern.compile(pattern);
        this.matcher = this.pattern.matcher(str);
    }

    public RegexPatternValidator(){}

    public boolean validEmailPattern(String s) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        setMatcher(pattern.matcher(s));
        return matcher.matches();
    }

    public boolean validRightFaxEmailPattern(String s) {
        pattern = Pattern.compile(RIGHTFAX_EMAIL_PATTERN);
        setMatcher(pattern.matcher(s));
        return matcher.matches();
    }

    public boolean stringMatchesPattern(String s, String thisPattern) {
        pattern = Pattern.compile(thisPattern);
        setMatcher(pattern.matcher(s));
        return matcher.matches();
    }


    public  Matcher getMatcher() {
        return matcher;
    }
    public  void setMatcher(Matcher matcher) {
        this.matcher = matcher;
    }




}
