import java.util.ArrayList;
import java.util.List;

public class Conta {

    private Cliente cliente;
    private DadosBancarios dadosBancarios;

    private double saldo;

    private List<Operacao> operacoes;

    public Conta(String nomeCliente, String cpfCliente, String telefoneCliente, int numAgencia, int numConta, String gerente, double valor) {
        this.cliente = new Cliente(nomeCliente, cpfCliente, telefoneCliente);
        this.dadosBancarios = new DadosBancarios(numAgencia, numConta, gerente);
        
        this.saldo = valor; 

        this.operacoes = new ArrayList<>();
    }

    public Conta() {
        this(null, null, null, 0, 0, null, 0);
    }

    public void depositar(double valor) {
        Operacao op = new Operacao('d', valor);
        this.operacoes.add(op);
        this.saldo += valor;
    }

    public void sacar(double valor) {
        Operacao op = new Operacao('s', valor);
        this.operacoes.add(op);
        this.saldo -= valor;
    }

    public void realizarOperacao(char tipo, int valor) {
        if (tipo == 'd') {
            this.depositar(valor);
        } else if(tipo == 's') {
            this.sacar(valor);
        }
    }

private String getDadosCliente() {
        return this.cliente.getDadosFormatados();
    }

    private String getDadosConta() {
        return String.format("%s\nSaldo: %.2f",
                this.dadosBancarios.getDadosFormatados(), this.saldo);
    }
    
    private String getExtrato() {
        StringBuilder dadosExtrato = new StringBuilder();
        for(Operacao op : this.operacoes) {
            dadosExtrato.append(op.toString()).append("\n");
        }
        return dadosExtrato.toString();
    }

    @Override
    public String toString() {
        return "-----CLIENTE-----\n" +
                this.getDadosCliente() +
                "\n\n" +
                "-----CONTA-----\n" +
                this.getDadosConta() +
                "\n\n" +
                "-----EXTRATO-----\n" +
                this.getExtrato() +
                "\n";
    }
}
