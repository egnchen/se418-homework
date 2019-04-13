package com.eyek.se418.lab02.auctuator.indicator;
import com.eyek.se418.lab02.WordLadderSolver;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component("Dictionary")
public class DictionaryResourceHealthIndicator extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) {
        WordLadderSolver solver = new WordLadderSolver();
        try {
            solver.loadDictionary(1);
            builder.up();
        } catch (Exception e) {
            builder.down(e);
        }
    }
}
