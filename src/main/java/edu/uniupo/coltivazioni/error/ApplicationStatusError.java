package edu.uniupo.coltivazioni.error;

import lombok.Getter;

@Getter
public enum ApplicationStatusError {

    OK( 200, Series.SUCCESSFUL, "The Request was executed successfully" ),
    CREATED( 201, Series.SUCCESSFUL, "The create Request was executed successfully" ),
    DATA_FOUND( 203, Series.SUCCESSFUL, "The search Request was executed successfully" ),
    BAD_REQUEST( 400, Series.CLIENT_ERROR, "Bad Request was met" ),
    UNAUTHORIZED( 401, Series.CLIENT_ERROR, "You cannot run this service due to your permissions" ),
    FORBIDDEN( 403, Series.CLIENT_ERROR, "You are not authenticated in server" ),
    NOT_FOUND( 404, Series.CLIENT_ERROR, "The search query produced a null result" ),
    INTERNAL_SERVER_ERROR( 500, Series.SERVER_ERROR, "Internal Server Error" ),
    NOT_IMPLEMENTED( 501, Series.SERVER_ERROR, "Not Implemented service" ),
    BAD_GATEWAY( 502, Series.SERVER_ERROR, "Bad Gateway" ),
    SERVICE_UNAVAILABLE( 503, Series.SERVER_ERROR, "Service Unavailable" );

    private final Integer code;
    private final Series series;
    private final String reason;

    ApplicationStatusError ( Integer code, Series series, String reason ) {
        this.code = code;
        this.series = series;
        this.reason = reason;
    }

    private enum Series {
        INFORMATIONAL, SUCCESSFUL, REDIRECTION, CLIENT_ERROR, SERVER_ERROR
    }
}
