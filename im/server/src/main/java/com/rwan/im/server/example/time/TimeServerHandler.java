package com.rwan.im.server.example.time;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author johnlog
 * @date 2018/12/24
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {


    private  int counter = 0;
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf buf = (ByteBuf)msg;

        byte[] req = new byte[buf.readableBytes()];

        buf.readBytes(req);

        String body = new String(req,"UTF-8");

        System.out.println("The server receive order :"+ body +",counter:"+ (++counter));

        String currenTime = "query time".equalsIgnoreCase(body) ? String.valueOf(System.currentTimeMillis()) : "bad order";

        ByteBuf rsp = Unpooled.copiedBuffer(currenTime.getBytes());
        ctx.writeAndFlush(rsp);

//        ctx.writeAndFlush(currenTime);
    }

  /*  @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }*/

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

         cause.printStackTrace();

         ctx.close();
    }
}
