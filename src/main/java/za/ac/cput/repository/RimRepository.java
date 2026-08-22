package za.ac.cput.repository;

import za.ac.cput.domain.Rim;

import java.util.ArrayList;
import java.util.List;

public class RimRepository implements IRimRepository {

    private static RimRepository repository;

    private List<Rim> rims;

    private RimRepository() {
        rims = new ArrayList<>();
    }

    public static RimRepository getRepository() {

        if (repository == null) {
            repository = new RimRepository();
        }

        return repository;
    }

    @Override
    public Rim create(Rim rim) {

        rims.add(rim);
        return rim;
    }

    @Override
    public Rim read(String id) {

        for (Rim rim : rims) {

            if (rim.getProductID().equals(id)) {
                return rim;
            }
        }

        return null;
    }

    @Override
    public Rim update(Rim rim) {

        for (int i = 0; i < rims.size(); i++) {

            if (rims.get(i).getProductID().equals(rim.getProductID())) {

                rims.set(i, rim);
                return rim;
            }
        }

        return null;
    }

    @Override
    public boolean delete(String id) {

        for (Rim rim : rims) {

            if (rim.getProductID().equals(id)) {

                rims.remove(rim);
                return true;
            }
        }

        return false;
    }

    @Override
    public List<Rim> getAll() {
        return rims;
    }
}