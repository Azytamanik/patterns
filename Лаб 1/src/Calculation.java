public interface Calculation<T> {
    T getResult();
    void setResult(T result);

    T plus(T first, T second);
    T minus(T first, T second);
    T multiply(T first, T second);
    T divide(T first, T second);
    T calculate(T first, T second, char action) throws Exception;

    boolean checkAction(char action);

    @Override
    String toString();
}
