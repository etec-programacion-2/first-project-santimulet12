package org.example

import javax.swing.*
import java.awt.*
import java.awt.event.ActionEvent

fun main() {
    // Crear y configurar la ventana principal
    val frame = JFrame("Mi Aplicación Simple")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.size = Dimension(400, 300)
    frame.setLocationRelativeTo(null) // Centrar en pantalla

    // Crear panel principal con layout
    val panel = JPanel()
    panel.layout = BorderLayout(15, 10)
    panel.border = BorderFactory.createEmptyBorder(20, 20, 20, 20)

    // Panel para la entrada de texto
    val inputPanel = JPanel()
    inputPanel.layout = BorderLayout(5, 5)

    val etiqueta = JLabel("Escribe tu nombre:")
    val campoTexto = JTextField(20)

    inputPanel.add(etiqueta, BorderLayout.NORTH)
    inputPanel.add(campoTexto, BorderLayout.CENTER)

    // Panel para botones
    val buttonPanel = JPanel()
    buttonPanel.layout = FlowLayout(FlowLayout.CENTER)

    val botonSaludar = JButton("Saludar")
    val botonLimpiar = JButton("Limpiar")

    buttonPanel.add(botonSaludar)
    buttonPanel.add(botonLimpiar)

    // Área de resultados
    val resultado = JTextArea(5, 20)
    resultado.isEditable = false
    resultado.lineWrap = true
    val scrollPane = JScrollPane(resultado)

    // Añadir los componentes al panel principal
    panel.add(inputPanel, BorderLayout.NORTH)
    panel.add(scrollPane, BorderLayout.CENTER)
    panel.add(buttonPanel, BorderLayout.SOUTH)

    // Configurar acciones para los botones
    botonSaludar.addActionListener { _: ActionEvent ->
        val nombre = campoTexto.text
        if (nombre.isNotBlank()) {
            resultado.text = "¡Hola, $nombre! Bienvenido/a a mi aplicación."
        } else {
            resultado.text = "Por favor, escribe tu nombre primero."
        }
    }

    botonLimpiar.addActionListener { _: ActionEvent ->
        campoTexto.text = ""
        resultado.text = ""
    }

    // Finalizar la configuración de la ventana
    frame.contentPane = panel
    frame.isVisible = true
}