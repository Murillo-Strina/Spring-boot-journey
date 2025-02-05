package AutomakerApp.automaker.api;

import org.springframework.web.bind.annotation.*;
import AutomakerApp.automaker.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class FactoryTestController {

    private final List<Engine> engines;

    public FactoryTestController(List<Engine> engines) {
        this.engines = engines;
    }

    @PostMapping("/{engineType}")
    public CarStatus turnOnCar(@PathVariable String engineType, @RequestBody Key key) {
        Optional<Engine> selectedEngine = engines.stream()
                .filter(engine -> engine.getEngineType().name().equalsIgnoreCase(engineType))
                .findFirst();

        if (selectedEngine.isEmpty()) {
            throw new IllegalArgumentException("Engine type not found: " + engineType);
        }

        var car = new FordMustang(selectedEngine.get());
        return car.startIgnition(key);
    }
}
