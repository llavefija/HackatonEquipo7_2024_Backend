package com.hackathon07.myApi;

import com.hackathon07.myApi.controllers.Controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(Controller.class)
class Hackathon07ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testGetPuntosTuristicos() throws Exception {
		mockMvc.perform(get("/ubications"))
				.andExpect(status().isOk())   // Verificamos que el estado HTTP es 200
				.andExpect(jsonPath("$.length()").value(9));  // Verificamos que el JSON tiene 9 elementos
		// 9 elementos correspondientes a la tabla ubications
	}

	@Test
	void testGetNoises() throws Exception {
		mockMvc.perform(get("/noises"))
				.andExpect(status().isOk())   // Verificamos que el estado HTTP es 200
				.andExpect(jsonPath("$.length()").value(30000));  // Verificamos que el JSON tiene 30000 elementos
		// 30000 elementos correspondientes a la tabla de noises
	}

	@Test
	void testGetUbicationsPorID() throws Exception {
		mockMvc.perform(get("/ubicationsAllInfo/dbcolorsByUbication/2023-01-02/37"))
				.andExpect(status().isOk())   // Verificamos que el estado HTTP es 200
				.andExpect(jsonPath("$.length()").value(24));  // Verificamos que el JSON tiene 24 elementos
		// 24 elementos correspondientes a las 24 horas del dia (Sonido en el lugar a lo largo del dia)
	}

	@Test
	void testGetUbicationsPorFecha() throws Exception {
		mockMvc.perform(get("/ubicationsAllInfo/dbcolors/2023-01-01/4"))
				.andExpect(status().isOk())   // Verificamos que el estado HTTP es 200
				.andExpect(jsonPath("$.length()").value(9));  // Verificamos que el JSON tiene 9 elementos
		// 9 elementos correspondientes a las 9 ubicaciones (Sonido en los diferentes lugares ese dia/hora).
	}
}
