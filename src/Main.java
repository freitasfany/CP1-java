void main(){

        var calculadora = new Calculadora();

        while (true) {
            IO.println("""
                Calculadora v2.0, digite .exit para sair, digite -h para ver o histórico ou enter para continuar.
                """);
            var comando = IO.readln();

            switch (comando) {
                case ".exit" -> System.exit(0);
                case "-h" -> calculadora.mostrarHistorico();
                case "" -> {
                    IO.println("Digite o primeiro número:");
                    var num1 = Float.parseFloat(IO.readln());

                    IO.println("Digite o segundo número:");
                    var num2 = Float.parseFloat(IO.readln());

                    IO.println(Operacao.montarMenu());
                    var simbolo = IO.readln();

                    calculadora.processar(num1, num2, simbolo);
                }
                default -> IO.println("Comando inválido");
            }
        }


}