package es.iesra.datos

import es.iesra.dominio.ReservaVuelo
import java.io.File

class ReservaVueloDao : IReservaDao<ReservaVuelo> {

    private val file = File("data/vuelos.txt")

    init {
        if (!file.exists()) {
            file.parentFile.mkdirs()
            file.createNewFile()
        }
    }

    override fun agregar(reserva: ReservaVuelo): Boolean {
        val linea = "${reserva.descripcion};${reserva.origen};${reserva.destino};${reserva.horaVuelo}\n"
        file.appendText(linea)
        return true
    }

    override fun obtenerTodas(): List<ReservaVuelo> {
        return file.readLines().mapNotNull {
            val partes = it.split(";")
            try {
                ReservaVuelo.creaInstancia(
                    partes[0],
                    partes[1],
                    partes[2],
                    partes[3]
                )
            } catch (e: Exception) {
                null
            }
        }
    }

    override fun obtenerPorId(id: Int): ReservaVuelo? {
        return obtenerTodas().find { it.id == id }
    }

    override fun actualizar(reserva: ReservaVuelo): Boolean {
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

    private fun sobrescribir(lista: List<ReservaVuelo>) {
        file.writeText("")
        lista.forEach { agregar(it) }
    }
}