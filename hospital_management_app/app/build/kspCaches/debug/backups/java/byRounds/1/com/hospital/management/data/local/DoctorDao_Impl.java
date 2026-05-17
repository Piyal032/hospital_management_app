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
import com.hospital.management.data.model.Doctor;
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
public final class DoctorDao_Impl implements DoctorDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Doctor> __insertionAdapterOfDoctor;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllDoctors;

  public DoctorDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDoctor = new EntityInsertionAdapter<Doctor>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `doctors` (`id`,`name`,`email`,`phone`,`specialization`,`qualification`,`experienceYears`,`department`,`consultationFee`,`availableDays`,`availableTime`,`profileImage`,`rating`,`totalReviews`,`isAvailable`,`about`,`status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Doctor entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getName());
        statement.bindString(3, entity.getEmail());
        statement.bindString(4, entity.getPhone());
        statement.bindString(5, entity.getSpecialization());
        statement.bindString(6, entity.getQualification());
        statement.bindLong(7, entity.getExperienceYears());
        statement.bindString(8, entity.getDepartment());
        statement.bindDouble(9, entity.getConsultationFee());
        statement.bindString(10, entity.getAvailableDays());
        statement.bindString(11, entity.getAvailableTime());
        if (entity.getProfileImage() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getProfileImage());
        }
        statement.bindDouble(13, entity.getRating());
        statement.bindLong(14, entity.getTotalReviews());
        final int _tmp = entity.isAvailable() ? 1 : 0;
        statement.bindLong(15, _tmp);
        if (entity.getAbout() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getAbout());
        }
        statement.bindString(17, entity.getStatus());
      }
    };
    this.__preparedStmtOfDeleteAllDoctors = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM doctors";
        return _query;
      }
    };
  }

  @Override
  public Object insertDoctors(final List<Doctor> doctors,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfDoctor.insert(doctors);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllDoctors(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllDoctors.acquire();
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
          __preparedStmtOfDeleteAllDoctors.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Doctor>> getAllDoctors() {
    final String _sql = "SELECT * FROM doctors ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"doctors"}, new Callable<List<Doctor>>() {
      @Override
      @NonNull
      public List<Doctor> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfSpecialization = CursorUtil.getColumnIndexOrThrow(_cursor, "specialization");
          final int _cursorIndexOfQualification = CursorUtil.getColumnIndexOrThrow(_cursor, "qualification");
          final int _cursorIndexOfExperienceYears = CursorUtil.getColumnIndexOrThrow(_cursor, "experienceYears");
          final int _cursorIndexOfDepartment = CursorUtil.getColumnIndexOrThrow(_cursor, "department");
          final int _cursorIndexOfConsultationFee = CursorUtil.getColumnIndexOrThrow(_cursor, "consultationFee");
          final int _cursorIndexOfAvailableDays = CursorUtil.getColumnIndexOrThrow(_cursor, "availableDays");
          final int _cursorIndexOfAvailableTime = CursorUtil.getColumnIndexOrThrow(_cursor, "availableTime");
          final int _cursorIndexOfProfileImage = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImage");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfTotalReviews = CursorUtil.getColumnIndexOrThrow(_cursor, "totalReviews");
          final int _cursorIndexOfIsAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "isAvailable");
          final int _cursorIndexOfAbout = CursorUtil.getColumnIndexOrThrow(_cursor, "about");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final List<Doctor> _result = new ArrayList<Doctor>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Doctor _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            final String _tmpPhone;
            _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            final String _tmpSpecialization;
            _tmpSpecialization = _cursor.getString(_cursorIndexOfSpecialization);
            final String _tmpQualification;
            _tmpQualification = _cursor.getString(_cursorIndexOfQualification);
            final int _tmpExperienceYears;
            _tmpExperienceYears = _cursor.getInt(_cursorIndexOfExperienceYears);
            final String _tmpDepartment;
            _tmpDepartment = _cursor.getString(_cursorIndexOfDepartment);
            final double _tmpConsultationFee;
            _tmpConsultationFee = _cursor.getDouble(_cursorIndexOfConsultationFee);
            final String _tmpAvailableDays;
            _tmpAvailableDays = _cursor.getString(_cursorIndexOfAvailableDays);
            final String _tmpAvailableTime;
            _tmpAvailableTime = _cursor.getString(_cursorIndexOfAvailableTime);
            final String _tmpProfileImage;
            if (_cursor.isNull(_cursorIndexOfProfileImage)) {
              _tmpProfileImage = null;
            } else {
              _tmpProfileImage = _cursor.getString(_cursorIndexOfProfileImage);
            }
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final int _tmpTotalReviews;
            _tmpTotalReviews = _cursor.getInt(_cursorIndexOfTotalReviews);
            final boolean _tmpIsAvailable;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAvailable);
            _tmpIsAvailable = _tmp != 0;
            final String _tmpAbout;
            if (_cursor.isNull(_cursorIndexOfAbout)) {
              _tmpAbout = null;
            } else {
              _tmpAbout = _cursor.getString(_cursorIndexOfAbout);
            }
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            _item = new Doctor(_tmpId,_tmpName,_tmpEmail,_tmpPhone,_tmpSpecialization,_tmpQualification,_tmpExperienceYears,_tmpDepartment,_tmpConsultationFee,_tmpAvailableDays,_tmpAvailableTime,_tmpProfileImage,_tmpRating,_tmpTotalReviews,_tmpIsAvailable,_tmpAbout,_tmpStatus);
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
  public Object getDoctorById(final String doctorId,
      final Continuation<? super Doctor> $completion) {
    final String _sql = "SELECT * FROM doctors WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, doctorId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Doctor>() {
      @Override
      @Nullable
      public Doctor call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfSpecialization = CursorUtil.getColumnIndexOrThrow(_cursor, "specialization");
          final int _cursorIndexOfQualification = CursorUtil.getColumnIndexOrThrow(_cursor, "qualification");
          final int _cursorIndexOfExperienceYears = CursorUtil.getColumnIndexOrThrow(_cursor, "experienceYears");
          final int _cursorIndexOfDepartment = CursorUtil.getColumnIndexOrThrow(_cursor, "department");
          final int _cursorIndexOfConsultationFee = CursorUtil.getColumnIndexOrThrow(_cursor, "consultationFee");
          final int _cursorIndexOfAvailableDays = CursorUtil.getColumnIndexOrThrow(_cursor, "availableDays");
          final int _cursorIndexOfAvailableTime = CursorUtil.getColumnIndexOrThrow(_cursor, "availableTime");
          final int _cursorIndexOfProfileImage = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImage");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfTotalReviews = CursorUtil.getColumnIndexOrThrow(_cursor, "totalReviews");
          final int _cursorIndexOfIsAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "isAvailable");
          final int _cursorIndexOfAbout = CursorUtil.getColumnIndexOrThrow(_cursor, "about");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final Doctor _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            final String _tmpPhone;
            _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            final String _tmpSpecialization;
            _tmpSpecialization = _cursor.getString(_cursorIndexOfSpecialization);
            final String _tmpQualification;
            _tmpQualification = _cursor.getString(_cursorIndexOfQualification);
            final int _tmpExperienceYears;
            _tmpExperienceYears = _cursor.getInt(_cursorIndexOfExperienceYears);
            final String _tmpDepartment;
            _tmpDepartment = _cursor.getString(_cursorIndexOfDepartment);
            final double _tmpConsultationFee;
            _tmpConsultationFee = _cursor.getDouble(_cursorIndexOfConsultationFee);
            final String _tmpAvailableDays;
            _tmpAvailableDays = _cursor.getString(_cursorIndexOfAvailableDays);
            final String _tmpAvailableTime;
            _tmpAvailableTime = _cursor.getString(_cursorIndexOfAvailableTime);
            final String _tmpProfileImage;
            if (_cursor.isNull(_cursorIndexOfProfileImage)) {
              _tmpProfileImage = null;
            } else {
              _tmpProfileImage = _cursor.getString(_cursorIndexOfProfileImage);
            }
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final int _tmpTotalReviews;
            _tmpTotalReviews = _cursor.getInt(_cursorIndexOfTotalReviews);
            final boolean _tmpIsAvailable;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAvailable);
            _tmpIsAvailable = _tmp != 0;
            final String _tmpAbout;
            if (_cursor.isNull(_cursorIndexOfAbout)) {
              _tmpAbout = null;
            } else {
              _tmpAbout = _cursor.getString(_cursorIndexOfAbout);
            }
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            _result = new Doctor(_tmpId,_tmpName,_tmpEmail,_tmpPhone,_tmpSpecialization,_tmpQualification,_tmpExperienceYears,_tmpDepartment,_tmpConsultationFee,_tmpAvailableDays,_tmpAvailableTime,_tmpProfileImage,_tmpRating,_tmpTotalReviews,_tmpIsAvailable,_tmpAbout,_tmpStatus);
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
  public Flow<List<Doctor>> getDoctorsBySpecialization(final String specialization) {
    final String _sql = "SELECT * FROM doctors WHERE specialization = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, specialization);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"doctors"}, new Callable<List<Doctor>>() {
      @Override
      @NonNull
      public List<Doctor> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfSpecialization = CursorUtil.getColumnIndexOrThrow(_cursor, "specialization");
          final int _cursorIndexOfQualification = CursorUtil.getColumnIndexOrThrow(_cursor, "qualification");
          final int _cursorIndexOfExperienceYears = CursorUtil.getColumnIndexOrThrow(_cursor, "experienceYears");
          final int _cursorIndexOfDepartment = CursorUtil.getColumnIndexOrThrow(_cursor, "department");
          final int _cursorIndexOfConsultationFee = CursorUtil.getColumnIndexOrThrow(_cursor, "consultationFee");
          final int _cursorIndexOfAvailableDays = CursorUtil.getColumnIndexOrThrow(_cursor, "availableDays");
          final int _cursorIndexOfAvailableTime = CursorUtil.getColumnIndexOrThrow(_cursor, "availableTime");
          final int _cursorIndexOfProfileImage = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImage");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfTotalReviews = CursorUtil.getColumnIndexOrThrow(_cursor, "totalReviews");
          final int _cursorIndexOfIsAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "isAvailable");
          final int _cursorIndexOfAbout = CursorUtil.getColumnIndexOrThrow(_cursor, "about");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final List<Doctor> _result = new ArrayList<Doctor>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Doctor _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            final String _tmpPhone;
            _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            final String _tmpSpecialization;
            _tmpSpecialization = _cursor.getString(_cursorIndexOfSpecialization);
            final String _tmpQualification;
            _tmpQualification = _cursor.getString(_cursorIndexOfQualification);
            final int _tmpExperienceYears;
            _tmpExperienceYears = _cursor.getInt(_cursorIndexOfExperienceYears);
            final String _tmpDepartment;
            _tmpDepartment = _cursor.getString(_cursorIndexOfDepartment);
            final double _tmpConsultationFee;
            _tmpConsultationFee = _cursor.getDouble(_cursorIndexOfConsultationFee);
            final String _tmpAvailableDays;
            _tmpAvailableDays = _cursor.getString(_cursorIndexOfAvailableDays);
            final String _tmpAvailableTime;
            _tmpAvailableTime = _cursor.getString(_cursorIndexOfAvailableTime);
            final String _tmpProfileImage;
            if (_cursor.isNull(_cursorIndexOfProfileImage)) {
              _tmpProfileImage = null;
            } else {
              _tmpProfileImage = _cursor.getString(_cursorIndexOfProfileImage);
            }
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final int _tmpTotalReviews;
            _tmpTotalReviews = _cursor.getInt(_cursorIndexOfTotalReviews);
            final boolean _tmpIsAvailable;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAvailable);
            _tmpIsAvailable = _tmp != 0;
            final String _tmpAbout;
            if (_cursor.isNull(_cursorIndexOfAbout)) {
              _tmpAbout = null;
            } else {
              _tmpAbout = _cursor.getString(_cursorIndexOfAbout);
            }
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            _item = new Doctor(_tmpId,_tmpName,_tmpEmail,_tmpPhone,_tmpSpecialization,_tmpQualification,_tmpExperienceYears,_tmpDepartment,_tmpConsultationFee,_tmpAvailableDays,_tmpAvailableTime,_tmpProfileImage,_tmpRating,_tmpTotalReviews,_tmpIsAvailable,_tmpAbout,_tmpStatus);
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
  public Flow<List<Doctor>> searchDoctors(final String query) {
    final String _sql = "SELECT * FROM doctors WHERE name LIKE '%' || ? || '%' OR specialization LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindString(_argIndex, query);
    _argIndex = 2;
    _statement.bindString(_argIndex, query);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"doctors"}, new Callable<List<Doctor>>() {
      @Override
      @NonNull
      public List<Doctor> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfSpecialization = CursorUtil.getColumnIndexOrThrow(_cursor, "specialization");
          final int _cursorIndexOfQualification = CursorUtil.getColumnIndexOrThrow(_cursor, "qualification");
          final int _cursorIndexOfExperienceYears = CursorUtil.getColumnIndexOrThrow(_cursor, "experienceYears");
          final int _cursorIndexOfDepartment = CursorUtil.getColumnIndexOrThrow(_cursor, "department");
          final int _cursorIndexOfConsultationFee = CursorUtil.getColumnIndexOrThrow(_cursor, "consultationFee");
          final int _cursorIndexOfAvailableDays = CursorUtil.getColumnIndexOrThrow(_cursor, "availableDays");
          final int _cursorIndexOfAvailableTime = CursorUtil.getColumnIndexOrThrow(_cursor, "availableTime");
          final int _cursorIndexOfProfileImage = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImage");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfTotalReviews = CursorUtil.getColumnIndexOrThrow(_cursor, "totalReviews");
          final int _cursorIndexOfIsAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "isAvailable");
          final int _cursorIndexOfAbout = CursorUtil.getColumnIndexOrThrow(_cursor, "about");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final List<Doctor> _result = new ArrayList<Doctor>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Doctor _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            final String _tmpPhone;
            _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            final String _tmpSpecialization;
            _tmpSpecialization = _cursor.getString(_cursorIndexOfSpecialization);
            final String _tmpQualification;
            _tmpQualification = _cursor.getString(_cursorIndexOfQualification);
            final int _tmpExperienceYears;
            _tmpExperienceYears = _cursor.getInt(_cursorIndexOfExperienceYears);
            final String _tmpDepartment;
            _tmpDepartment = _cursor.getString(_cursorIndexOfDepartment);
            final double _tmpConsultationFee;
            _tmpConsultationFee = _cursor.getDouble(_cursorIndexOfConsultationFee);
            final String _tmpAvailableDays;
            _tmpAvailableDays = _cursor.getString(_cursorIndexOfAvailableDays);
            final String _tmpAvailableTime;
            _tmpAvailableTime = _cursor.getString(_cursorIndexOfAvailableTime);
            final String _tmpProfileImage;
            if (_cursor.isNull(_cursorIndexOfProfileImage)) {
              _tmpProfileImage = null;
            } else {
              _tmpProfileImage = _cursor.getString(_cursorIndexOfProfileImage);
            }
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final int _tmpTotalReviews;
            _tmpTotalReviews = _cursor.getInt(_cursorIndexOfTotalReviews);
            final boolean _tmpIsAvailable;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAvailable);
            _tmpIsAvailable = _tmp != 0;
            final String _tmpAbout;
            if (_cursor.isNull(_cursorIndexOfAbout)) {
              _tmpAbout = null;
            } else {
              _tmpAbout = _cursor.getString(_cursorIndexOfAbout);
            }
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            _item = new Doctor(_tmpId,_tmpName,_tmpEmail,_tmpPhone,_tmpSpecialization,_tmpQualification,_tmpExperienceYears,_tmpDepartment,_tmpConsultationFee,_tmpAvailableDays,_tmpAvailableTime,_tmpProfileImage,_tmpRating,_tmpTotalReviews,_tmpIsAvailable,_tmpAbout,_tmpStatus);
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
