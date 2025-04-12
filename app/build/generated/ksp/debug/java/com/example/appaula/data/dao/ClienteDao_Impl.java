package com.example.appaula.data.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.appaula.data.model.Cliente;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ClienteDao_Impl implements ClienteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Cliente> __insertionAdapterOfCliente;

  private final EntityDeletionOrUpdateAdapter<Cliente> __deletionAdapterOfCliente;

  private final EntityDeletionOrUpdateAdapter<Cliente> __updateAdapterOfCliente;

  public ClienteDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCliente = new EntityInsertionAdapter<Cliente>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR IGNORE INTO `clientes` (`id`,`nome`,`endereco`,`bairro`,`cep`,`cidade`,`estado`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Cliente entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getNome());
        statement.bindString(3, entity.getEndereco());
        statement.bindString(4, entity.getBairro());
        statement.bindString(5, entity.getCep());
        statement.bindString(6, entity.getCidade());
        statement.bindString(7, entity.getEstado());
      }
    };
    this.__deletionAdapterOfCliente = new EntityDeletionOrUpdateAdapter<Cliente>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `clientes` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Cliente entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfCliente = new EntityDeletionOrUpdateAdapter<Cliente>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `clientes` SET `id` = ?,`nome` = ?,`endereco` = ?,`bairro` = ?,`cep` = ?,`cidade` = ?,`estado` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Cliente entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getNome());
        statement.bindString(3, entity.getEndereco());
        statement.bindString(4, entity.getBairro());
        statement.bindString(5, entity.getCep());
        statement.bindString(6, entity.getCidade());
        statement.bindString(7, entity.getEstado());
        statement.bindLong(8, entity.getId());
      }
    };
  }

  @Override
  public Object insert(final Cliente cliente, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCliente.insert(cliente);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Cliente cliente, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfCliente.handle(cliente);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Cliente cliente, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfCliente.handle(cliente);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<Cliente> getCliente(final int id) {
    final String _sql = "SELECT * from clientes WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"clientes"}, new Callable<Cliente>() {
      @Override
      @NonNull
      public Cliente call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfEndereco = CursorUtil.getColumnIndexOrThrow(_cursor, "endereco");
          final int _cursorIndexOfBairro = CursorUtil.getColumnIndexOrThrow(_cursor, "bairro");
          final int _cursorIndexOfCep = CursorUtil.getColumnIndexOrThrow(_cursor, "cep");
          final int _cursorIndexOfCidade = CursorUtil.getColumnIndexOrThrow(_cursor, "cidade");
          final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
          final Cliente _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNome;
            _tmpNome = _cursor.getString(_cursorIndexOfNome);
            final String _tmpEndereco;
            _tmpEndereco = _cursor.getString(_cursorIndexOfEndereco);
            final String _tmpBairro;
            _tmpBairro = _cursor.getString(_cursorIndexOfBairro);
            final String _tmpCep;
            _tmpCep = _cursor.getString(_cursorIndexOfCep);
            final String _tmpCidade;
            _tmpCidade = _cursor.getString(_cursorIndexOfCidade);
            final String _tmpEstado;
            _tmpEstado = _cursor.getString(_cursorIndexOfEstado);
            _result = new Cliente(_tmpId,_tmpNome,_tmpEndereco,_tmpBairro,_tmpCep,_tmpCidade,_tmpEstado);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Cliente>> getAllClientes() {
    final String _sql = "SELECT * from clientes ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"clientes"}, new Callable<List<Cliente>>() {
      @Override
      @NonNull
      public List<Cliente> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfEndereco = CursorUtil.getColumnIndexOrThrow(_cursor, "endereco");
          final int _cursorIndexOfBairro = CursorUtil.getColumnIndexOrThrow(_cursor, "bairro");
          final int _cursorIndexOfCep = CursorUtil.getColumnIndexOrThrow(_cursor, "cep");
          final int _cursorIndexOfCidade = CursorUtil.getColumnIndexOrThrow(_cursor, "cidade");
          final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
          final List<Cliente> _result = new ArrayList<Cliente>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Cliente _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNome;
            _tmpNome = _cursor.getString(_cursorIndexOfNome);
            final String _tmpEndereco;
            _tmpEndereco = _cursor.getString(_cursorIndexOfEndereco);
            final String _tmpBairro;
            _tmpBairro = _cursor.getString(_cursorIndexOfBairro);
            final String _tmpCep;
            _tmpCep = _cursor.getString(_cursorIndexOfCep);
            final String _tmpCidade;
            _tmpCidade = _cursor.getString(_cursorIndexOfCidade);
            final String _tmpEstado;
            _tmpEstado = _cursor.getString(_cursorIndexOfEstado);
            _item = new Cliente(_tmpId,_tmpNome,_tmpEndereco,_tmpBairro,_tmpCep,_tmpCidade,_tmpEstado);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
