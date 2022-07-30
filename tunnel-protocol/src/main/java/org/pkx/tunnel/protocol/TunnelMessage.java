package org.pkx.tunnel.protocol;

public class TunnelMessage {

    /** 消息类型 */
    private byte type;

    /** 消息流水号 */
    private long serialNumber;

    /** 消息命令请求信息 */
    private String uri;

    /** 消息传输数据 */
    private byte[] data;

}
