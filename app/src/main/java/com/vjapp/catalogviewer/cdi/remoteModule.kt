import com.vjapp.catalogviewer.cdi.EnvironmentConfig
import com.vjapp.catalogviewer.cdi.EnvironmentConfig.BASE_DOMAIN
import com.vjapp.catalogviewer.cdi.EnvironmentConfig.allowedSSlFingerprints
import com.vjapp.catalogviewer.data.repository.datasource.RemoteDataSource
import com.vjapp.catalogviewer.data.setup.AppServiceFactory
import com.vjapp.catalogviewer.data.setup.HttpClientFactory
import com.vjapp.catalogviewer.data.setup.ServiceFactory
import org.koin.dsl.module.module

val remoteModule = module {
    single("HTTP_CLIENT") { HttpClientFactory(BASE_DOMAIN, allowedSSlFingerprints) }
    single("SERVICE_FACTORY") { ServiceFactory(EnvironmentConfig.BASE_URL) }

    //single { (get("SERVICE_FACTORY") as ServiceFactory).retrofitInstance }
    single("APP_SERVICE") { AppServiceFactory(get("HTTP_CLIENT")).getAppService(get("SERVICE_FACTORY")) }
    single { RemoteDataSource(get("APP_SERVICE")) as RemoteDataSource }


}