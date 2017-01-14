package org.examples.netty.server.protocol;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.examples.netty.server.dto.TheRequest;

import java.util.List;

/**
 * Created by Denis Sitenkov on 14/01/17.
 */
public class TheProtocolDecoder extends MessageToMessageDecoder<String> {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void decode(ChannelHandlerContext ctx, String msg, List<Object> out) throws Exception {

        System.out.println(msg);
        out.add(objectMapper.readValue(msg, TheRequest.class));
    }
}
