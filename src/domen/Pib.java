/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;


public class Pib implements SQLData{
    
    public int pibb;
    
    String sql_type;

    public int getVrednost() {
        return pibb;
    }

    public void setVrednost(int vrednost) {
        this.pibb = vrednost;
    }

    public Pib() {
           sql_type = "SYSTEM.PIB";
    }

    
    
   

    
    @Override
    public String getSQLTypeName() throws SQLException {
        return sql_type;
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        sql_type = typeName;
        pibb = stream.readInt();
       
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
       stream.writeInt(pibb);
    }
    @Override
    public String toString() {
        return pibb +"";
    }
}
