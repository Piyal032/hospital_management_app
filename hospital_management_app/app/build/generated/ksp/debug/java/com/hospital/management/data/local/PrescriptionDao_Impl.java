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
import com.hospital.management.data.model.Prescription;
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
public final class PrescriptionDao_Impl implements PrescriptionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Prescription> __insertionAdapterOfPrescription;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllPrescriptions;

  public PrescriptionDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPrescription = new EntityInsertionAdapter<Prescription>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `prescriptions` (`id`,`patient_id`,`patient_name`,`doctor_id`,`doctor_name`,`diagnosis`,`medicines`,`instructions`,`follow_up_date`,`created_at`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Prescription entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getPatientId());
        statement.bindString(3, entity.getPatientName());
        statement.bindString(4, entity.getDoctorId());
        statement.bindString(5, entity.getDoctorName());
        statement.bindString(6, entity.getDiagnosis());
        statement.bindString(7, entity.getMedicines());
        if (entity.getInstructions() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getInstructions());
        }
        if (entity.getFollowUpDate() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getFollowUpDate());
        }
        statement.bindString(10, entity.getCreatedAt());
      }
    };
    this.__preparedStmtOfDeleteAllPrescriptions = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM prescriptions";
        return _query;
      }
    };
  }

  @Override
  public Object insertPrescriptions(final List<Prescription> prescriptions,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPrescription.insert(prescriptions);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllPrescriptions(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllPrescriptions.acquire();
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
          __preparedStmtOfDeleteAllPrescriptions.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Prescription>> getAllPrescriptions() {
    final String _sql = "SELECT * FROM prescriptions ORDER BY created_at DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"prescriptions"}, new Callable<List<Prescription>>() {
      @Override
      @NonNull
      public List<Prescription> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPatientId = CursorUtil.getColumnIndexOrThrow(_cursor, "patient_id");
          final int _cursorIndexOfPatientName = CursorUtil.getColumnIndexOrThrow(_cursor, "patient_name");
          final int _cursorIndexOfDoctorId = CursorUtil.getColumnIndexOrThrow(_cursor, "doctor_id");
          final int _cursorIndexOfDoctorName = CursorUtil.getColumnIndexOrThrow(_cursor, "doctor_name");
          final int _cursorIndexOfDiagnosis = CursorUtil.getColumnIndexOrThrow(_cursor, "diagnosis");
          final int _cursorIndexOfMedicines = CursorUtil.getColumnIndexOrThrow(_cursor, "medicines");
          final int _cursorIndexOfInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "instructions");
          final int _cursorIndexOfFollowUpDate = CursorUtil.getColumnIndexOrThrow(_cursor, "follow_up_date");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
          final List<Prescription> _result = new ArrayList<Prescription>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Prescription _item;
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
            final String _tmpDiagnosis;
            _tmpDiagnosis = _cursor.getString(_cursorIndexOfDiagnosis);
            final String _tmpMedicines;
            _tmpMedicines = _cursor.getString(_cursorIndexOfMedicines);
            final String _tmpInstructions;
            if (_cursor.isNull(_cursorIndexOfInstructions)) {
              _tmpInstructions = null;
            } else {
              _tmpInstructions = _cursor.getString(_cursorIndexOfInstructions);
            }
            final String _tmpFollowUpDate;
            if (_cursor.isNull(_cursorIndexOfFollowUpDate)) {
              _tmpFollowUpDate = null;
            } else {
              _tmpFollowUpDate = _cursor.getString(_cursorIndexOfFollowUpDate);
            }
            final String _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            _item = new Prescription(_tmpId,_tmpPatientId,_tmpPatientName,_tmpDoctorId,_tmpDoctorName,_tmpDiagnosis,_tmpMedicines,_tmpInstructions,_tmpFollowUpDate,_tmpCreatedAt);
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
  public Flow<List<Prescription>> getPrescriptionsByPatient(final String patientId) {
    final String _sql = "SELECT * FROM prescriptions WHERE patient_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, patientId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"prescriptions"}, new Callable<List<Prescription>>() {
      @Override
      @NonNull
      public List<Prescription> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPatientId = CursorUtil.getColumnIndexOrThrow(_cursor, "patient_id");
          final int _cursorIndexOfPatientName = CursorUtil.getColumnIndexOrThrow(_cursor, "patient_name");
          final int _cursorIndexOfDoctorId = CursorUtil.getColumnIndexOrThrow(_cursor, "doctor_id");
          final int _cursorIndexOfDoctorName = CursorUtil.getColumnIndexOrThrow(_cursor, "doctor_name");
          final int _cursorIndexOfDiagnosis = CursorUtil.getColumnIndexOrThrow(_cursor, "diagnosis");
          final int _cursorIndexOfMedicines = CursorUtil.getColumnIndexOrThrow(_cursor, "medicines");
          final int _cursorIndexOfInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "instructions");
          final int _cursorIndexOfFollowUpDate = CursorUtil.getColumnIndexOrThrow(_cursor, "follow_up_date");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
          final List<Prescription> _result = new ArrayList<Prescription>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Prescription _item;
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
            final String _tmpDiagnosis;
            _tmpDiagnosis = _cursor.getString(_cursorIndexOfDiagnosis);
            final String _tmpMedicines;
            _tmpMedicines = _cursor.getString(_cursorIndexOfMedicines);
            final String _tmpInstructions;
            if (_cursor.isNull(_cursorIndexOfInstructions)) {
              _tmpInstructions = null;
            } else {
              _tmpInstructions = _cursor.getString(_cursorIndexOfInstructions);
            }
            final String _tmpFollowUpDate;
            if (_cursor.isNull(_cursorIndexOfFollowUpDate)) {
              _tmpFollowUpDate = null;
            } else {
              _tmpFollowUpDate = _cursor.getString(_cursorIndexOfFollowUpDate);
            }
            final String _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            _item = new Prescription(_tmpId,_tmpPatientId,_tmpPatientName,_tmpDoctorId,_tmpDoctorName,_tmpDiagnosis,_tmpMedicines,_tmpInstructions,_tmpFollowUpDate,_tmpCreatedAt);
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
