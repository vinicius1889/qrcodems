package br.com.icarros;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QrCodeMsApplicationTests {

	@Autowired private TestRestTemplate rest;


	@Test
	public void contextLoads() throws IOException {
		String retorno = rest.getForObject("/base64/{id}", String.class, "123");
		Files.write(Paths.get("./qrcode.txt"),retorno.getBytes(StandardCharsets.UTF_8));
		assertNotNull(retorno);
	}

}
