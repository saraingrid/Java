package com.example.demo.gateways;

import com.example.demo.domains.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, String> {

    Optional<Aluno> findAlunoByApelido(String apelido);

    Page<Aluno> findAlunoByApelido(String apelido, Pageable pageable);

    List<Aluno> findAlunoByMateriaPreferida(String materiaPreferida);

    List<Aluno> findAlunosByDataDaMatriculaGreaterThan(LocalDate data);

    List<Aluno> findAlunoByPessoaPrimeiroNomeContains(String nome);
//    @Query("SELECT * FROM ALUNO WHERE apelido LIKE args[0]")
  //  List<Aluno> findAlunoByQuery(String apelido);

    @Query("Select a from Aluno a where a.materiaPreferida = :name")
    List<Aluno> alunoPorMateriaPreferida (String name);
}



