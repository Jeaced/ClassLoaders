import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MyLoader loader = new MyLoader();
        Object executor = null;
        try {
            executor = loader.loadClass("BlackBoxParser").newInstance();
        } catch (IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return method.invoke(executor, args);
    }
}