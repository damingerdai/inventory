package org.daming.inventory.utils;

/**
 * 描述： 异常处理
 *
 * @author daming
 * @date 2018-07-08 20:22
 */
public class Exceptions {

    public static RuntimeException unchecked(Throwable cause) {
        return cause instanceof RuntimeException ? (RuntimeException)cause : new RuntimeException(cause);
    }
}
