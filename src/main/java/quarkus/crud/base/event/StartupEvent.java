package quarkus.crud.base.event;


import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

import java.time.LocalDateTime;

@ApplicationScoped
public class StartupEvent {


    void startup(@Observes StartupEvent event) {

        Log.info("Aplicação iniciada em " + LocalDateTime.now());
    }


}
