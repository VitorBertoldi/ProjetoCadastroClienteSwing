package br.com.vbertoldi.dao;

import br.com.vbertoldi.domain.Cliente;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ClienteSetDAO implements IClienteDAO{

    private final Set<Cliente> set;

    public ClienteSetDAO() {
        this.set = new HashSet<>();
    }
    public boolean cadastrar(Cliente cliente) {
        if (this.set != null && this.set.contains(cliente)) {
            return false;
        }
        this.set.add(cliente);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        //Cliente clienteCadastrado = ;
        for (Cliente clienteCadastrado : set) {
            if (cpf.equals(clienteCadastrado.getCpf())){
                this.set.remove(clienteCadastrado);
            }
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        for (Cliente clienteCadastrado : set) {
            if (cliente.getCpf().equals(clienteCadastrado.getCpf())){
                clienteCadastrado.setNome(cliente.getNome());
                clienteCadastrado.setTel(cliente.getTel());
                clienteCadastrado.setNumero(cliente.getNumero());
                clienteCadastrado.setEnd(cliente.getEnd());
                clienteCadastrado.setCidade(cliente.getCidade());
                clienteCadastrado.setEstado(cliente.getEstado());
            }
        }


    }

    @Override
    public Cliente consultar(Long cpf) {
        Cliente cliente = null;
        for (Cliente clienteCadastrado : set) {
            if (cpf.equals(clienteCadastrado.getCpf()))
                cliente = clienteCadastrado;
        }
        return cliente;
    }
    @Override
    public Collection<Cliente> buscarTodos() {
        return this.set;
    }
}


