import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bank {

    public static void main(String[] args) {
        String nombre = "Tony Stark";
        String tipoDeCuenta = "Corriente";
        double saldoInicial = 1599.99;

        // Verificación de exclusividad
        if (!nombre.equals("Tony Stark")) {
            JOptionPane.showMessageDialog(null, "Acceso denegado. Esta aplicación es exclusiva para Tony Stark.");
            System.exit(0);
        }

        // Crear la ventana principal
        JFrame ventana = new JFrame("Banco Exclusivo para Tony Stark");
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        // Crear etiqueta de bienvenida
        JLabel etiqueta = new JLabel("Bienvenido, " + nombre);
        etiqueta.setBounds(120, 20, 200, 30);
        ventana.add(etiqueta);

        // Botón "Consultar saldo"
        JButton consultarSaldoBtn = new JButton("Consultar saldo");
        consultarSaldoBtn.setBounds(120, 70, 150, 30);
        ventana.add(consultarSaldoBtn);

        // Botón "Retirar"
        JButton retirarBtn = new JButton("Retirar");
        retirarBtn.setBounds(120, 110, 150, 30);
        ventana.add(retirarBtn);

        // Botón "Depositar"
        JButton depositarBtn = new JButton("Depositar");
        depositarBtn.setBounds(120, 150, 150, 30);
        ventana.add(depositarBtn);

        // Variable saldo
        final double[] saldo = {saldoInicial}; // Array para usar dentro de las funciones

        // Acción del botón "Consultar saldo"
        consultarSaldoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Saldo disponible: $" + saldo[0]);
            }
        });

        // Acción del botón "Retirar"
        retirarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingrese el monto a retirar:");
                if (input != null) {
                    double valorARetirar = Double.parseDouble(input);
                    if (valorARetirar > saldo[0]) {
                        JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                    } else {
                        saldo[0] -= valorARetirar;
                        JOptionPane.showMessageDialog(null, "Retiro exitoso. Saldo actualizado: $" + saldo[0]);
                    }
                }
            }
        });

        // Acción del botón "Depositar"
        depositarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingrese el monto a depositar:");
                if (input != null) {
                    double valorADepositar = Double.parseDouble(input);
                    saldo[0] += valorADepositar;
                    JOptionPane.showMessageDialog(null, "Depósito exitoso. Saldo actualizado: $" + saldo[0]);
                }
            }
        });

        // Hacer visible la ventana
        ventana.setVisible(true);
    }
}
