package es.ucm.abd.practica2.dao;

import java.util.ArrayList;
import java.util.List;






import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import es.ucm.abd.practica2.model.Contiene;
import es.ucm.abd.practica2.model.Crucigrama;
import es.ucm.abd.practica2.model.Definicion;

public class CrosswordDAO implements AbstractCrosswordDAO<Crucigrama, Definicion>{

	private SessionFactory SF;
	

	public CrosswordDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setSessionFactory(SessionFactory f) {
		// TODO Auto-generated method stub
		SF = f;
	}

	@Override
	public int insertCrossword(Crucigrama crossword) {
		Session session = SF.openSession();
		Transaction tr = session.beginTransaction();
		session.save(crossword);
		tr.commit();
		return crossword.getId();
	}

	@Override
	public void insertWord(Definicion word) {
		Session session = SF.openSession();
		Transaction tr = session.beginTransaction();
		session.save(word);
		tr.commit();
		
	}

	@Override
	public Crucigrama findCrosswordById(int id) {
		Crucigrama result;
		Session session = SF.openSession();
		Query query = session.createQuery("FROM Crucigrama AS a WHERE a.id = :numero");
		query.setInteger("numero", id);
		result = (Crucigrama) query.uniqueResult();
		return result;
	}

	@Override
	public List<Object[]> getCrosswordData(String str) {
		// TODO Auto-generated method stub
		List <Object[]> result = new ArrayList<Object[]>();
		Session session = SF.openSession();
		Query query = session.createQuery("FROM Crucigrama AS a WHERE a.titulo LIKE :nombre");
		query.setString("nombre","%"+str+"%");
		
		@SuppressWarnings("unchecked")
		List<Crucigrama> crucigramas = (List<Crucigrama>) query.list();
		
		for(int i=0;i<crucigramas.size();i++){
			Object[] crucigrama = new Object[4];
			crucigrama[0] = crucigramas.get(i).getId();
			crucigrama[1] = crucigramas.get(i).getTitulo();
			crucigrama[2] = crucigramas.get(i).getFecha();
			List<Contiene> palabras = crucigramas.get(i).getPalabras();
			crucigrama[3] = (long) palabras.size();
			result.add(crucigrama);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Definicion> findWordsByTags(String[] tags) {
		List <Definicion> result = new ArrayList<Definicion>();
		Session session = SF.openSession();
		String cadenaWhere="";
		Query query;
		if (tags.length==0){
			 query = session.createQuery("FROM Definicion");
			//result = (List<Definicion>) query.list();
		}
		else {
			/*for(int i =0;i<tags.length;i++){
				Query query = session.createQuery("FROM Definicion AS a  WHERE :nombre Member of a.etiquetas");			
				query.setString("nombre",tags[i]);
				result = (List<Definicion>) query.list(); //comparacion de n listas
			}*/
			for(int i =0;i<tags.length;i++){
				if (i==0)
					cadenaWhere += "'"+tags[i]+"'"+" Member of a.etiquetas ";
				else
					cadenaWhere += " AND ('"+tags[i]+"' Member of a.etiquetas ) ";
			}
			query = session.createQuery(" FROM Definicion AS a WHERE "+cadenaWhere);
			
		}
		result = (List<Definicion>) query.list(); //comparacion de n listas
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Definicion> getMatchingWords(CharConstraint[] constraints) {
		List <Definicion> result = new ArrayList<Definicion>();
		Session session = SF.openSession();
		String cadenawhere="";
		Query query ;
		if (constraints.length==0){
			query = session.createQuery("FROM Definicion");
		}
		else{
			for(int i =0;i<constraints.length;i++){
				int pos = constraints[i].getPosition();
				char car = constraints[i].getCharacter();
				if(i==0)
					cadenawhere += "SUBSTRING(a.respuesta ,"+pos +", 1) = '"+car+"'";
				else {
					cadenawhere += " AND (SUBSTRING(a.respuesta ,"+ pos +", 1) = '"+car+"' "
							+ "OR LENGTH(a.respuesta) != "+(pos-1)+")";
				}
			
			}
			query = session.createQuery("FROM Definicion AS a WHERE "+cadenawhere);
			//query.setString("cadena",cadenawhere);
		}
		result = (List<Definicion>) query.list();
		
		return result;
	}

}
