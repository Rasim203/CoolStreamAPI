package functions;

@FunctionalInterface
public interface CoolPredicate<T> {
    boolean test(T t);
}
