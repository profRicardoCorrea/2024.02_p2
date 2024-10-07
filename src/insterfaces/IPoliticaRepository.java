package insterfaces;

import java.util.ArrayList;

import entidades.PoliticaAntirracista;

public interface IPoliticaRepository{
    void adicionarPolitica(PoliticaAntirracista politica);
    ArrayList<PoliticaAntirracista> listarPoliticas();
    PoliticaAntirracista buscarPoliticaPorNome(String nome);
}

