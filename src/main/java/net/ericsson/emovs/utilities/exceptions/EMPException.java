package net.ericsson.emovs.utilities.exceptions;

public class EMPException extends Exception {

    private int mCode;
    private String mMessage;

    public static final int WRONG_AUTHENTICATION_TOKEN = -57;
    public static final int MISSING_AUTHENTICATION_TOKEN = -58;
    public static final int AUTHENTICATION_TOKEN_INVALIDATED_DURING_PLAYBACK = -59;
    public static final int MISSING_ENTITLEMENT = -60;
    public static final int MISSING_DOWNLOAD_CLIENT = -61;
    public static final int DOWNLOAD_DENIED_FOR_ANONYMOUS_USERS = -62;
    public static final int UNEXPECT_ERROR_FROM_EMP_EXPOSURE = -63;

    public EMPException(int code, String message) {
        super(message);
        mCode = code;
        mMessage = message;
    }

    public int getCode() {
        return mCode;
    }

    @Override
    public String getMessage() {
        return mMessage;
    }
}
