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
public class ProcesoRetiroHilo implements Runnable {

    private cuentaBancaria cuenta;
    private double monto;
    private ProcesoListener listener;

    public interface ProcesoListener {

        void onInicio();
        void onExito(double nuevoSaldo);
        void onError(String error);

    }

    public ProcesoRetiroHilo(cuentaBancaria cuenta, double monto, ProcesoListener listener) {
        this.cuenta = cuenta;
        this.monto = monto;
        this.listener = listener;
    }

    public void run() {
        listener.onInicio();
        try {
            Thread.sleep(2000);
            cuenta.retirar(monto);
            listener.onExito(cuenta.getSaldo());
        } catch (SaldoInsuficienteException e) {
            listener.onError(e.getMessage() + "Falta $ " + e.getMontoFaltante());
        } catch (InterruptedException e) {
            listener.onError("El Proceso concurrente fue interrumpido");
        }
    }
}
