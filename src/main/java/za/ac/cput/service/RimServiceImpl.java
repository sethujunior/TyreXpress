package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Rim;
import za.ac.cput.repository.IRimRepository;
//import za.ac.cput.repository.RimRepositoryImpl;

import java.util.List;
@Service
public class RimServiceImpl implements IRimService {

    private IRimRepository rimRepository;

    public RimServiceImpl(IRimRepository rimRepository) {
        this.rimRepository = rimRepository;
    }

    @Override
    public Rim create(Rim rim) {
        return rimRepository.save(rim);
    }

    @Override
    public Rim read(Long aLong) {
        return rimRepository.findById(aLong).orElse(null);
    }

    @Override
    public Rim update(Rim rim) {
        return rimRepository.save(rim);
    }

    @Override
    public boolean delete(Long aLong) {
        return rimRepository.existsById(aLong);
    }

    @Override
    public List<Rim> getAll() {
        return rimRepository.findAll();
    }
}
