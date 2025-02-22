package com.cliente.hibernategeneric;

import com.cliente.dao.generic.IGenericDaoH;
import com.cliente.domain.VendaH;
import com.cliente.exceptions.DAOException;
import com.cliente.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDaoH extends IGenericDaoH<VendaH, Long> {
    public void finalizarVenda(VendaH venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(VendaH venda) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Usando este método para evitar a exception
     * org.hibernate.LazyInitializationException
     * Ele busca todos os dados de objetos que tenham colletion pois a mesma por
     * default é lazy
     * Mas você pode configurar a propriedade da collection como fetch =
     * FetchType.EAGER na anotação @OneToMany e usar o consultar genérico normal
     * 
     * OBS: Não é uma boa prática utiliar FetchType.EAGER pois ele sempre irá trazer
     * todos os objetos da collection
     * mesmo sem precisar utilizar.
     * 
     * 
     * @see VendaH produtos
     * 
     * @param id
     * @return
     */
    public VendaH consultarComCollection(Long id);
}
