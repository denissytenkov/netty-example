package org.examples.netty.server.protocol;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import org.examples.netty.server.dto.TheSum;

import java.util.List;

/**
 * Created by Denis Sitenkov on 14/01/17.
 */
public class TheProtocolEncoder extends MessageToMessageEncoder<TheSum> {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void encode(ChannelHandlerContext ctx, TheSum msg, List<Object> out) throws Exception {
        out.add(objectMapper.writeValueAsString(msg) + "\n");
    }
}
