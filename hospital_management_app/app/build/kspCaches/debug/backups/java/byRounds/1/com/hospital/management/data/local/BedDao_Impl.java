package com.hospital.management.data.local;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.hospital.management.data.model.Bed;
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
public final class BedDao_Impl implements BedDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Bed> __insertionAdapterOfBed;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllBeds;

  public BedDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBed = new EntityInsertionAdapter<Bed>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `beds` (`id`,`ward_number`,`bed_number`,`type`,`status`,`patient_id`,`patient_name`,`daily_charge`,`floor`,`department`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Bed entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getWardNumber());
        statement.bindString(3, entity.getBedNumber());
        statement.bindString(4, entity.getType());
        statement.bindString(5, entity.getStatus());
        if (entity.getPatientId() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getPatientId());
        }
        if (entity.getPatientName() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getPatientName());
        }
        statement.bindDouble(8, entity.getDailyCharge());
        statement.bindLong(9, entity.getFloor());
        statement.bindString(10, entity.getDepartment());
      }
    };
    this.__preparedStmtOfDeleteAllBeds = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM beds";
        return _query;
      }
    };
  }

  @Override
  public Object insertBeds(final List<Bed> beds, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfBed.insert(beds);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllBeds(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllBeds.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllBeds.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Bed>> getAllBeds() {
    final String _sql = "SELECT * FROM beds ORDER BY ward_number, bed_number";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"beds"}, new Callable<List<Bed>>() {
      @Override
      @NonNull
      public List<Bed> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWardNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "ward_number");
          final int _cursorIndexOfBedNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "bed_number");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfPatientId = CursorUtil.getColumnIndexOrThrow(_cursor, "patient_id");
          final int _cursorIndexOfPatientName = CursorUtil.getColumnIndexOrThrow(_cursor, "patient_name");
          final int _cursorIndexOfDailyCharge = CursorUtil.getColumnIndexOrThrow(_cursor, "daily_charge");
          final int _cursorIndexOfFloor = CursorUtil.getColumnIndexOrThrow(_cursor, "floor");
          final int _cursorIndexOfDepartment = CursorUtil.getColumnIndexOrThrow(_cursor, "department");
          final List<Bed> _result = new ArrayList<Bed>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Bed _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpWardNumber;
            _tmpWardNumber = _cursor.getString(_cursorIndexOfWardNumber);
            final String _tmpBedNumber;
            _tmpBedNumber = _cursor.getString(_cursorIndexOfBedNumber);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final String _tmpPatientId;
            if (_cursor.isNull(_cursorIndexOfPatientId)) {
              _tmpPatientId = null;
            } else {
              _tmpPatientId = _cursor.getString(_cursorIndexOfPatientId);
            }
            final String _tmpPatientName;
            if (_cursor.isNull(_cursorIndexOfPatientName)) {
              _tmpPatientName = null;
            } else {
              _tmpPatientName = _cursor.getString(_cursorIndexOfPatientName);
            }
            final double _tmpDailyCharge;
            _tmpDailyCharge = _cursor.getDouble(_cursorIndexOfDailyCharge);
            final int _tmpFloor;
            _tmpFloor = _cursor.getInt(_cursorIndexOfFloor);
            final String _tmpDepartment;
            _tmpDepartment = _cursor.getString(_cursorIndexOfDepartment);
            _item = new Bed(_tmpId,_tmpWardNumber,_tmpBedNumber,_tmpType,_tmpStatus,_tmpPatientId,_tmpPatientName,_tmpDailyCharge,_tmpFloor,_tmpDepartment);
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

  @Override
  public Flow<List<Bed>> getAvailableBeds() {
    final String _sql = "SELECT * FROM beds WHERE status = 'available'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"beds"}, new Callable<List<Bed>>() {
      @Override
      @NonNull
      public List<Bed> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWardNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "ward_number");
          final int _cursorIndexOfBedNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "bed_number");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfPatientId = CursorUtil.getColumnIndexOrThrow(_cursor, "patient_id");
          final int _cursorIndexOfPatientName = CursorUtil.getColumnIndexOrThrow(_cursor, "patient_name");
          final int _cursorIndexOfDailyCharge = CursorUtil.getColumnIndexOrThrow(_cursor, "daily_charge");
          final int _cursorIndexOfFloor = CursorUtil.getColumnIndexOrThrow(_cursor, "floor");
          final int _cursorIndexOfDepartment = CursorUtil.getColumnIndexOrThrow(_cursor, "department");
          final List<Bed> _result = new ArrayList<Bed>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Bed _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpWardNumber;
            _tmpWardNumber = _cursor.getString(_cursorIndexOfWardNumber);
            final String _tmpBedNumber;
            _tmpBedNumber = _cursor.getString(_cursorIndexOfBedNumber);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final String _tmpPatientId;
            if (_cursor.isNull(_cursorIndexOfPatientId)) {
              _tmpPatientId = null;
            } else {
              _tmpPatientId = _cursor.getString(_cursorIndexOfPatientId);
            }
            final String _tmpPatientName;
            if (_cursor.isNull(_cursorIndexOfPatientName)) {
              _tmpPatientName = null;
            } else {
              _tmpPatientName = _cursor.getString(_cursorIndexOfPatientName);
            }
            final double _tmpDailyCharge;
            _tmpDailyCharge = _cursor.getDouble(_cursorIndexOfDailyCharge);
            final int _tmpFloor;
            _tmpFloor = _cursor.getInt(_cursorIndexOfFloor);
            final String _tmpDepartment;
            _tmpDepartment = _cursor.getString(_cursorIndexOfDepartment);
            _item = new Bed(_tmpId,_tmpWardNumber,_tmpBedNumber,_tmpType,_tmpStatus,_tmpPatientId,_tmpPatientName,_tmpDailyCharge,_tmpFloor,_tmpDepartment);
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

  @Override
  public Flow<List<Bed>> getBedsByWard(final String wardNumber) {
    final String _sql = "SELECT * FROM beds WHERE ward_number = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, wardNumber);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"beds"}, new Callable<List<Bed>>() {
      @Override
      @NonNull
      public List<Bed> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWardNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "ward_number");
          final int _cursorIndexOfBedNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "bed_number");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfPatientId = CursorUtil.getColumnIndexOrThrow(_cursor, "patient_id");
          final int _cursorIndexOfPatientName = CursorUtil.getColumnIndexOrThrow(_cursor, "patient_name");
          final int _cursorIndexOfDailyCharge = CursorUtil.getColumnIndexOrThrow(_cursor, "daily_charge");
          final int _cursorIndexOfFloor = CursorUtil.getColumnIndexOrThrow(_cursor, "floor");
          final int _cursorIndexOfDepartment = CursorUtil.getColumnIndexOrThrow(_cursor, "department");
          final List<Bed> _result = new ArrayList<Bed>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Bed _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpWardNumber;
            _tmpWardNumber = _cursor.getString(_cursorIndexOfWardNumber);
            final String _tmpBedNumber;
            _tmpBedNumber = _cursor.getString(_cursorIndexOfBedNumber);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final String _tmpPatientId;
            if (_cursor.isNull(_cursorIndexOfPatientId)) {
              _tmpPatientId = null;
            } else {
              _tmpPatientId = _cursor.getString(_cursorIndexOfPatientId);
            }
            final String _tmpPatientName;
            if (_cursor.isNull(_cursorIndexOfPatientName)) {
              _tmpPatientName = null;
            } else {
              _tmpPatientName = _cursor.getString(_cursorIndexOfPatientName);
            }
            final double _tmpDailyCharge;
            _tmpDailyCharge = _cursor.getDouble(_cursorIndexOfDailyCharge);
            final int _tmpFloor;
            _tmpFloor = _cursor.getInt(_cursorIndexOfFloor);
            final String _tmpDepartment;
            _tmpDepartment = _cursor.getString(_cursorIndexOfDepartment);
            _item = new Bed(_tmpId,_tmpWardNumber,_tmpBedNumber,_tmpType,_tmpStatus,_tmpPatientId,_tmpPatientName,_tmpDailyCharge,_tmpFloor,_tmpDepartment);
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
