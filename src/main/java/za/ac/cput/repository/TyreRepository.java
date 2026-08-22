package za.ac.cput.repository;

import za.ac.cput.domain.Tyre;

import java.util.ArrayList;
import java.util.List;

public class TyreRepository implements ITyreRepository {

    private static TyreRepository repository;

    private List<Tyre> tyres;

    private TyreRepository() {
        tyres = new ArrayList<>();
    }

    public static TyreRepository getRepository() {

        if (repository == null) {
            repository = new TyreRepository();
        }

        return repository;
    }

    @Override
    public Tyre create(Tyre tyre) {

        tyres.add(tyre);
        return tyre;
    }

    @Override
    public Tyre read(String id) {

        for (Tyre tyre : tyres) {

            if (tyre.getProductID().equals(id)) {
                return tyre;
            }
        }

        return null;
    }

    @Override
    public Tyre update(Tyre tyre) {

        for (int i = 0; i < tyres.size(); i++) {

            if (tyres.get(i).getProductID().equals(tyre.getProductID())) {

                tyres.set(i, tyre);
                return tyre;
            }
        }

        return null;
    }

    @Override
    public boolean delete(String id) {

        for (Tyre tyre : tyres) {

            if (tyre.getProductID().equals(id)) {

                tyres.remove(tyre);
                return true;
            }
        }

        return false;
    }

    @Override
    public List<Tyre> getAll() {
        return tyres;
    }
}