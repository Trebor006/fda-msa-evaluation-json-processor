package com.pichincha.evaluation.fdamsaevaluationjsonprocessor.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.ProcessorService;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.util.MockUtils;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ProcessorControllerTest {
  public static final String PATH = "/processor/save";
  @Autowired private MockMvc mockMvc;

  @MockBean private ProcessorService processorService;

  @Test
  @DisplayName("POST /processor/save - Success")
  void givenAValidDataShouldSaveSu() throws Exception {

    when(processorService.saveDataStructure(MockUtils.POST_REQUEST_DTO))
        .thenReturn(Optional.of(MockUtils.POST_RESPONSE_DTO));

    mockMvc
        .perform(
            post(PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(MockUtils.POST_REQUEST_DTO)))
        .andExpect(status().isOk())
        .andReturn();

    verify(processorService, times(1)).saveDataStructure(MockUtils.POST_REQUEST_DTO);
  }
}
