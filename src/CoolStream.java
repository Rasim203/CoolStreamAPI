import functions.CoolBiFunction;
import functions.CoolConsumer;
import functions.CoolFunction;
import functions.CoolPredicate;

import java.util.*;

public class CoolStream<T> {
    private final List<T> lst;
    private CoolStream() {
        this.lst = new LinkedList<>();
    }
    public CoolStream(Collection<T> c) {
        lst = new LinkedList<>();
        lst.addAll(c);
    }
    public CoolStream<T> filter(CoolPredicate<T> predicate) {
        CoolStream<T> newCoolStream = new CoolStream<>();
        for (T elem: lst) {
            if (predicate.test(elem)) {
                newCoolStream.push(elem);
            }
        }
        return newCoolStream;
    }
    public <R> CoolStream<R> map(CoolFunction<T, R> mapper) {
        CoolStream<R> newCoolStream = new CoolStream<>();
        for (T elem: lst) {
            newCoolStream.push(mapper.apply(elem));
        }
        return newCoolStream;
    }
    public void forEach(CoolConsumer<T> action) {
        for (T elem: lst) {
            action.accept(elem);
        }
    }
    public Optional<T> reduce(CoolBiFunction<T, T, T> accumulator) {
        boolean foundAny = false;
        T result = null;
        for (T elem: lst) {
            if (!foundAny) {
                foundAny = true;
                result = elem;
            } else {
                result = accumulator.apply(result, elem);
            }
        }
        return foundAny ? Optional.of(result) : Optional.empty();
    }
    public CoolStream<T> distinct() {
        Set<T> uniqueElements = new HashSet<>(lst);
        return new CoolStream<>(uniqueElements);
    }
    public long count() {
        return lst.size();
    }
    public List<T> toList() {
        return lst;
    }
    private void push(T elem) {
        lst.add(elem);
    }
}
