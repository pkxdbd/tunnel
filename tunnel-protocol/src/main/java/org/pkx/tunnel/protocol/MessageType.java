package org.pkx.tunnel.protocol;

public class MessageType {

    /** 认证消息，检测clientKey是否正确 */
    public static final byte C_TYPE_AUTH = 0x01;

    // /** 保活确认消息 */
    // public static final byte TYPE_ACK = 0x02;

    /** 代理后端服务器建立连接消息 */
    public static final byte TYPE_CONNECT = 0x03;

    /** 代理后端服务器断开连接消息 */
    public static final byte TYPE_DISCONNECT = 0x04;

    /** 代理数据传输 */
    public static final byte P_TYPE_TRANSFER = 0x05;

    /** 用户与代理服务器以及代理客户端与真实服务器连接是否可写状态同步 */
    public static final byte C_TYPE_WRITE_CONTROL = 0x06;

    /** 心跳消息 */
    public static final byte TYPE_HEARTBEAT = 0x07;

}
