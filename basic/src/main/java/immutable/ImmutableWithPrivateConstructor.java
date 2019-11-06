package immutable;

import java.util.Date;

public final class ImmutableWithPrivateConstructor {

    private final String id;
    private final Date date;

    private ImmutableWithPrivateConstructor(String id, Date date) {
        this.id = id;
        this.date = new Date(date.getTime());
    }

    public static ImmutableWithPrivateConstructor createNewInstance(String id, Date date) {
        return new ImmutableWithPrivateConstructor(id, date);
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return new Date(date.getTime());
    }

}
