package p5_lambda_scopes;

@FunctionalInterface
public interface Converter<F,T> {
    T convert(F from);
}
