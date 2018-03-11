
package es.jaranda.commons.timeutils.examples.timerangeexample.domain.service.impl;

import es.jaranda.commons.timeutils.examples.timerangeexample.domain.service.InstantService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class InstantServiceImpl implements InstantService {
    @Override
    public Instant now() {
        return Instant.now();
    }
}
