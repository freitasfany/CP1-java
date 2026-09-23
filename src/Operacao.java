public enum Operacao {

        SOMA("+", "Soma") {
            public float calcular(float a, float b) { return a + b; }
        },
        SUBTRACAO("-", "Subtração") {
            public float calcular(float a, float b) { return a - b; }
        },
        MULTIPLICACAO("*", "Multiplicação") {
            public float calcular(float a, float b) { return a * b; }
        },
        DIVISAO("/", "Divisão") {
            public float calcular(float a, float b) {
                if (b == 0) throw new ArithmeticException("Divisão por zero é inválida");
                return a / b;
            }
        },
        POTENCIACAO("pow", "Elevação") {
            public float calcular(float a, float b) { return (float) Math.pow(a, b); }
        },

        // Novas operações — adicionar uma constante aqui não exige tocar em mais nada
        RESTO("%", "Resto da divisão") {
            public float calcular(float a, float b) {
                if (b == 0) throw new ArithmeticException("Módulo por zero é inválido");
                return a % b;
            }
        },
        MAXIMO("max", "Máximo") {
            public float calcular(float a, float b) { return Math.max(a, b); }
        },
        MINIMO("min", "Mínimo") {
            public float calcular(float a, float b) { return Math.min(a, b); }
        };

        private final String simbolo;
        private final String descricao;

        Operacao(String simbolo, String descricao) {
            this.simbolo = simbolo;
            this.descricao = descricao;
        }

        public abstract float calcular(float a, float b);

        public String simbolo() { return simbolo; }
        public String descricao() { return descricao; }

        public static Operacao porSimbolo(String simbolo) {
            for (var op : values())
                if (op.simbolo.equals(simbolo))
                    return op;
            return null;
        }

        public static String montarMenu() {
            var sb = new StringBuilder("Digite a operação desejada:\n");
            for (var op : values())
                sb.append(op.simbolo).append(" | ").append(op.descricao).append("\n");
            return sb.toString();
        }
}
