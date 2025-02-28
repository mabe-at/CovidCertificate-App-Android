package ch.admin.bag.covidcertificate.verifier

import android.app.Application
import android.os.Build
import at.gv.brz.eval.data.Config
import at.gv.brz.eval.net.UserAgentInterceptor
import at.gv.brz.eval.CovidCertificateSdk

class MainApplication : Application() {

	override fun onCreate() {
		super.onCreate()
		Config.appToken = BuildConfig.SDK_APP_TOKEN
		Config.userAgent =
			UserAgentInterceptor.UserAgentGenerator { "${this.packageName};${BuildConfig.VERSION_NAME};${BuildConfig.BUILD_TIME};Android;${Build.VERSION.SDK_INT}" }

		CovidCertificateSdk.init(this)
	}
}