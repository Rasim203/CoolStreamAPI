package functions;

@FunctionalInterface
public interface CoolFunction<T, R> {
    R apply(T t);
}
