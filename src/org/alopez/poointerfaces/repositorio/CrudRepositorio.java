package org.alopez.poointerfaces.repositorio;

import org.alopez.poointerfaces.modelo.Cliente;

import java.util.List;

public interface CrudRepositorio {

    List<Cliente> listar(); //Obtenemos todos los clientes //Esta interfaz se puede implementar con base de datos,
    //api rest, un arreglo, un array list, incluso en un xml

    Cliente porId(Integer id); //Metodo para obtener el cliente por id

    void crear(Cliente cliente); //Crea un cliente en el repositorio, se crea un cliente desde cero
    void editar(Cliente cliente); //Edita un cliente ya existente
    void eliminar(Integer id); //Elimina un cliente por Id

}