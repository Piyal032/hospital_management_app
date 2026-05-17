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
import com.hospital.management.data.model.Appointment;
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
public final class AppointmentDao_Impl implements AppointmentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Appointment> __insertionAdapterOfAppointment;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllAppointments;

  public AppointmentDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAppointment = new EntityInsertionAdapter<Appointment>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `appointments` (`id`,`patient_id`,`patient_name`,`doctor_id`,`doctor_name`,`department`,`appointment_date`,`appointment_time`,`status`,`type`,`symptoms`,`notes`,`created_at`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Appointment entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getPatientId());
        statement.bindString(3, entity.getPatientName());
        statement.bindString(4, entity.getDoctorId());
        statement.bindString(5, entity.getDoctorName());
        statement.bindString(6, entity.getDepartment());
        statement.bindString(7, entity.getAppointmentDate());
        statement.bindString(8, entity.getAppointmentTime());
        statement.bindString(9, entity.getStatus());
        statement.bindString(10, entity.getType());
        if (entity.getSymptoms() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getSymptoms());
        }
        if (entity.getNotes() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getNotes());
        }
        statement.bindString(13, entity.getCreatedAt());
      }
    };
    this.__preparedStmtOfDeleteAllAppointments = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM appointments";
        return _query;
      }
    };
  }

  @Override
  public Object insertAppointments(final List<Appointment> appointments,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAppointment.insert(appointments);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllAppointments(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllAppointments.acquire();
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
          __preparedStmtOfDeleteAllAppointments.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Appointment>> getAllAppointments() {
    final String _sql = "SELECT * FROM appointments ORDER BY appointment_date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"appointments"}, new Callable<List<Appointment>>() {
      @Override
      @NonNull
      public List<Appointment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPatientId = CursorUtil.getColumnIndexOrThrow(_cursor, "patient_id");
          final int _cursorIndexOfPatientName = CursorUtil.getColumnIndexOrThrow(_cursor, "patient_name");
          final int _cursorIndexOfDoctorId = CursorUtil.getColumnIndexOrThrow(_cursor, "doctor_id");
          final int _cursorIndexOfDoctorName = CursorUtil.getColumnIndexOrThrow(_cursor, "doctor_name");
          final int _cursorIndexOfDepartment = CursorUtil.getColumnIndexOrThrow(_cursor, "department");
          final int _cursorIndexOfAppointmentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "appointment_date");
          final int _cursorIndexOfAppointmentTime = CursorUtil.getColumnIndexOrThrow(_cursor, "appointment_time");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfSymptoms = CursorUtil.getColumnIndexOrThrow(_cursor, "symptoms");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
          final List<Appointment> _result = new ArrayList<Appointment>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Appointment _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpPatientId;
            _tmpPatientId = _cursor.getString(_cursorIndexOfPatientId);
            final String _tmpPatientName;
            _tmpPatientName = _cursor.getString(_cursorIndexOfPatientName);
            final String _tmpDoctorId;
            _tmpDoctorId = _cursor.getString(_cursorIndexOfDoctorId);
            final String _tmpDoctorName;
            _tmpDoctorName = _cursor.getString(_cursorIndexOfDoctorName);
            final String _tmpDepartment;
            _tmpDepartment = _cursor.getString(_cursorIndexOfDepartment);
            final String _tmpAppointmentDate;
            _tmpAppointmentDate = _cursor.getString(_cursorIndexOfAppointmentDate);
            final String _tmpAppointmentTime;
            _tmpAppointmentTime = _cursor.getString(_cursorIndexOfAppointmentTime);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final String _tmpSymptoms;
            if (_cursor.isNull(_cursorIndexOfSymptoms)) {
              _tmpSymptoms = null;
            } else {
              _tmpSymptoms = _cursor.getString(_cursorIndexOfSymptoms);
            }
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final String _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            _item = new Appointment(_tmpId,_tmpPatientId,_tmpPatientName,_tmpDoctorId,_tmpDoctorName,_tmpDepartment,_tmpAppointmentDate,_tmpAppointmentTime,_tmpStatus,_tmpType,_tmpSymptoms,_tmpNotes,_tmpCreatedAt);
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
  public Flow<List<Appointment>> getAppointmentsByStatus(final String status) {
    final String _sql = "SELECT * FROM appointments WHERE status = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, status);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"appointments"}, new Callable<List<Appointment>>() {
      @Override
      @NonNull
      public List<Appointment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPatientId = CursorUtil.getColumnIndexOrThrow(_cursor, "patient_id");
          final int _cursorIndexOfPatientName = CursorUtil.getColumnIndexOrThrow(_cursor, "patient_name");
          final int _cursorIndexOfDoctorId = CursorUtil.getColumnIndexOrThrow(_cursor, "doctor_id");
          final int _cursorIndexOfDoctorName = CursorUtil.getColumnIndexOrThrow(_cursor, "doctor_name");
          final int _cursorIndexOfDepartment = CursorUtil.getColumnIndexOrThrow(_cursor, "department");
          final int _cursorIndexOfAppointmentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "appointment_date");
          final int _cursorIndexOfAppointmentTime = CursorUtil.getColumnIndexOrThrow(_cursor, "appointment_time");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfSymptoms = CursorUtil.getColumnIndexOrThrow(_cursor, "symptoms");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
          final List<Appointment> _result = new ArrayList<Appointment>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Appointment _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpPatientId;
            _tmpPatientId = _cursor.getString(_cursorIndexOfPatientId);
            final String _tmpPatientName;
            _tmpPatientName = _cursor.getString(_cursorIndexOfPatientName);
            final String _tmpDoctorId;
            _tmpDoctorId = _cursor.getString(_cursorIndexOfDoctorId);
            final String _tmpDoctorName;
            _tmpDoctorName = _cursor.getString(_cursorIndexOfDoctorName);
            final String _tmpDepartment;
            _tmpDepartment = _cursor.getString(_cursorIndexOfDepartment);
            final String _tmpAppointmentDate;
            _tmpAppointmentDate = _cursor.getString(_cursorIndexOfAppointmentDate);
            final String _tmpAppointmentTime;
            _tmpAppointmentTime = _cursor.getString(_cursorIndexOfAppointmentTime);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final String _tmpSymptoms;
            if (_cursor.isNull(_cursorIndexOfSymptoms)) {
              _tmpSymptoms = null;
            } else {
              _tmpSymptoms = _cursor.getString(_cursorIndexOfSymptoms);
            }
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final String _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            _item = new Appointment(_tmpId,_tmpPatientId,_tmpPatientName,_tmpDoctorId,_tmpDoctorName,_tmpDepartment,_tmpAppointmentDate,_tmpAppointmentTime,_tmpStatus,_tmpType,_tmpSymptoms,_tmpNotes,_tmpCreatedAt);
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
