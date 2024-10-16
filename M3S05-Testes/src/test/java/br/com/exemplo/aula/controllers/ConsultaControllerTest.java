package br.com.exemplo.aula.controllers;

import br.com.exemplo.aula.entities.Consulta;
import br.com.exemplo.aula.entities.Nutricionista;
import br.com.exemplo.aula.entities.Paciente;
import br.com.exemplo.aula.repositories.ConsultaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("Test")
class ConsultaControllerTest {
    @Autowired
    MockMvc mvc;
    @MockBean
    ConsultaRepository repository;
    Consulta consulta;

    @BeforeEach
    void setUp() {
        consulta = new Consulta(1L, new Nutricionista(), new Paciente(), LocalDate.now(), "observacoes");
    }

    @Test
    void buscarConsultaPorId() throws Exception {
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(consulta));
        mvc.perform(get("/consultas/1")).andExpect(status().isOk()).andExpect(jsonPath("$.id").value(consulta.getId())).andExpect(jsonPath("$.observacoes").value(consulta.getObservacoes()));
        verify(repository).findById(anyLong());
    }

    @Test
    void deletarConsultaPorId() throws Exception {
        doNothing().when(repository).deleteById(anyLong());
        mvc.perform(delete("/consultas/1")).andExpect(status().isNoContent());
        verify(repository).deleteById(consulta.getId());
    }

}