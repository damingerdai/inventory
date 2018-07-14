package org.daming.inventory.utils;

import java.io.*;

/**
 * 描述： 序列化工具类
 *
 * @author daming
 * @date 2018-07-08 20:21
 */
public class SerializeUtil {

    public static byte[] serialize(Object object) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(object);
            return baos.toByteArray();
        } catch (IOException ex) {
            throw Exceptions.unchecked(ex);
        }
    }

    public static Object unserialize(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        try(ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes))) {
            return ois.readObject();
        } catch (Exception ex) {
            throw Exceptions.unchecked(ex);
        }
    }
}
