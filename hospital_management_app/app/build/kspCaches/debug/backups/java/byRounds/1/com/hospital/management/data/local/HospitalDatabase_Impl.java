package com.hospital.management.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class HospitalDatabase_Impl extends HospitalDatabase {
  private volatile PatientDao _patientDao;

  private volatile DoctorDao _doctorDao;

  private volatile AppointmentDao _appointmentDao;

  private volatile PrescriptionDao _prescriptionDao;

  private volatile MedicineDao _medicineDao;

  private volatile BedDao _bedDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `patients` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `email` TEXT NOT NULL, `phone` TEXT NOT NULL, `age` INTEGER NOT NULL, `gender` TEXT NOT NULL, `bloodGroup` TEXT NOT NULL, `address` TEXT NOT NULL, `emergencyContact` TEXT NOT NULL, `medicalHistory` TEXT, `allergies` TEXT, `profileImage` TEXT, `admissionDate` TEXT, `wardNumber` TEXT, `bedNumber` TEXT, `status` TEXT NOT NULL, `createdAt` TEXT NOT NULL, `updatedAt` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `doctors` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `email` TEXT NOT NULL, `phone` TEXT NOT NULL, `specialization` TEXT NOT NULL, `qualification` TEXT NOT NULL, `experienceYears` INTEGER NOT NULL, `department` TEXT NOT NULL, `consultationFee` REAL NOT NULL, `availableDays` TEXT NOT NULL, `availableTime` TEXT NOT NULL, `profileImage` TEXT, `rating` REAL NOT NULL, `totalReviews` INTEGER NOT NULL, `isAvailable` INTEGER NOT NULL, `about` TEXT, `status` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `appointments` (`id` TEXT NOT NULL, `patient_id` TEXT NOT NULL, `patient_name` TEXT NOT NULL, `doctor_id` TEXT NOT NULL, `doctor_name` TEXT NOT NULL, `department` TEXT NOT NULL, `appointment_date` TEXT NOT NULL, `appointment_time` TEXT NOT NULL, `status` TEXT NOT NULL, `type` TEXT NOT NULL, `symptoms` TEXT, `notes` TEXT, `created_at` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `prescriptions` (`id` TEXT NOT NULL, `patient_id` TEXT NOT NULL, `patient_name` TEXT NOT NULL, `doctor_id` TEXT NOT NULL, `doctor_name` TEXT NOT NULL, `diagnosis` TEXT NOT NULL, `medicines` TEXT NOT NULL, `instructions` TEXT, `follow_up_date` TEXT, `created_at` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `medicines` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `generic_name` TEXT NOT NULL, `category` TEXT NOT NULL, `dosage` TEXT NOT NULL, `price` REAL NOT NULL, `stock` INTEGER NOT NULL, `manufacturer` TEXT NOT NULL, `expiry_date` TEXT NOT NULL, `description` TEXT, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `beds` (`id` TEXT NOT NULL, `ward_number` TEXT NOT NULL, `bed_number` TEXT NOT NULL, `type` TEXT NOT NULL, `status` TEXT NOT NULL, `patient_id` TEXT, `patient_name` TEXT, `daily_charge` REAL NOT NULL, `floor` INTEGER NOT NULL, `department` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '615f5bc43b980499e892fd0773a9f9b1')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `patients`");
        db.execSQL("DROP TABLE IF EXISTS `doctors`");
        db.execSQL("DROP TABLE IF EXISTS `appointments`");
        db.execSQL("DROP TABLE IF EXISTS `prescriptions`");
        db.execSQL("DROP TABLE IF EXISTS `medicines`");
        db.execSQL("DROP TABLE IF EXISTS `beds`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsPatients = new HashMap<String, TableInfo.Column>(18);
        _columnsPatients.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPatients.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPatients.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPatients.put("phone", new TableInfo.Column("phone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPatients.put("age", new TableInfo.Column("age", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPatients.put("gender", new TableInfo.Column("gender", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPatients.put("bloodGroup", new TableInfo.Column("bloodGroup", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPatients.put("address", new TableInfo.Column("address", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPatients.put("emergencyContact", new TableInfo.Column("emergencyContact", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPatients.put("medicalHistory", new TableInfo.Column("medicalHistory", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPatients.put("allergies", new TableInfo.Column("allergies", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPatients.put("profileImage", new TableInfo.Column("profileImage", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPatients.put("admissionDate", new TableInfo.Column("admissionDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPatients.put("wardNumber", new TableInfo.Column("wardNumber", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPatients.put("bedNumber", new TableInfo.Column("bedNumber", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPatients.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPatients.put("createdAt", new TableInfo.Column("createdAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPatients.put("updatedAt", new TableInfo.Column("updatedAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPatients = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPatients = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPatients = new TableInfo("patients", _columnsPatients, _foreignKeysPatients, _indicesPatients);
        final TableInfo _existingPatients = TableInfo.read(db, "patients");
        if (!_infoPatients.equals(_existingPatients)) {
          return new RoomOpenHelper.ValidationResult(false, "patients(com.hospital.management.data.model.Patient).\n"
                  + " Expected:\n" + _infoPatients + "\n"
                  + " Found:\n" + _existingPatients);
        }
        final HashMap<String, TableInfo.Column> _columnsDoctors = new HashMap<String, TableInfo.Column>(17);
        _columnsDoctors.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDoctors.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDoctors.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDoctors.put("phone", new TableInfo.Column("phone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDoctors.put("specialization", new TableInfo.Column("specialization", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDoctors.put("qualification", new TableInfo.Column("qualification", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDoctors.put("experienceYears", new TableInfo.Column("experienceYears", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDoctors.put("department", new TableInfo.Column("department", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDoctors.put("consultationFee", new TableInfo.Column("consultationFee", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDoctors.put("availableDays", new TableInfo.Column("availableDays", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDoctors.put("availableTime", new TableInfo.Column("availableTime", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDoctors.put("profileImage", new TableInfo.Column("profileImage", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDoctors.put("rating", new TableInfo.Column("rating", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDoctors.put("totalReviews", new TableInfo.Column("totalReviews", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDoctors.put("isAvailable", new TableInfo.Column("isAvailable", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDoctors.put("about", new TableInfo.Column("about", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDoctors.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDoctors = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDoctors = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDoctors = new TableInfo("doctors", _columnsDoctors, _foreignKeysDoctors, _indicesDoctors);
        final TableInfo _existingDoctors = TableInfo.read(db, "doctors");
        if (!_infoDoctors.equals(_existingDoctors)) {
          return new RoomOpenHelper.ValidationResult(false, "doctors(com.hospital.management.data.model.Doctor).\n"
                  + " Expected:\n" + _infoDoctors + "\n"
                  + " Found:\n" + _existingDoctors);
        }
        final HashMap<String, TableInfo.Column> _columnsAppointments = new HashMap<String, TableInfo.Column>(13);
        _columnsAppointments.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("patient_id", new TableInfo.Column("patient_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("patient_name", new TableInfo.Column("patient_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("doctor_id", new TableInfo.Column("doctor_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("doctor_name", new TableInfo.Column("doctor_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("department", new TableInfo.Column("department", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("appointment_date", new TableInfo.Column("appointment_date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("appointment_time", new TableInfo.Column("appointment_time", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("symptoms", new TableInfo.Column("symptoms", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("notes", new TableInfo.Column("notes", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("created_at", new TableInfo.Column("created_at", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAppointments = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAppointments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAppointments = new TableInfo("appointments", _columnsAppointments, _foreignKeysAppointments, _indicesAppointments);
        final TableInfo _existingAppointments = TableInfo.read(db, "appointments");
        if (!_infoAppointments.equals(_existingAppointments)) {
          return new RoomOpenHelper.ValidationResult(false, "appointments(com.hospital.management.data.model.Appointment).\n"
                  + " Expected:\n" + _infoAppointments + "\n"
                  + " Found:\n" + _existingAppointments);
        }
        final HashMap<String, TableInfo.Column> _columnsPrescriptions = new HashMap<String, TableInfo.Column>(10);
        _columnsPrescriptions.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrescriptions.put("patient_id", new TableInfo.Column("patient_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrescriptions.put("patient_name", new TableInfo.Column("patient_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrescriptions.put("doctor_id", new TableInfo.Column("doctor_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrescriptions.put("doctor_name", new TableInfo.Column("doctor_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrescriptions.put("diagnosis", new TableInfo.Column("diagnosis", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrescriptions.put("medicines", new TableInfo.Column("medicines", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrescriptions.put("instructions", new TableInfo.Column("instructions", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrescriptions.put("follow_up_date", new TableInfo.Column("follow_up_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrescriptions.put("created_at", new TableInfo.Column("created_at", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPrescriptions = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPrescriptions = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPrescriptions = new TableInfo("prescriptions", _columnsPrescriptions, _foreignKeysPrescriptions, _indicesPrescriptions);
        final TableInfo _existingPrescriptions = TableInfo.read(db, "prescriptions");
        if (!_infoPrescriptions.equals(_existingPrescriptions)) {
          return new RoomOpenHelper.ValidationResult(false, "prescriptions(com.hospital.management.data.model.Prescription).\n"
                  + " Expected:\n" + _infoPrescriptions + "\n"
                  + " Found:\n" + _existingPrescriptions);
        }
        final HashMap<String, TableInfo.Column> _columnsMedicines = new HashMap<String, TableInfo.Column>(10);
        _columnsMedicines.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedicines.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedicines.put("generic_name", new TableInfo.Column("generic_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedicines.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedicines.put("dosage", new TableInfo.Column("dosage", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedicines.put("price", new TableInfo.Column("price", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedicines.put("stock", new TableInfo.Column("stock", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedicines.put("manufacturer", new TableInfo.Column("manufacturer", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedicines.put("expiry_date", new TableInfo.Column("expiry_date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedicines.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMedicines = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMedicines = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMedicines = new TableInfo("medicines", _columnsMedicines, _foreignKeysMedicines, _indicesMedicines);
        final TableInfo _existingMedicines = TableInfo.read(db, "medicines");
        if (!_infoMedicines.equals(_existingMedicines)) {
          return new RoomOpenHelper.ValidationResult(false, "medicines(com.hospital.management.data.model.Medicine).\n"
                  + " Expected:\n" + _infoMedicines + "\n"
                  + " Found:\n" + _existingMedicines);
        }
        final HashMap<String, TableInfo.Column> _columnsBeds = new HashMap<String, TableInfo.Column>(10);
        _columnsBeds.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBeds.put("ward_number", new TableInfo.Column("ward_number", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBeds.put("bed_number", new TableInfo.Column("bed_number", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBeds.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBeds.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBeds.put("patient_id", new TableInfo.Column("patient_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBeds.put("patient_name", new TableInfo.Column("patient_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBeds.put("daily_charge", new TableInfo.Column("daily_charge", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBeds.put("floor", new TableInfo.Column("floor", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBeds.put("department", new TableInfo.Column("department", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBeds = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBeds = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBeds = new TableInfo("beds", _columnsBeds, _foreignKeysBeds, _indicesBeds);
        final TableInfo _existingBeds = TableInfo.read(db, "beds");
        if (!_infoBeds.equals(_existingBeds)) {
          return new RoomOpenHelper.ValidationResult(false, "beds(com.hospital.management.data.model.Bed).\n"
                  + " Expected:\n" + _infoBeds + "\n"
                  + " Found:\n" + _existingBeds);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "615f5bc43b980499e892fd0773a9f9b1", "cbcda4984bc40ab58c34521fb7d1e125");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "patients","doctors","appointments","prescriptions","medicines","beds");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `patients`");
      _db.execSQL("DELETE FROM `doctors`");
      _db.execSQL("DELETE FROM `appointments`");
      _db.execSQL("DELETE FROM `prescriptions`");
      _db.execSQL("DELETE FROM `medicines`");
      _db.execSQL("DELETE FROM `beds`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(PatientDao.class, PatientDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(DoctorDao.class, DoctorDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AppointmentDao.class, AppointmentDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PrescriptionDao.class, PrescriptionDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MedicineDao.class, MedicineDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(BedDao.class, BedDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public PatientDao patientDao() {
    if (_patientDao != null) {
      return _patientDao;
    } else {
      synchronized(this) {
        if(_patientDao == null) {
          _patientDao = new PatientDao_Impl(this);
        }
        return _patientDao;
      }
    }
  }

  @Override
  public DoctorDao doctorDao() {
    if (_doctorDao != null) {
      return _doctorDao;
    } else {
      synchronized(this) {
        if(_doctorDao == null) {
          _doctorDao = new DoctorDao_Impl(this);
        }
        return _doctorDao;
      }
    }
  }

  @Override
  public AppointmentDao appointmentDao() {
    if (_appointmentDao != null) {
      return _appointmentDao;
    } else {
      synchronized(this) {
        if(_appointmentDao == null) {
          _appointmentDao = new AppointmentDao_Impl(this);
        }
        return _appointmentDao;
      }
    }
  }

  @Override
  public PrescriptionDao prescriptionDao() {
    if (_prescriptionDao != null) {
      return _prescriptionDao;
    } else {
      synchronized(this) {
        if(_prescriptionDao == null) {
          _prescriptionDao = new PrescriptionDao_Impl(this);
        }
        return _prescriptionDao;
      }
    }
  }

  @Override
  public MedicineDao medicineDao() {
    if (_medicineDao != null) {
      return _medicineDao;
    } else {
      synchronized(this) {
        if(_medicineDao == null) {
          _medicineDao = new MedicineDao_Impl(this);
        }
        return _medicineDao;
      }
    }
  }

  @Override
  public BedDao bedDao() {
    if (_bedDao != null) {
      return _bedDao;
    } else {
      synchronized(this) {
        if(_bedDao == null) {
          _bedDao = new BedDao_Impl(this);
        }
        return _bedDao;
      }
    }
  }
}
