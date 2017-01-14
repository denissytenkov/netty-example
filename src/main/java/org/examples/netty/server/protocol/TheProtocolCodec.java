package org.examples.netty.server.protocol;

import io.netty.channel.CombinedChannelDuplexHandler;

/**
 * Created by Denis Sitenkov on 14/01/17.
 */
public class TheProtocolCodec extends CombinedChannelDuplexHandler<TheProtocolDecoder, TheProtocolEncoder> {

    public TheProtocolCodec() {
        super(new TheProtocolDecoder(), new TheProtocolEncoder());
    }
}
