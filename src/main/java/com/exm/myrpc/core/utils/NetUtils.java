package com.exm.myrpc.core.utils;

import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * 编写服务端模块
 *  首先搞定ip和端口的获取
 */
public class NetUtils {

    /**
     * 此处实现的并不到位，暂时就这样处理的
     * 用Java获取本机IP地址，需要处理：
     *1. 多块网卡。
     *2. 排除loopback设备、虚拟网卡
     *看似简单的代码，写起来还是要小心一些的。
     * @return
     *  链接：https://zhuanlan.zhihu.com/p/26017195
     */
    public static String getLocalIp(){
        try {
            return Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }
}
