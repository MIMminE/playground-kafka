package nuts.playgroud.kafka.repo.datagenerator.repository;

import nuts.playgroud.kafka.repo.datagenerator.model.AirportVisitor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@R
public class InMemoryRepository implements AirportVisitorRepository {

    private final int limit = 1_000_000;
    private final List<AirportVisitor> airportVisitors = new ArrayList<>();

    @Override
    public List<AirportVisitor> getAirportVisitors(int offset, int count) {

        if (offset + count > airportVisitors.size())
            return airportVisitors.subList(offset, airportVisitors.size());

        return airportVisitors.subList(offset, offset + count);
    }

    @Override
    public void add(AirportVisitor visitor) {
        synchronized (this) {
            airportVisitors.add(visitor);
        }
    }
}

