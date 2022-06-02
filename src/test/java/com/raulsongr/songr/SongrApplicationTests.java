package com.raulsongr.songr;

import com.raulsongr.controller.AlbumController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class SongrApplicationTests {

	@Autowired
	MockMvc mockMvc;

	//test controller for debugging purposes.
	@Test
	void contextLoads() throws Exception{

		mockMvc.perform(get("/hello"))
				.andDo(print())
				.andExpect(content().string(containsString("Hello World")))
				.andExpect(status().isOk());
	}

	@Test
	public void testOneAlbumInit() throws Exception
	{
		mockMvc.perform(post("/addAlbum")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
				.param("title", "test1")
				.param("artist", "test1")
				.param("songCount", "0")
				.param("length", "0")
				.param("imgurl", "test.jpg")
		)
				.andDo(print())
				.andExpect(redirectedUrl("/"))
				.andExpect(status().isFound());

	}
	@Test
	public void testTwoAlbumInit() throws Exception{
		AlbumController sut = new AlbumController();
		mockMvc.perform(post("addAlbum")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
				//.param(sut)
		)
				.andDo(print())
				.andExpect(redirectedUrl("/"))
				.andExpect(status().isFound());

	}


}
