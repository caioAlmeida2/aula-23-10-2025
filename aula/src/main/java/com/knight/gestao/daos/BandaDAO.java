package com.knight.gestao.daos;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import com.knight.gestao.modelos.*;

public class BandaDAO {
    private static final List<Banda> bandas = new ArrayList<>();
    private static final List<Musico> musicos = new ArrayList<>();
    private static final List<Contrato> contratos = new ArrayList<>();

    static {
        Musico m1 = new Musico(UUID.randomUUID(), "João", "joao@email.com", "63 9 9919-8945",
                "762.367.381-57", 300.0);
        Musico m2 = new Musico(UUID.randomUUID(), "Ana", "ana@email.com", "63 9 9915-2529",
                "439.962.811-70", 400.0);
        musicos.add(m1);
        musicos.add(m2);
        Banda b = new Banda(UUID.randomUUID(), "Metallica", "metallica@email.com", "63 3695-4083",
                "82.938.299/0001-94", "Rock");


        Contrato c1 = new Contrato(UUID.randomUUID(), "Guitarra", LocalDate.now().toString(), b, m1);
        Contrato c2 = new Contrato(UUID.randomUUID(), "Vocal", LocalDate.now().toString(), b, m2);
        contratos.add(c1);
        contratos.add(c2);

        b.setMembros(Arrays.asList(c1, c2));
        bandas.add(b);
    }

    //Banda
    public List<Banda> listarBandas() {
        return bandas;
    }

    public void criarBanda(Banda banda) {
        banda.setId(UUID.randomUUID());
        bandas.add(banda);

        if (banda.getMembros() != null) {
            List<Contrato> membros = banda.getMembros();
            membros.forEach(contrato -> {
                        contrato.setId(UUID.randomUUID());
                        contrato.setBanda(banda);
                        contrato.setDataContrato(LocalDate.now().toString());
                        contratos.add(contrato);
                        if (contrato.getMusico() != null && !musicos.contains(contrato.getMusico())) {
                            Musico m = new Musico(
                                    UUID.randomUUID(),
                                    contrato.getMusico().getNome(),
                                    contrato.getMusico().getEmail(),
                                    contrato.getMusico().getTelefone(),
                                    contrato.getMusico().getCpf(),
                                    contrato.getMusico().getCache()
                            );
                            contrato.setMusico(m);
                            musicos.add(m);
                        }
                    }
            );
        }
    }

    //4.2)Filtro por Genero
    public List<Banda> buscarBandasPorGenero(String genero) {
        return bandas.stream()
                .filter(b -> b.getGeneroMusical().equalsIgnoreCase(genero))
                .collect(Collectors.toList());
    }


    //Músico
    public void criarMusico(Musico musico) {
        musico.setId(UUID.randomUUID());
        musicos.add(musico);
    }

    //4.1)Listar para a segunda classe
    public List<Musico> listarMusicos() {
        return musicos;
    }

    //4.2) Filtro por Instrumento
    public List<Musico> buscarMusicosPorInstrumento(String instrumento) {
        return contratos.stream()
                // 1. Filtra contratos que tenham esse instrumento
                .filter(c -> c.getInstrumentoPrincipal() != null &&
                        c.getInstrumentoPrincipal().equalsIgnoreCase(instrumento))
                .map(Contrato::getMusico)
                .distinct()
                .collect(Collectors.toList());
    }
}