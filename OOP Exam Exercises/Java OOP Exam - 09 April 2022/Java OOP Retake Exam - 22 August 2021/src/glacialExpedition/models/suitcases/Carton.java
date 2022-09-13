package glacialExpedition.models.suitcases;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Carton implements Suitcase{

    private Collection<String> exhibits;

    public Carton() {
        this.exhibits = new ArrayList<>();
    }

    @Override
    public Collection<String> getExhibits() {
        return Collections.unmodifiableCollection(exhibits);
    }
}
