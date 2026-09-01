import java.awt.BorderLayout
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import javax.swing.*
import kotlin.concurrent.thread

fun main() {
    SwingUtilities.invokeLater {
        val frame = JFrame("HTTP GET Demo")
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.setSize(700, 500)

        val urlField = JTextField("https://httpbin.org/get")
        val fetchButton = JButton("Fetch")
        val topPanel = JPanel(BorderLayout())
        topPanel.add(urlField, BorderLayout.CENTER)
        topPanel.add(fetchButton, BorderLayout.EAST)

        val textArea = JTextArea()
        textArea.isEditable = false
        val scroll = JScrollPane(textArea)

        frame.add(topPanel, BorderLayout.NORTH)
        frame.add(scroll, BorderLayout.CENTER)

        val client = HttpClient.newBuilder().build()

        fetchButton.addActionListener {
            val url = urlField.text.trim()
            textArea.text = "Loading..."

            thread {
                try {
                    val request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .GET()
                        .build()

                    val response = client.send(request, HttpResponse.BodyHandlers.ofString())

                    SwingUtilities.invokeLater {
                        textArea.text = "Status: ${response.statusCode()}\n\n${response.body()}"
                    }
                } catch (e: Exception) {
                    SwingUtilities.invokeLater {
                        textArea.text = "Error: ${e.message}"
                    }
                }
            }
        }

        frame.isVisible = true
    }
}
