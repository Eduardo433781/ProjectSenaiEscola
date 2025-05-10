package com.coerse.senai.Controller;

import com.coerse.senai.Model.Aluno;
import com.coerse.senai.Service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> listaDeAlunos() {
        return alunoService.buscarAlunos();
    }

    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoService.salvarAluno(aluno);
    }

    @GetMapping("/id")
    public Aluno buscarAlunoPorId(@PathVariable Long id) {
        return alunoService.buscarAluno(id);
    }

    @DeleteMapping("/id")
    public void deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);
    }

    @PutMapping
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        Aluno verificarAluno = alunoService.buscarAluno(id);
        if (verificarAluno == null) return null;
        verificarAluno.setNomeAluno(alunoAtualizado.getNomeAluno());
        verificarAluno.setEmailAluno(alunoAtualizado.getEmailAluno());
        verificarAluno.setTelefoneAluno(alunoAtualizado.getTelefoneAluno());
        return alunoService.salvarAluno(alunoAtualizado);
        }
    }