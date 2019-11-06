package immutable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class ImmutableWithMutable {

    private final int id;
    private final String name;
    private final Map<String, String> mutable;

    ImmutableWithMutable(int id, String name, Map<String, String> mutable) {
        this.id = id;
        this.name = name;
        Map<String, String> mutabletemp = new HashMap<String, String>();
        String key;
        Iterator<String> it = mutable.keySet().iterator();
        while (it.hasNext()) {
            key = it.next();
            mutabletemp.put(key, mutable.get(it));
        }
        this.mutable = mutabletemp;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getMutable() {
        return new HashMap<String, String>(mutable);
    }
}
