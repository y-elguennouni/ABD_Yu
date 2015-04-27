import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.ucm.abd.practica2.dao.AbstractCrosswordDAO;
import es.ucm.abd.practica2.dao.CrosswordDAO;
import es.ucm.abd.practica2.model.Contiene;
import es.ucm.abd.practica2.model.Crucigrama;
import es.ucm.abd.practica2.model.Definicion;
import es.ucm.abd.practica2.model.Orientation;


public class CrosswordFacade implements AbstractCrosswordFacade<Crucigrama, Definicion>{

	public CrosswordFacade() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Crucigrama newCrossword(String title, Date date) {
		// TODO Auto-generated method stub
		return new Crucigrama(title,date);
	}

	@Override
	public Definicion newDefinition(String sequence, String hint, String[] tags) {
		// TODO Auto-generated method stub
		return new Definicion(hint,sequence,tags);
	}

	@Override
	public void addWordToCrossword(Crucigrama crossword, Definicion word,
			int row, int column, Orientation orientation) {
		crossword.addPalabra(new Contiene(crossword, word, row, column, orientation));
		
	}

	@Override
	public String getAnswerOfWord(Definicion word) {
		// TODO Auto-generated method stub
		return word.getRespuesta();
	}

	@Override
	public String[] getTagsOfWord(Definicion word) {
		// TODO Auto-generated method stub
		return word.getEtiquetas();
	}

	@Override
	public String getHintOfWord(Definicion word) {
		// TODO Auto-generated method stub
		return word.getEnunciado();
	}

	@Override
	public String getTitleOfCrossword(Crucigrama crossword) {
		// TODO Auto-generated method stub
		return crossword.getTitulo();
	}

	@Override
	public Date getDateOfCrossword(Crucigrama crossword) {
		// TODO Auto-generated method stub
		return crossword.getFecha();
	}

	@Override
	public List<Object[]> getWordsOfCrossword(Crucigrama crossword) {
		int i ;
		List <Object[]> result = new ArrayList<Object[]>();
		List<Contiene> palabras = new ArrayList<Contiene>();
		palabras = crossword.getPalabras();
		for(i=0;i<palabras.size();i++){
			Object[] palabra = new Object[4];
			palabra[0] = palabras.get(i).getDefinicion().getRespuesta();
			palabra[1] = palabras.get(i).getX();
			palabra[2] = palabras.get(i).getY();
			palabra[3] = palabras.get(i).getOrientacion();
			result.add(palabra);
		}
		return result;
	}

	@Override
	public AbstractCrosswordDAO<Crucigrama, Definicion> createDAO() {
		// TODO Auto-generated method stub
		return new CrosswordDAO();
	}

}
