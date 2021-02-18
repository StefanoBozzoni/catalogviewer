import org.koin.dsl.module.module

val localModule = module {

    /*
    single(DatabaseConstants.DATABASE_NAME) {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, DatabaseConstants.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    single("LOCAL_DATA_SOURCE") { LocalDataSource(get(DatabaseConstants.DATABASE_NAME)) }

     */

}