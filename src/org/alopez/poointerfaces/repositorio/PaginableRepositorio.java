package org.alopez.poointerfaces.repositorio;

import org.alopez.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {

    List<Cliente> listar(int desde, int hasta); //Rango desde donde se quiere paginar, hasta donde

}