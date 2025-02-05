package AutomakerApp.automaker.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import AutomakerApp.automaker.Engine;
import AutomakerApp.automaker.EngineType;

@Configuration
public class AutomakerConfiguration {

    @Bean
    public Engine aspiratedEngine() {
        return createEngine("Coyote 5.0L V8", 450, 8, 5.0, EngineType.NATURALLY_ASPIRATED);
    }

    @Bean
    public Engine electricEngine() {
        return createEngine("Ford Mach-E 88kWh Electric Motor", 500, 110, 1.4, EngineType.ELECTRIC);
    }

    @Bean
    public Engine turboEngine() {
        return createEngine("Coyote 5.0L V8 Turbocharged", 650, 8, 5.0, EngineType.TURBO);
    }

    private Engine createEngine(String model, int horsepower, int cylinders, double displacement, EngineType type) {
        var engine = new Engine();
        engine.setModel(model);
        engine.setHorsepower(horsepower);
        engine.setCylinders(cylinders);
        engine.setDisplacement(displacement);
        engine.setEngineType(type);
        return engine;
    }
}
