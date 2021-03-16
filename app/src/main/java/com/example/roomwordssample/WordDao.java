package com.example.roomwordssample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    /*hay que poner esto ya que no existe una anotación para borrar todos
    Las anotaciones existentes son @Delete,@Update,@Insert
     */
    @Query("DELETE FROM word_table")
    void deleteAll();

    //el orden de retorno no está garantizado y por eso lo ordenamos (por conveniencia)
    /*LiveData es una libreria que ayuda a tu aplicación a responder a cambios en los datos
    si usas como tipo de retorno un LiveData en la descripción del método, Room genera todo el
    codigo necesario para actualizar el LiveData cuando la BD se actualice
     */
    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();

    @Query("SELECT * from word_table LIMIT 1")
    Word[] getAnyWord();

    @Delete
    void deleteWord(Word word);
}
