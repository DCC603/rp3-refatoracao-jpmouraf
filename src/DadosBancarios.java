public class DadosBancarios {
    private int numeroAgencia;
    private int numeroConta;
    private String gerente;

    public DadosBancarios(int numeroAgencia, int numeroConta, String gerente) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.gerente = gerente;
    }

    public String getDadosFormatados() {
        return String.format("Ag.: %d\nConta: %d\nGerente: %s",
                this.numeroAgencia, this.numeroConta, this.gerente);
    }
}