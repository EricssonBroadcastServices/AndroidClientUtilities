package net.ericsson.emovs.utilities;

import static java.lang.String.format;
import static java.util.Locale.ENGLISH;

public enum ResponseCode {
    OK(200, "OK", null),
    DEVICE_LIMIT_EXCEEDED(400, "DEVICE_LIMIT_EXCEEDED", "The account is not allowed to register more devices"),
    SESSION_LIMIT_EXCEEDED(400, "SESSION_LIMIT_EXCEEDED", "The account has maximum allowed sessions"),
    UNKNOWN_DEVICE_ID(400, "UNKNOWN_DEVICE_ID", "Device body is missing or the device ID is not found"),
    INVALID_JSON(400, "INVALID_JSON", "JSON received is not valid JSON"),
    INCORRECT_CREDENTIALS(401, "INCORRECT_CREDENTIALS", "Underlying CRM does not accept the given credentials"),
    UNKNOWN_BUSINESS_UNIT(404, "UNKNOWN_BUSINESS_UNIT", "The business unit can not be found"),
    NO_SESSION_TOKEN(401, "NO_SESSION_TOKEN", "Session token is missing"),
    INVALID_SESSION_TOKEN(401, "INVALID_SESSION_TOKEN", "Session token was provided but not valid"),
    UNKNOWN_ASSET(404, "UNKNOWN_ASSET", "The asset was not found"),
    NOT_ENTITLED(403, "NOT_ENTITLED", "User is not entitled to play this asset"),
    DEVICE_BLOCKED(403, "DEVICE_BLOCKED", "The user device is not allowed to play the asset"),
    GEO_BLOCKED(403, "GEO_BLOCKED", "The user is in a country that is not allowed to play the asset"),
    LICENSE_EXPIRED(403, "LICENSE_EXPIRED", "Asset exists but is expired"),
    NOT_ENABLED(403, "NOT_ENABLED", "Media is registered but is not enabled for streaming"),
    DOWNLOAD_TOTAL_LIMIT_REACHED(403, "DOWNLOAD_TOTAL_LIMIT_REACHED", "User has reached the total limit on downloaded assets across devices"),
    DOWNLOAD_ASSET_LIMIT_REACHED(403, "DOWNLOAD_ASSET_LIMIT_REACHED", "This asset has been downloaded the maximum number of times by this user."),
    ALREADY_DOWNLOADED(403, "ALREADY_DOWNLOADED", "Asset downloaded and may not be streamed."),
    DOWNLOAD_BLOCKED(403, "DOWNLOAD_BLOCKED", "This user is not allowed to download this asset"),

    CONCURRENT_STREAMS_LIMIT_REACHED(403, "CONCURRENT_STREAMS_LIMIT_REACHED",
                                     "The maximum number of concurrent stream limit is reached"),
    NOT_AVAILABLE_IN_FORMAT(403, "NOT_AVAILABLE_IN_FORMAT",
                            "The media is not available in a format that can be played on this device"),
    FORBIDDEN(403, "FORBIDDEN", "Request forbidden"),
    CONNECTION_REFUSED(403, "", ""),
    UNKNOWN_ERROR(-1, "UNKNOWN ERROR", "Unkown error");
    
    public final int HttpCode;
    public final String Code;
    public final String Description;
    
    ResponseCode(int httpCode, String code, String description) {
        this.HttpCode = httpCode;
        this.Code = code;
        this.Description = description;
    }
    
    public String toString() {
        if (Description != null) {
            return format(ENGLISH, "(%d) %s - %s", HttpCode, Code, Description);
        }
        else {
            return format(ENGLISH, "(%d) %s", HttpCode, Code);
        }
    }
}
