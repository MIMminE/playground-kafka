package nuts.playgroud.kafka.repo.datagenerator.service;

import lombok.RequiredArgsConstructor;
import nuts.playgroud.kafka.repo.datagenerator.model.AirportVisitor;
import nuts.playgroud.kafka.repo.datagenerator.repository.AirportVisitorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DummyAirportVisitorGeneratorService implements CommandLineRunner, AirportVisitorGeneratorService {
    private final AirportVisitorRepository repository;


    @Override
    public List<AirportVisitor> getAirportVisitors(int offset) {
        return List.of();
    }

    @Override
    public void run(String... args) throws Exception {


    }


    private AirportVisitor generateVisitor() {

    }
}
