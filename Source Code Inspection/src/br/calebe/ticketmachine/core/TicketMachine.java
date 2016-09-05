package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.ArrayList;

/**
 *
 * @author Calebe de Paula Bianchini
 */

public class TicketMachine {

    protected double valorTicket;
    protected double saldo;
    protected ArrayList<PapelMoeda> notas_e_moedas;

    public TicketMachine(double valor_do_ticket) {
        this.valorTicket    = valor_do_ticket;
        this.saldo          = 0;
        this.notas_e_moedas = new ArrayList<>();
        this.notas_e_moedas.add(new PapelMoeda(100.00, 0));
        this.notas_e_moedas.add(new PapelMoeda( 50.00, 0));
        this.notas_e_moedas.add(new PapelMoeda( 20.00, 0));
        this.notas_e_moedas.add(new PapelMoeda( 10.00, 0));
        this.notas_e_moedas.add(new PapelMoeda(  5.00, 0));
        this.notas_e_moedas.add(new PapelMoeda(  2.00, 0));
        this.notas_e_moedas.add(new PapelMoeda(  1.00, 0));
        this.notas_e_moedas.add(new PapelMoeda(  0.50, 0));
        this.notas_e_moedas.add(new PapelMoeda(  0.25, 0));
        this.notas_e_moedas.add(new PapelMoeda(  0.10, 0));
        this.notas_e_moedas.add(new PapelMoeda(  0.05, 0));
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        System.out.println("Aguarda alguns instantes...");
        for (PapelMoeda dinheiro : this.notas_e_moedas) {
            if (dinheiro.getQuantidade() == quantia) {
                dinheiro.addQuantidade();
                this.saldo += quantia;
                return;
            }
        }
        throw new PapelMoedaInvalidaException();
    }

    public double getSaldo() {
        return saldo;
    }

    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < this.valorTicket) {
            throw new SaldoInsuficienteException();
        }
        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        System.out.println(result);
        return result;
    }
}