package JavaGeneric;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: minmengtao
 * @date: 2021/5/28
 */
public class GenericTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();

        list.add(12);
        //直接添加会报错
        //list.add("a");
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        //但是通过反射添加，是可以的
        add.invoke(list, "kl");
        System.out.println("泛型实现方法" + list);

        Generic<Integer> generic = new Generic(123456);
        System.out.println("泛型类实现方法" + generic.getKey());

        GeneratorImpl generatorImpl = new GeneratorImpl();
        System.out.println("泛型接口实现方法" + generatorImpl.method());

        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.print("泛型方法");
        printArray(intArray);
    }

    public static <E> void printArray(E[] inputArray) {
        for(E e : inputArray) {
            System.out.printf("%s ", e);
        }
        System.out.println();
    }
}

/**
 * 泛型类
 * 此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
 * 在实例化泛型类时，必须指定T的具体类型
 * @param <M>
 */
class Generic<M> {
    private M key;

    public Generic(M key) {
        this.key = key;
    }

    public M getKey() {
        return key;
    }
}

/**
 * 实现泛型接口
 * @param <T>
 */
interface Generator<T> {
    public T method();
}//实现泛型接口,不指定类型，也可以指定类型
//class GeneratorImpl<T> implements Generator<T>{
class GeneratorImpl<T> implements Generator<String> {
    @Override
    public String method() {
        return "Hello World!";
    }
}