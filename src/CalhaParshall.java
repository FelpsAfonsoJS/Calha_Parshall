public class CalhaParshall {

    double wMn;
    String polegadas;
    double vazaoMinima;
    double vazaoMaxima;
    double K;
    double N;

    public CalhaParshall(
            double wMn,
            String polegadas,
            double vazaoMinima,
            double vazaoMaxima,
            double K,
            double N)
    {
        this.wMn = wMn;
        this.polegadas = polegadas;
        this.vazaoMinima = vazaoMinima;
        this.vazaoMaxima = vazaoMaxima;
        this.K = K;
        this.N = N;
    }

}
