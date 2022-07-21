package org.alopez.poointerfaces.repositorio;

import org.alopez.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio implements OrdenablePaginableCrudRepositorio{
//public class ClienteListRepositorio implements CrudRepositorio, OrdenableRepositorio,
//        PaginableRepositorio{ //Clase que implementa multiples interfaces,
    //con cada nueva implementación de interfaz, se deben implementar los metodos de dicha interfaz

    private List<Cliente> dataSource;

    public ClienteListRepositorio() { //Generamos un constructor vacio e inicializamos el ArrayList

        this.dataSource = new ArrayList<>();

    }

    @Override
    public List<Cliente> listar() { //Método de la interfaz CrudRepositorio
        return dataSource; //Retorna la lista
    }

    @Override
    public Cliente porId(Integer id) { //Método de la interfaz CrudRepositorio
        Cliente resultado = null; //Cuando se encuentre el cliente, se guarda en esta variable
        for (Cliente cli: dataSource){ //Iteramos con un for y busca cliente por cliente si coincide con el id que se pasa por argumento
            if (cli.getId().equals(id)){ //Si el id del cliente es igual al id que se pasa por argumento
                resultado=cli; //Si son iguales, resultado es igual a cli
                break; //Salimos del for
            }
        }
        return resultado; //Se retorna el cliente encontrado
    }

    @Override
    public void crear(Cliente cliente) { //Método de la interfaz CrudRepositorio
        this.dataSource.add(cliente); //Agregamos un cliente
    }

    @Override
    public void editar(Cliente cliente) { //Método de la interfaz CrudRepositorio
        Cliente c = this.porId(cliente.getId()); //Obtenemos el cliente que se encuentra en la lista
        //c los buscamos usando el metodo porId, el cual viene en el onjeto cliente
        c.setNombre(cliente.getNombre()); //Modificamos los datos con el nombre del cliente que se recibe por argumento
        c.setApellido(cliente.getApellido());
    }

    @Override
    public void eliminar(Integer id) { //Método de la interfaz CrudRepositorio
        this.dataSource.remove(this.porId(id)); //this.porId(id) busca el cliente por id con el id que se recibe por argumente
        //this.dataSource.remove() removemos el objeto del ArrayList
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) { //Método de la interfaz OrdenableRepositorio
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort(new Comparator<Cliente>() { //Implementamos la interfaz Comparator
            @Override
            public int compare(Cliente a, Cliente b) { //Compara los objetos
                int resultado = 0; //Retorna un entero que corresponde al orden de la tabla Unicode
                if (dir == Direccion.ASC){ //Si dir es igual a direccion ascendente
                    switch (campo){ //Inicializamos un switch que recibe el campo
                        case "id" -> //Para campo id, compara id de a con id de b
                                resultado = a.getId().compareTo(b.getId());
                        case "nombre" -> //Para campo nombre
                                resultado = a.getNombre().compareTo(b.getNombre());
                        case "apellido" -> //Para campo apellido
                                resultado = a.getApellido().compareTo(b.getApellido());
                    }
                }else if(dir == Direccion.DESC){ //Si dir es igual a direccion descendente
                    switch (campo){
                        case "id" -> //Para campo id, compara b con a
                                resultado = b.getId().compareTo(a.getId());
                        case "nombre" ->
                                resultado = b.getNombre().compareTo(a.getNombre());
                        case "apellido" ->
                                resultado = b.getApellido().compareTo(a.getApellido());
                    }
                }
                return resultado;
            }
        }); //Cualquier implementación de un List tiene el metodo sort, recibe la implementacion de una
        //interfaz funcional "Comparator" podemos comparar y ordenar cualquier tipo de objeto
        return listaOrdenada; //Retornamos la lista
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) { //Método de la interfaz PaginableRepositorio
        return dataSource.subList(desde, hasta); //Sublist es un subconjunto de la lista
    }

    @Override
    public int total() {
        return this.dataSource.size(); //Nos genera un contador de registros
    }
}