package functions;

@FunctionalInterface
public interface CoolConsumer<T> {
    void accept(T t);
}
