package com.nibado.project.whoami;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalDateTime.now;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

@Data
public class Whoami {
    private final String time;
    private final String startup;
    private final int requests;
    private final String hostname = WhoamiApplication.HOSTNAME;
    private final String ip;
    protected final List<Header> headers;

    public static Whoami of(final LocalDateTime startup, final int requests, final String ip, final List<Header> headers) {
        return new Whoami(
                now().format(ISO_DATE_TIME),
                startup.format(ISO_DATE_TIME),
                requests,
                ip,
                headers);
    }

    @Data
    public static class Header {
        private final String key;
        private final String value;
    }
}
