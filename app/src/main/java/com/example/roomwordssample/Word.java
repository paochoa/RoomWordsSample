package com.example.roomwordssample;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*cada clase entidad representa una entidad en la tabla
por defecto el nombre de la tabla = nombre de la clase*/

@Entity(tableName = "word_table")
public class Word {

    //toda entidad necesita una clave primaria
    @PrimaryKey

    //denota que el parametro/campo/método no puede ser/devolver nulo
    @NonNull

    /*especifica el nombre de la columna de la tabla
    por defecto el nombre de la columna = nombre del atributo
     */
    @ColumnInfo (name = "word")
    private String mWord;

    public Word(@NonNull String word){
        this.mWord = word;
    }

    public String getWord(){
        return this.mWord;
    }
}
