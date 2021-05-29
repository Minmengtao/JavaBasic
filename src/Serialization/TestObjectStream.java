package Serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 序列化
 * @author: minmengtao
 * @date: 2021/5/29
 */
public class TestObjectStream {
    public static void main(String[] args) throws IOException {
        /**
         * Student对象序列化输出保存到文件
         * OOS--FOS文件输出流--f8
         */
        Student s = new Student(4, "ant", "FM", 8);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student"));
        out.writeObject(s);
        out.close();
        System.out.println("保存完成");
    }
}
