package com.biblioteca;

// faz o import do List para utilização
import java.util.List;
//contrato para utilização 
public interface MembroDAO {

    // pegar um objeto membro e salvar(futuro INSERT)
    void salvar(Membro membro);
    // buscar membro especifico(futuro SELECT)
    Membro buscarPorId(int id);
    // lista os membros cadastrados na biblioteca (futuro SELECT * FROM membros)
    List<Membro> listarTodos();
    // modifica membros
    void atualizar(Membro membro);
    //deleta membros
    void deletar(int id);
    

}
