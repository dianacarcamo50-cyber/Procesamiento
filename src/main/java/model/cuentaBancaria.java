/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import Exceptions.SaldoInsuficienteException; 
/**
 *
 * @author Garme
 */
public class cuentaBancaria {
    private double saldo;
    public cuentaBancaria(double saldoInicial){
        this.saldo = saldoInicial; 
    }
    
    public synchronized void retirar(double monto) throws SaldoInsuficienteException {
    if (monto > saldo) {
        throw new SaldoInsuficienteException("Fondo insuficiente para el retiro ", monto - saldo); // Aquí va sin 's' porque está lanzando el objeto
    }
    saldo -= monto;
}
    
    public double getSaldo(){return saldo;}
}

