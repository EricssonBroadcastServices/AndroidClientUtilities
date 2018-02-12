package net.ericsson.emovs.utilities.queries;

/**
 * Created by Joao Coelho on 2017-09-26.
 */

public class ChannelsQueryParameters extends BaseQueryParams {
    public static final ChannelsQueryParameters DEFAULT = (ChannelsQueryParameters) new ChannelsQueryParameters().setPageSize(100);

    public ChannelsQueryParameters() {
        super();
    }

}
