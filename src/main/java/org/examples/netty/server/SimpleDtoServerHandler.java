package org.examples.netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.examples.netty.server.dto.TheRequest;
import org.examples.netty.server.dto.TheSum;

import java.util.stream.IntStream;

/**
 * Created by Denis Sitenkov on 14/01/17.
 */
public class SimpleDtoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println(msg);
        if (msg instanceof TheRequest) {
            TheRequest req = (TheRequest) msg;
            ctx.write(new TheSum(IntStream.of(req.some_data).sum()));
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
