package net.ericsson.emovs.utilities.emp;

import net.ericsson.emovs.utilities.errors.ResponseCode;

import static java.lang.String.format;
import static java.util.Locale.ENGLISH;

public class EMPInvocationError extends Exception {
    final int httpStatus;
    final ResponseCode code;
    
    public EMPInvocationError(int httpStatus, ResponseCode code) {
        super(format(ENGLISH, "HTTP status %d - %s", httpStatus, (code != null) ? code.toString() : "UNKNOWN ERROR"));
        this.httpStatus = httpStatus;
        this.code = code;
    }
    
    public ResponseCode getCode() {
        return code;
    }
    
    public int getHttpStatus() {
        return httpStatus;
    }
}
