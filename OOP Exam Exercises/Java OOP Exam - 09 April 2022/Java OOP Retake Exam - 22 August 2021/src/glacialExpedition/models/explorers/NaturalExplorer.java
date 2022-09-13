package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{

    private static  int ENERGY = 60;

    public NaturalExplorer(String name) {
        super(name, ENERGY);
    }

    @Override
    public void search() {
        ENERGY -= 7;
        if (ENERGY < 0) {
            ENERGY = 0;
        }
    }

}
