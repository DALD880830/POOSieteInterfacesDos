package org.alopez.poointerfaces.repositorio;

import org.alopez.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio {

    List<Cliente> listar(String campo, Direccion dir); //Sobrecarga de metodo de la interfaz Crud repositorio, pasamos por
    //argumento el nombre del campo por el cual queremos ordenar y la direccion si es ascendente o descendente

}