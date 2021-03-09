public abstract class CalculationLogic<T>{
    T result;
    T number;

    public T getResult() { return result; }
    public T getNumber() { return number; }
    public void setResult(T result) { this.result = result; }
    public abstract void setNumber(String result);

    abstract T plus(T first, T second);
    abstract T minus(T first, T second);
    abstract T multiply(T first, T second);
    abstract T divide(T first, T second);

    public boolean checkAction(char action){
        char[] acceptableValues = new char[] {'+', '-', '*', '/', '='};

        boolean checked = false;

        for (char a: acceptableValues) {
            if (a == action){
                checked = true;
                break;
            }
        }
        return checked;
    }

    public T calculate(T first, T second, char action){
        return switch (action) {
            case '+' -> plus(first, second);
            case '-' -> minus(first, second);
            case '*' -> multiply(first, second);
            case '/' -> divide(first, second);
            default -> null;
        };
    }

    @Override
    public abstract String toString();
}
