package Serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author: minmengtao
 * @date: 2021/5/29
 */
public class Test2ObjectStream {
    /**
     * 从f5文件读取反序列化数据
     * 反序列化恢复学生对象
     *
     * OIS--FIS--f5
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("student"));
        Student s = (Student)in.readObject();
        System.out.println(s);
        in.close();
    }
}
