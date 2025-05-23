package nuts.playgroud.kafka.repo.datagenerator.repository;

import nuts.playgroud.kafka.repo.datagenerator.model.AirportVisitor;

import java.util.List;

public interface AirportVisitorRepository {

    List<AirportVisitor> getAirportVisitors(int offset, int count);

    void add(AirportVisitor visitor);
}
