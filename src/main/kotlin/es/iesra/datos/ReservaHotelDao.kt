package es.iesra.datos

import es.iesra.dominio.*
import java.io.File

class ReservaHotelDao : IReservaHotelDao {

    private val file = File("Guardado/hoteles.txt")

    init {
        if (!file.exists()) {
            file.parentFile.mkdirs()
            file.createNewFile()
        }
    }

    override fun agregar(reserva: Reserva): Boolean {
        if (reserva !is ReservaHotel) return false

        val linea = "${reserva.descripcion};${reserva.ubicacion};${reserva.numeroNoches}\n"
        file.appendText(linea)
        return true
    }

    override fun obtenerTodas(): List<Reserva> {
        return file.readLines().mapNotNull {
            val partes = it.split(";")
            try {
                ReservaHotel.creaInstancia(
                    partes[0],
                    partes[1],
                    partes[2].toInt()
                )
            } catch (e: Exception) {
                null
            }
        }
    }

    override fun obtenerPorId(id: Int): Reserva? {
        return obtenerTodas().find { it.id == id }
    }

    override fun actualizar(reserva: Reserva): Boolean {
        if (reserva !is ReservaHotel) return false

        val lista = obtenerTodas().toMutableList()
        val index = lista.indexOfFirst { it.id == reserva.id }

        if (index != -1) {
            lista[index] = reserva
            sobrescribir(lista)
            return true
        }
        return false
    }

    override fun eliminar(id: Int): Boolean {
        val lista = obtenerTodas().filter { it.id != id }
        sobrescribir(lista)
        return true
    }

    private fun sobrescribir(lista: List<Reserva>) {
        file.writeText("")
        lista.forEach { agregar(it) }
    }
}