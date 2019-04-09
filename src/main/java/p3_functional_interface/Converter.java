package p3_functional_interface;

@FunctionalInterface
public interface Converter<F,T> {
    T convert(F from);
}
