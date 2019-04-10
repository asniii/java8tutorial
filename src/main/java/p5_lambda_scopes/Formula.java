package p5_lambda_scopes;

public interface Formula {

    double calculate(int a);

    default double sqrt(int a){
        return Math.sqrt(a);
    }
}
