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


public class Opis_JM implements SQLData{
    
    String modelJM;
    String karakteristike;
    String sql_type;

 
    public String getModelJM() {
        return modelJM;
    }

    public void setModelJM(String modelJM) {
        this.modelJM = modelJM;
    }

    public String getKarakteristike() {
        return karakteristike;
    }

    public void setKarakteristike(String karakteristike) {
        this.karakteristike = karakteristike;
    }

    public String getSql_type() {
        return sql_type;
    }

    public void setSql_type(String sql_type) {
        this.sql_type = sql_type;
    }
     public Opis_JM() {
        sql_type = "SYSTEM.OPIS_JM";
    }
    
    
   
    @Override
    public String getSQLTypeName() throws SQLException {
        return sql_type;
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
         sql_type = typeName;
        modelJM= stream.readString();
          karakteristike = stream.readString();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeString(modelJM);
        stream.writeString(karakteristike);
    }

}
