package com.hospital.management.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.hospital.management.data.model.Patient;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
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
public final class PatientDao_Impl implements PatientDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Patient> __insertionAdapterOfPatient;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllPatients;

  public PatientDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPatient = new EntityInsertionAdapter<Patient>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `patients` (`id`,`name`,`email`,`phone`,`age`,`gender`,`bloodGroup`,`address`,`emergencyContact`,`medicalHistory`,`allergies`,`profileImage`,`admissionDate`,`wardNumber`,`bedNumber`,`status`,`createdAt`,`updatedAt`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Patient entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getName());
        statement.bindString(3, entity.getEmail());
        statement.bindString(4, entity.getPhone());
        statement.bindLong(5, entity.getAge());
        statement.bindString(6, entity.getGender());
        statement.bindString(7, entity.getBloodGroup());
        statement.bindString(8, entity.getAddress());
        statement.bindString(9, entity.getEmergencyContact());
        if (entity.getMedicalHistory() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getMedicalHistory());
        }
        if (entity.getAllergies() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getAllergies());
        }
        if (entity.getProfileImage() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getProfileImage());
        }
        if (entity.getAdmissionDate() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getAdmissionDate());
        }
        if (entity.getWardNumber() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getWardNumber());
        }
        if (entity.getBedNumber() == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.getBedNumber());
        }
        statement.bindString(16, entity.getStatus());
        statement.bindString(17, entity.getCreatedAt());
        statement.bindString(18, entity.getUpdatedAt());
      }
    };
    this.__preparedStmtOfDeleteAllPatients = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM patients";
        return _query;
      }
    };
  }

  @Override
  public Object insertPatients(final List<Patient> patients,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPatient.insert(patients);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertPatient(final Patient patient, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPatient.insert(patient);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllPatients(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllPatients.acquire();
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
          __preparedStmtOfDeleteAllPatients.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Patient>> getAllPatients() {
    final String _sql = "SELECT * FROM patients ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"patients"}, new Callable<List<Patient>>() {
      @Override
      @NonNull
      public List<Patient> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfBloodGroup = CursorUtil.getColumnIndexOrThrow(_cursor, "bloodGroup");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfEmergencyContact = CursorUtil.getColumnIndexOrThrow(_cursor, "emergencyContact");
          final int _cursorIndexOfMedicalHistory = CursorUtil.getColumnIndexOrThrow(_cursor, "medicalHistory");
          final int _cursorIndexOfAllergies = CursorUtil.getColumnIndexOrThrow(_cursor, "allergies");
          final int _cursorIndexOfProfileImage = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImage");
          final int _cursorIndexOfAdmissionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "admissionDate");
          final int _cursorIndexOfWardNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "wardNumber");
          final int _cursorIndexOfBedNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "bedNumber");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Patient> _result = new ArrayList<Patient>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Patient _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            final String _tmpPhone;
            _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            final int _tmpAge;
            _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            final String _tmpGender;
            _tmpGender = _cursor.getString(_cursorIndexOfGender);
            final String _tmpBloodGroup;
            _tmpBloodGroup = _cursor.getString(_cursorIndexOfBloodGroup);
            final String _tmpAddress;
            _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            final String _tmpEmergencyContact;
            _tmpEmergencyContact = _cursor.getString(_cursorIndexOfEmergencyContact);
            final String _tmpMedicalHistory;
            if (_cursor.isNull(_cursorIndexOfMedicalHistory)) {
              _tmpMedicalHistory = null;
            } else {
              _tmpMedicalHistory = _cursor.getString(_cursorIndexOfMedicalHistory);
            }
            final String _tmpAllergies;
            if (_cursor.isNull(_cursorIndexOfAllergies)) {
              _tmpAllergies = null;
            } else {
              _tmpAllergies = _cursor.getString(_cursorIndexOfAllergies);
            }
            final String _tmpProfileImage;
            if (_cursor.isNull(_cursorIndexOfProfileImage)) {
              _tmpProfileImage = null;
            } else {
              _tmpProfileImage = _cursor.getString(_cursorIndexOfProfileImage);
            }
            final String _tmpAdmissionDate;
            if (_cursor.isNull(_cursorIndexOfAdmissionDate)) {
              _tmpAdmissionDate = null;
            } else {
              _tmpAdmissionDate = _cursor.getString(_cursorIndexOfAdmissionDate);
            }
            final String _tmpWardNumber;
            if (_cursor.isNull(_cursorIndexOfWardNumber)) {
              _tmpWardNumber = null;
            } else {
              _tmpWardNumber = _cursor.getString(_cursorIndexOfWardNumber);
            }
            final String _tmpBedNumber;
            if (_cursor.isNull(_cursorIndexOfBedNumber)) {
              _tmpBedNumber = null;
            } else {
              _tmpBedNumber = _cursor.getString(_cursorIndexOfBedNumber);
            }
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final String _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            final String _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            _item = new Patient(_tmpId,_tmpName,_tmpEmail,_tmpPhone,_tmpAge,_tmpGender,_tmpBloodGroup,_tmpAddress,_tmpEmergencyContact,_tmpMedicalHistory,_tmpAllergies,_tmpProfileImage,_tmpAdmissionDate,_tmpWardNumber,_tmpBedNumber,_tmpStatus,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Object getPatientById(final String patientId,
      final Continuation<? super Patient> $completion) {
    final String _sql = "SELECT * FROM patients WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, patientId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Patient>() {
      @Override
      @Nullable
      public Patient call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfBloodGroup = CursorUtil.getColumnIndexOrThrow(_cursor, "bloodGroup");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfEmergencyContact = CursorUtil.getColumnIndexOrThrow(_cursor, "emergencyContact");
          final int _cursorIndexOfMedicalHistory = CursorUtil.getColumnIndexOrThrow(_cursor, "medicalHistory");
          final int _cursorIndexOfAllergies = CursorUtil.getColumnIndexOrThrow(_cursor, "allergies");
          final int _cursorIndexOfProfileImage = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImage");
          final int _cursorIndexOfAdmissionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "admissionDate");
          final int _cursorIndexOfWardNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "wardNumber");
          final int _cursorIndexOfBedNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "bedNumber");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final Patient _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            final String _tmpPhone;
            _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            final int _tmpAge;
            _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            final String _tmpGender;
            _tmpGender = _cursor.getString(_cursorIndexOfGender);
            final String _tmpBloodGroup;
            _tmpBloodGroup = _cursor.getString(_cursorIndexOfBloodGroup);
            final String _tmpAddress;
            _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            final String _tmpEmergencyContact;
            _tmpEmergencyContact = _cursor.getString(_cursorIndexOfEmergencyContact);
            final String _tmpMedicalHistory;
            if (_cursor.isNull(_cursorIndexOfMedicalHistory)) {
              _tmpMedicalHistory = null;
            } else {
              _tmpMedicalHistory = _cursor.getString(_cursorIndexOfMedicalHistory);
            }
            final String _tmpAllergies;
            if (_cursor.isNull(_cursorIndexOfAllergies)) {
              _tmpAllergies = null;
            } else {
              _tmpAllergies = _cursor.getString(_cursorIndexOfAllergies);
            }
            final String _tmpProfileImage;
            if (_cursor.isNull(_cursorIndexOfProfileImage)) {
              _tmpProfileImage = null;
            } else {
              _tmpProfileImage = _cursor.getString(_cursorIndexOfProfileImage);
            }
            final String _tmpAdmissionDate;
            if (_cursor.isNull(_cursorIndexOfAdmissionDate)) {
              _tmpAdmissionDate = null;
            } else {
              _tmpAdmissionDate = _cursor.getString(_cursorIndexOfAdmissionDate);
            }
            final String _tmpWardNumber;
            if (_cursor.isNull(_cursorIndexOfWardNumber)) {
              _tmpWardNumber = null;
            } else {
              _tmpWardNumber = _cursor.getString(_cursorIndexOfWardNumber);
            }
            final String _tmpBedNumber;
            if (_cursor.isNull(_cursorIndexOfBedNumber)) {
              _tmpBedNumber = null;
            } else {
              _tmpBedNumber = _cursor.getString(_cursorIndexOfBedNumber);
            }
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final String _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            final String _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            _result = new Patient(_tmpId,_tmpName,_tmpEmail,_tmpPhone,_tmpAge,_tmpGender,_tmpBloodGroup,_tmpAddress,_tmpEmergencyContact,_tmpMedicalHistory,_tmpAllergies,_tmpProfileImage,_tmpAdmissionDate,_tmpWardNumber,_tmpBedNumber,_tmpStatus,_tmpCreatedAt,_tmpUpdatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Patient>> searchPatients(final String query) {
    final String _sql = "SELECT * FROM patients WHERE name LIKE '%' || ? || '%' OR phone LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindString(_argIndex, query);
    _argIndex = 2;
    _statement.bindString(_argIndex, query);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"patients"}, new Callable<List<Patient>>() {
      @Override
      @NonNull
      public List<Patient> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfBloodGroup = CursorUtil.getColumnIndexOrThrow(_cursor, "bloodGroup");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfEmergencyContact = CursorUtil.getColumnIndexOrThrow(_cursor, "emergencyContact");
          final int _cursorIndexOfMedicalHistory = CursorUtil.getColumnIndexOrThrow(_cursor, "medicalHistory");
          final int _cursorIndexOfAllergies = CursorUtil.getColumnIndexOrThrow(_cursor, "allergies");
          final int _cursorIndexOfProfileImage = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImage");
          final int _cursorIndexOfAdmissionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "admissionDate");
          final int _cursorIndexOfWardNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "wardNumber");
          final int _cursorIndexOfBedNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "bedNumber");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Patient> _result = new ArrayList<Patient>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Patient _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            final String _tmpPhone;
            _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            final int _tmpAge;
            _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            final String _tmpGender;
            _tmpGender = _cursor.getString(_cursorIndexOfGender);
            final String _tmpBloodGroup;
            _tmpBloodGroup = _cursor.getString(_cursorIndexOfBloodGroup);
            final String _tmpAddress;
            _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            final String _tmpEmergencyContact;
            _tmpEmergencyContact = _cursor.getString(_cursorIndexOfEmergencyContact);
            final String _tmpMedicalHistory;
            if (_cursor.isNull(_cursorIndexOfMedicalHistory)) {
              _tmpMedicalHistory = null;
            } else {
              _tmpMedicalHistory = _cursor.getString(_cursorIndexOfMedicalHistory);
            }
            final String _tmpAllergies;
            if (_cursor.isNull(_cursorIndexOfAllergies)) {
              _tmpAllergies = null;
            } else {
              _tmpAllergies = _cursor.getString(_cursorIndexOfAllergies);
            }
            final String _tmpProfileImage;
            if (_cursor.isNull(_cursorIndexOfProfileImage)) {
              _tmpProfileImage = null;
            } else {
              _tmpProfileImage = _cursor.getString(_cursorIndexOfProfileImage);
            }
            final String _tmpAdmissionDate;
            if (_cursor.isNull(_cursorIndexOfAdmissionDate)) {
              _tmpAdmissionDate = null;
            } else {
              _tmpAdmissionDate = _cursor.getString(_cursorIndexOfAdmissionDate);
            }
            final String _tmpWardNumber;
            if (_cursor.isNull(_cursorIndexOfWardNumber)) {
              _tmpWardNumber = null;
            } else {
              _tmpWardNumber = _cursor.getString(_cursorIndexOfWardNumber);
            }
            final String _tmpBedNumber;
            if (_cursor.isNull(_cursorIndexOfBedNumber)) {
              _tmpBedNumber = null;
            } else {
              _tmpBedNumber = _cursor.getString(_cursorIndexOfBedNumber);
            }
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final String _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            final String _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            _item = new Patient(_tmpId,_tmpName,_tmpEmail,_tmpPhone,_tmpAge,_tmpGender,_tmpBloodGroup,_tmpAddress,_tmpEmergencyContact,_tmpMedicalHistory,_tmpAllergies,_tmpProfileImage,_tmpAdmissionDate,_tmpWardNumber,_tmpBedNumber,_tmpStatus,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Object getPatientCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM patients";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final int _tmp;
            _tmp = _cursor.getInt(0);
            _result = _tmp;
          } else {
            _result = 0;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
