package persistence;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {

	public void grava(String arquivo, String conteudo) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(arquivo, true));
		buffWrite.append(conteudo);
		buffWrite.newLine();
		buffWrite.close();
	}

}
