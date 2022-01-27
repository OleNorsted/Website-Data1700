package webprog.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillettRepository {

    @Autowired
    public JdbcTemplate db;

    public void lagre(Billett billett) {
        String sql = "INSERT INTO Billett (fornavN,etternavn,telefonnr,epost,antall,film) VALUES(?,?,?,?,?,?)";
        db.update(sql,billett.getFornavn(),billett.getEtternavn(),billett.getTelefonnr(),
                billett.getEpost(),billett.getAntall(),billett.getFilm());
    }

    public List<Billett> hentAlle() {
        String sql = "SELECT * FROM Billett";
        List<Billett> alleBilletter = db.query(sql,new BeanPropertyRowMapper(Billett.class));
        return alleBilletter;
    }

    public void slettAlle () {
        String sql = "DELETE FROM Billett";
        db.update(sql);
    }
}
