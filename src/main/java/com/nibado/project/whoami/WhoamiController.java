package com.nibado.project.whoami;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.nibado.project.whoami.Whoami.of;

@RestController
public class WhoamiController {
    private final LocalDateTime startup;
    private final AtomicInteger requests;

    public WhoamiController() {
        startup = LocalDateTime.now();
        requests = new AtomicInteger();
    }

    @RequestMapping(value = "/whoami", method = RequestMethod.GET, produces = "application/json")
    public Whoami whoami(HttpServletRequest request) {
        List<Whoami.Header> headers = Collections
                .list(request.getHeaderNames())
                .stream()
                .map(key -> new Whoami.Header(key, request.getHeader(key)))
                .collect(Collectors.toList());

        return of(
                startup,
                requests.incrementAndGet(),
                request.getRemoteAddr(),
                headers);
    }


}
