public class Calculadora {

        private final Historico historico = new Historico();

        public void processar(float num1, float num2, String simbolo) {
            var operacao = Operacao.porSimbolo(simbolo);
            if (operacao == null) {
                IO.println("Operação inválida");
                return;
            }
            try {
                var resultado = operacao.calcular(num1, num2);
                IO.println(Historico.formatar(resultado));
                historico.registrar(num1, operacao, num2, resultado);
            } catch (ArithmeticException e) {
                IO.println(e.getMessage());
            }
        }

        public void mostrarHistorico() {
            historico.mostrar();
        }
}
