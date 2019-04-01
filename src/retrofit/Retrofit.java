package retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Retrofit {

    public <T> T build(Class<T> service) {
        return (T)Proxy.newProxyInstance(service.getClassLoader(), new Class[] {service}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, args);
                }
                return parseMethod(method).invoke(args);
            }
        });
    }

    private ServiceMethod parseMethod(Method method) {
        // parse method annotation
        Annotation[] methodAnnotations = method.getAnnotations();
        if (methodAnnotations != null) {
            for (Annotation annotation : methodAnnotations) {
                System.out.println("method annotation:" + annotation.toString());
            }
        }
        return new ServiceMethod(method);
    }



}
