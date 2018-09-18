package net.ericsson.emovs.utilities.errors;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class InternalPlayerErrorCode {

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
        UNHANDLED_FORMAT_EXCEPTION,
        CONFIGURATION_EXCEPTION,
        INITIALIZATION_EXCEPTION,
        WRITE_EXCEPTION,
        MISSING_SCHEME_DATA_EXCEPTION,
        INVALID_AUDIO_TRACK_TIMESTAMP_EXCEPTION,
        GL_EXCEPTION,
        RUNTIME_EXCEPTION,
        CACHE_DATA_SINK_EXCEPTION,
        CACHE_EXCEPTION,
        ILLEGAL_SEEK_POSITION_EXCEPTION,
        ILLEGAL_STATE_EXCEPTION,
        ILLEGAL_ARGUMENT_EXCEPTION,
        EOF_EXCEPTION,
        INTERRUPTED_IO_EXCEPTION,
        PARSER_EXCEPTION,
        DOWNLOAD_EXCEPTION,
        BEHIND_LIVE_WINDOW_EXCEPTION,
        ILLEGAL_CLIPPING_EXCEPTION,
        ILLEGAL_MERGE_EXCEPTION,
        AD_LOAD_EXCEPTION,
        ASSET_DATA_SOURCE_EXCEPTION,
        CONTENT_DATA_SOURCE_EXCEPTION,
        DATA_SOURCE_EXCEPTION,
        FILE_DATA_SOURCE_EXCEPTION,
        HTTP_DATA_SOURCE_EXCEPTION,
        UDP_DATA_SOURCE_EXCEPTION,
        UNEXPECTED_LOADER_EXCEPTION,
        RAW_RESOURCE_DATA_SOURCE_EXCEPTION,
        PRIORITY_TOO_LOW_EXCEPTION,
        DASH_MANIFEST_STALE_EXCEPTION,
        SAMPLE_QUEUE_MAPPING_EXCEPTION,
        PLAYLIST_STUCK_EXCEPTION,
        PLAYLIST_RESET_EXCEPTION,
        SIMULATED_IO_EXCEPTION,
        INVALID_CONTENT_TYPE_EXCEPTION,
        INVALID_RESPONSE_CODE_EXCEPTION,
        OPEN_EXCEPTION,
        UNSUPPORTED_FORMAT_EXCEPTION,
        UNHANDLED_EDIT_LIST_EXCEPTION,
        UNRECOGNIZED_INPUT_FORMAT_EXCEPTION,
        MISSING_FIELD_EXCEPTION,
        CRYPTO_EXCEPTION,
        DENIED_BY_SERVER_EXCEPTION,
        MEDIA_DRM_EXCEPTION,
        NOT_PROVISIONED_EXCEPTION,
        UNSUPPORTED_SCHEME_EXCEPTION,
        MEDIA_CRYPTO_EXCEPTION,
        DRM_SESSION_EXCEPTION,
        DECRYPTION_EXCEPTION,
        KEYS_EXPIRED_EXCEPTION,
        UNSUPPORTED_DRM_EXCEPTION,
        MEDIA_DRM_STATE_EXCEPTION,
        FFMPEG_DECODER_EXCEPTION,
        FLAC_DECODER_EXCEPTION,
        OPUS_DECODER_EXCEPTION,
        DECODER_INITIALIZATION_EXCEPTION,
        DECODER_QUERY_EXCEPTION,
        METADATA_DECODER_EXCEPTION,
        SUBTITLE_DECODER_EXCEPTION,
        AUDIO_DECODER_EXCEPTION,
        FLAC_FRAME_DECODE_EXCEPTION,
        VPX_DECODER_EXCEPTION,
        CODEC_EXCEPTION
    })
    public @interface ErrorCodeDefinition {}

    // ************************************************************
    // List of EXCEPTIONS

    // GENERAL
    //
    // [ 100 ... 199 ]
    public static final String UNHANDLED_FORMAT_EXCEPTION = "unhandledformatexception";
    public static final String CONFIGURATION_EXCEPTION = "configurationexception";
    public static final String INITIALIZATION_EXCEPTION = "initializationexception";
    public static final String WRITE_EXCEPTION = "writeexception";
    public static final String MISSING_SCHEME_DATA_EXCEPTION = "missingschemedataexception";
    public static final String INVALID_AUDIO_TRACK_TIMESTAMP_EXCEPTION = "invalidaudiotracktimestampexception";
    public static final String GL_EXCEPTION = "glexception";
    public static final String RUNTIME_EXCEPTION = "runtimeexception";
    public static final String CACHE_DATA_SINK_EXCEPTION = "cachedatasinkexception";
    public static final String CACHE_EXCEPTION = "cacheexception";
    public static final String ILLEGAL_SEEK_POSITION_EXCEPTION = "illegalseekpositionexception";
    public static final String ILLEGAL_STATE_EXCEPTION = "illegalstateexception";
    public static final String ILLEGAL_ARGUMENT_EXCEPTION = "illegalargumentexception";
    public static final String EOF_EXCEPTION = "eofexception";

    // IOException related
    //
    // [ 200 ... 299 ]
    public static final String INTERRUPTED_IO_EXCEPTION = "interruptedioexception";
    public static final String PARSER_EXCEPTION = "parserexception";
    public static final String DOWNLOAD_EXCEPTION = "downloadexception";
    public static final String BEHIND_LIVE_WINDOW_EXCEPTION = "behindlivewindowexception";
    public static final String ILLEGAL_CLIPPING_EXCEPTION = "illegalclippingexception";
    public static final String ILLEGAL_MERGE_EXCEPTION = "illegalmergeexception";
    public static final String AD_LOAD_EXCEPTION = "adloadexception";
    public static final String ASSET_DATA_SOURCE_EXCEPTION = "assetdatasourceexception";
    public static final String CONTENT_DATA_SOURCE_EXCEPTION = "contentdatasourceexception";
    public static final String DATA_SOURCE_EXCEPTION = "datasourceexception";
    public static final String FILE_DATA_SOURCE_EXCEPTION = "filedatasourceexception";
    public static final String HTTP_DATA_SOURCE_EXCEPTION = "httpdatasourceexception";
    public static final String UDP_DATA_SOURCE_EXCEPTION = "udpdatasourceexception";
    public static final String UNEXPECTED_LOADER_EXCEPTION = "unexpectedloaderexception";
    public static final String RAW_RESOURCE_DATA_SOURCE_EXCEPTION = "rawresourcedatasourceexception";
    public static final String PRIORITY_TOO_LOW_EXCEPTION = "prioritytoolowexception";
    public static final String DASH_MANIFEST_STALE_EXCEPTION = "dashmanifeststaleexception";
    public static final String SAMPLE_QUEUE_MAPPING_EXCEPTION = "samplequeuemappingexception";
    public static final String PLAYLIST_STUCK_EXCEPTION = "playliststuckexception";
    public static final String PLAYLIST_RESET_EXCEPTION = "playlistresetexception";
    public static final String SIMULATED_IO_EXCEPTION = "simulatedioexception";
    public static final String INVALID_CONTENT_TYPE_EXCEPTION = "invalidcontenttypeexception";
    public static final String INVALID_RESPONSE_CODE_EXCEPTION = "invalidresponsecodeexception";
    public static final String OPEN_EXCEPTION = "openexception";
    public static final String UNSUPPORTED_FORMAT_EXCEPTION = "unsupportedformatexception";
    public static final String UNHANDLED_EDIT_LIST_EXCEPTION = "unhandlededitlistexception";
    public static final String UNRECOGNIZED_INPUT_FORMAT_EXCEPTION = "unrecognizedinputformatexception";
    public static final String MISSING_FIELD_EXCEPTION = "missingfieldexception";

    // DRM related
    //
    // [ 300 ... 399 ]
    public static final String CRYPTO_EXCEPTION = "cryptoexception";
    public static final String DENIED_BY_SERVER_EXCEPTION = "deniedbyserverexception";
    public static final String MEDIA_DRM_EXCEPTION = "mediadrmexception";
    public static final String NOT_PROVISIONED_EXCEPTION = "notprovisionedexception";
    public static final String UNSUPPORTED_SCHEME_EXCEPTION = "unsupportedschemeexception";
    public static final String MEDIA_CRYPTO_EXCEPTION = "mediacryptoexception";
    public static final String DRM_SESSION_EXCEPTION = "drmsessionexception";
    public static final String DECRYPTION_EXCEPTION = "decryptionexception";
    public static final String KEYS_EXPIRED_EXCEPTION = "keysexpiredexception";
    public static final String UNSUPPORTED_DRM_EXCEPTION = "unsupporteddrmexception";
    public static final String MEDIA_DRM_STATE_EXCEPTION = "mediadrmstateexception";

    // DECODER related
    //
    // [ 400 ... 499 ]
    public static final String FFMPEG_DECODER_EXCEPTION = "ffmpegdecoderexception";
    public static final String FLAC_DECODER_EXCEPTION = "flacdecoderexception";
    public static final String OPUS_DECODER_EXCEPTION = "opusdecoderexception";
    public static final String DECODER_INITIALIZATION_EXCEPTION = "decoderinitializationexception";
    public static final String DECODER_QUERY_EXCEPTION = "decoderqueryexception";
    public static final String METADATA_DECODER_EXCEPTION = "metadatadecoderexception";
    public static final String SUBTITLE_DECODER_EXCEPTION = "subtitledecoderexception";
    public static final String AUDIO_DECODER_EXCEPTION = "audiodecoderexception";
    public static final String FLAC_FRAME_DECODE_EXCEPTION = "flacframedecodeexception";
    public static final String VPX_DECODER_EXCEPTION = "vpxdecoderexception";
    public static final String CODEC_EXCEPTION = "codecexception";

    public final String mExceptionName;
    public final int mErrorCode;

    public InternalPlayerErrorCode(@ErrorCodeDefinition String exceptionName) {
        mExceptionName = exceptionName;
        mErrorCode = getErrorCodeFromName(exceptionName);
    }

    public int getErrorCode() {
        return mErrorCode;
    }

    private int getErrorCodeFromName(@ErrorCodeDefinition String exceptionName) {
        int errorCode = 1;

        // List of EXCEPTIONS Error Codes
        switch (exceptionName) {
            // GENERAL
            //
            // [ 100 ... 199 ]
            case (UNHANDLED_FORMAT_EXCEPTION)               : errorCode = 100; break;
            case (CONFIGURATION_EXCEPTION)                  : errorCode = 101; break;
            case (INITIALIZATION_EXCEPTION)                 : errorCode = 102; break;
            case (WRITE_EXCEPTION)                          : errorCode = 103; break;
            case (MISSING_SCHEME_DATA_EXCEPTION)            : errorCode = 104; break;
            case (INVALID_AUDIO_TRACK_TIMESTAMP_EXCEPTION)  : errorCode = 105; break;
            case (GL_EXCEPTION)                             : errorCode = 106; break;
            case (RUNTIME_EXCEPTION)                        : errorCode = 107; break;
            case (CACHE_DATA_SINK_EXCEPTION)                : errorCode = 108; break;
            case (CACHE_EXCEPTION)                          : errorCode = 109; break;
            case (ILLEGAL_SEEK_POSITION_EXCEPTION)          : errorCode = 110; break;
            case (ILLEGAL_STATE_EXCEPTION)                  : errorCode = 111; break;
            case (ILLEGAL_ARGUMENT_EXCEPTION)               : errorCode = 112; break;
            case (EOF_EXCEPTION)                            : errorCode = 113; break;

            // IOException related
            //
            // [ 200 ... 299 ]
            case (INTERRUPTED_IO_EXCEPTION)                 : errorCode = 200; break;
            case (PARSER_EXCEPTION)                         : errorCode = 201; break;
            case (DOWNLOAD_EXCEPTION)                       : errorCode = 202; break;
            case (BEHIND_LIVE_WINDOW_EXCEPTION)             : errorCode = 203; break;
            case (ILLEGAL_CLIPPING_EXCEPTION)               : errorCode = 204; break;
            case (ILLEGAL_MERGE_EXCEPTION)                  : errorCode = 205; break;
            case (AD_LOAD_EXCEPTION)                        : errorCode = 206; break;
            case (ASSET_DATA_SOURCE_EXCEPTION)              : errorCode = 207; break;
            case (CONTENT_DATA_SOURCE_EXCEPTION)            : errorCode = 208; break;
            case (DATA_SOURCE_EXCEPTION)                    : errorCode = 209; break;
            case (FILE_DATA_SOURCE_EXCEPTION)               : errorCode = 210; break;
            case (HTTP_DATA_SOURCE_EXCEPTION)               : errorCode = 211; break;
            case (UDP_DATA_SOURCE_EXCEPTION)                : errorCode = 212; break;
            case (UNEXPECTED_LOADER_EXCEPTION)              : errorCode = 213; break;
            case (RAW_RESOURCE_DATA_SOURCE_EXCEPTION)       : errorCode = 214; break;
            case (PRIORITY_TOO_LOW_EXCEPTION)               : errorCode = 215; break;
            case (DASH_MANIFEST_STALE_EXCEPTION)            : errorCode = 216; break;
            case (SAMPLE_QUEUE_MAPPING_EXCEPTION)           : errorCode = 217; break;
            case (PLAYLIST_STUCK_EXCEPTION)                 : errorCode = 218; break;
            case (PLAYLIST_RESET_EXCEPTION)                 : errorCode = 219; break;
            case (SIMULATED_IO_EXCEPTION)                   : errorCode = 220; break;
            case (INVALID_CONTENT_TYPE_EXCEPTION)           : errorCode = 221; break;
            case (INVALID_RESPONSE_CODE_EXCEPTION)          : errorCode = 222; break;
            case (OPEN_EXCEPTION)                           : errorCode = 223; break;
            case (UNSUPPORTED_FORMAT_EXCEPTION)             : errorCode = 224; break;
            case (UNHANDLED_EDIT_LIST_EXCEPTION)            : errorCode = 225; break;
            case (UNRECOGNIZED_INPUT_FORMAT_EXCEPTION)      : errorCode = 226; break;
            case (MISSING_FIELD_EXCEPTION)                  : errorCode = 227; break;

            // DRM related
            //
            // [ 300 ... 399 ]
            case (CRYPTO_EXCEPTION)                         : errorCode = 300; break;
            case (DENIED_BY_SERVER_EXCEPTION)               : errorCode = 301; break;
            case (MEDIA_DRM_EXCEPTION)                      : errorCode = 302; break;
            case (NOT_PROVISIONED_EXCEPTION)                : errorCode = 303; break;
            case (UNSUPPORTED_SCHEME_EXCEPTION)             : errorCode = 304; break;
            case (MEDIA_CRYPTO_EXCEPTION)                   : errorCode = 305; break;
            case (DRM_SESSION_EXCEPTION)                    : errorCode = 306; break;
            case (DECRYPTION_EXCEPTION)                     : errorCode = 307; break;
            case (KEYS_EXPIRED_EXCEPTION)                   : errorCode = 308; break;
            case (UNSUPPORTED_DRM_EXCEPTION)                : errorCode = 309; break;
            case (MEDIA_DRM_STATE_EXCEPTION)                : errorCode = 310; break;

            // DECODER related
            //
            // [ 400 ... 499 ]
            case (FFMPEG_DECODER_EXCEPTION)                 : errorCode = 400; break;
            case (FLAC_DECODER_EXCEPTION)                   : errorCode = 401; break;
            case (OPUS_DECODER_EXCEPTION)                   : errorCode = 402; break;
            case (DECODER_INITIALIZATION_EXCEPTION)         : errorCode = 403; break;
            case (DECODER_QUERY_EXCEPTION)                  : errorCode = 404; break;
            case (METADATA_DECODER_EXCEPTION)               : errorCode = 405; break;
            case (SUBTITLE_DECODER_EXCEPTION)               : errorCode = 406; break;
            case (AUDIO_DECODER_EXCEPTION)                  : errorCode = 407; break;
            case (FLAC_FRAME_DECODE_EXCEPTION)              : errorCode = 408; break;
            case (VPX_DECODER_EXCEPTION)                    : errorCode = 409; break;
            case (CODEC_EXCEPTION)                          : errorCode = 410; break;

            // Default Error : ExoPlaybackException
            //
            // [ 1 ]
            default                                         : errorCode =   1; break;
        }

        return errorCode;
    }
}
