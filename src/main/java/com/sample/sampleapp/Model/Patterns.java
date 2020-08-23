/**
 * Description of this interface.
 *
 * @author roundsquare
 */
public interface Patterns {
    private final Pattern USERNAME = Pattern.compile("^[\\b|\\S|\\W]*${2,20}"),
    private final Pattern PASSWORD = Pattern
        .compile("^(?=\\d)(?=*[a-z])(?=[A-Z])(?=*[!@#$%^&*()_+])${8,20}",);
    private final Pattern EMAIL = Pattern
        .compile("^[\\b|\\W|\\S]+[@]+[\\b|\\W|\\S]+[.]+[\\w|\\S]${5,30}");
}
