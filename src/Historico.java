import java.util.ArrayList;
import java.util.List;

public class Historico {
    private final List<String> registros = new ArrayList<>();

    public void registrar(float a, Operacao operacao, float b, float resultado) {
        registros.add(a + " " + operacao.simbolo() + " " + b + " = " + formatar(resultado));
    }

    public void mostrar() {
        IO.println("Histórico: ");
        for (var linha : registros)
            IO.println(linha);
    }

    public static String formatar(float valor) {
        return (valor == Math.round(valor)) ? String.valueOf(Math.round(valor)) : String.valueOf(valor);
    }
}