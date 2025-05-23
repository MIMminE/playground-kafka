package nuts.playgroud.kafka.repo.datagenerator.service;

import nuts.playgroud.kafka.repo.datagenerator.model.AirportVisitor;

import java.util.List;

public interface AirportVisitorGeneratorService {

       List<AirportVisitor> getAirportVisitors(int offset);
}
