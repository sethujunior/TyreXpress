package za.ac.cput.service;

import za.ac.cput.domain.Tyre;
//import za.ac.cput.repository.TyreRepositoryImpl;

import java.util.List;

public class TyreServiceImpl implements ITyreService {

    private static TyreServiceImpl service;

//    private TyreRepositoryImpl repository;

    private TyreServiceImpl() {
//        repository = TyreRepositoryImpl.getRepository();
    }

    public static TyreServiceImpl getService() {

        if (service == null) {
            service = new TyreServiceImpl();
        }

        return service;
    }

    @Override
    public Tyre create(Tyre tyre) {
        return null;
//        return repository.create(tyre);
    }

    @Override
    public Tyre read(String id) {
        return null;
//        return repository.read(id);
    }

    @Override
    public Tyre update(Tyre tyre) {
        return null;
//        return repository.update(tyre);
    }

    @Override
    public boolean delete(String id) {
        return false;
//        return repository.delete(id);
    }

    @Override
    public List<Tyre> getAll() {
        return null;
//        return repository.getAll();
    }
 }
