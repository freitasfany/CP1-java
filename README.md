# CP1-java

# Calculadora

Uma calculadora de linha de comando em Java, refatorada para não depender mais de um switch gigante toda vez que uma operação nova entra. A lógica de cálculo continua a mesma de sempre — o que mudou foi como o código está organizado.

## Estrutura

```
Main.java         loop principal, leitura de input
Operacao.java     enum com as operações disponíveis
Calculadora.java  executa a operação escolhida e trata erros
Historico.java    guarda e formata o histórico de cálculos
```

Os quatro arquivos precisam estar na mesma pasta (sem `package`) para compilar juntos.

## Como rodar

Direto, deixando o launcher compilar tudo em memória:

```
java Main.java
```

Ou compilando antes, se preferir algo mais previsível (por exemplo pra gravar um vídeo):

```
javac *.java
java Main
```

Requer Java 25 ou superior — é a versão que finalizou o suporte a `void main()` sem classe e à classe `IO` (JEP 512), então não precisa de `--enable-preview`.

## Como cada parte funciona

O `enum Operacao` é quem sabe quais operações existem. Cada constante — `SOMA`, `SUBTRACAO`, `DIVISAO` e assim por diante — carrega seu próprio símbolo, descrição e a lógica de cálculo. É o único lugar do projeto que precisa mudar quando uma operação nova entra.

A `Calculadora` não sabe calcular nada sozinha. Ela recebe o símbolo que o usuário digitou, procura a operação correspondente no enum, roda o cálculo, trata os erros (operação inválida ou divisão por zero) e manda o resultado pro histórico.

O `Historico` também não entende de matemática — só recebe os números prontos e monta a linha de registro.

E o `Main` ficou só com o que realmente é dele: o loop de comandos e a leitura do que o usuário digita. Ele delega tudo o resto.

## O que mudou em relação à versão original

A única parte que foi realmente extraída do fluxo principal foi o switch que calculava as operações. Cada `case` virou uma constante do enum, com o mesmo cálculo de sempre — nada de `a + b`, `a / b` ou `Math.pow` foi reescrito, só mudou de lugar. A checagem de divisão por zero também é a mesma, só que agora vira uma exceção em vez de um `if` que imprime direto.

Duas coisas de fato mudaram no comportamento: o histórico passou a registrar todas as operações (antes só a soma entrava) e o arredondamento na exibição, que antes só valia pra divisão, agora vale pra qualquer resultado.

## Operações

Soma, subtração, multiplicação, divisão e potenciação continuam funcionando como antes. Além delas, foram adicionadas resto (`%`), máximo (`max`) e mínimo (`min`).

Pra adicionar uma nova, basta uma constante em `Operacao.java`:

```java
MEDIA("avg", "Média") {
    public float calcular(float a, float b) { return (a + b) / 2; }
}
```

Ela já aparece no menu, já calcula e já entra no histórico sozinha — nenhuma outra classe precisa mudar.